package todo_list_demo.db;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import todo_list_demo.Models.Users;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class Db implements Idb {

  @PersistenceContext
  private EntityManager entityManager;

  @SuppressWarnings("unchecked")
  @Override
  public List<Users> getAllUsers() {
    String hql = "FROM Users as usr ORDER BY usr.id";
    return (List<Users>) entityManager.createQuery(hql).getResultList();
  }

  @Override
  public int getUsersBeEmailAndName(String firstName, String email) {
    String hql = "FROM Users as us WHERE us.firstName = ? and us.email = ?";
    return entityManager.createQuery(hql)
        .setParameter(1, firstName)
        .setParameter(2, email).getFirstResult();
  }

  @Override
  public Users getUserById(int id) {
    return entityManager.find(Users.class, id);
  }

  @Override
  public void addUser(Users user) {
    entityManager.persist(user);
  }

  @Override
  public void updateUser(Users user) {
    Users users = getUserById(user.getId());
    users.setFirstName(user.getFirstName());
    users.setLastName(user.getLastName());
    users.setEmail(user.getEmail());
    entityManager.flush();
  }

  @Override
  public void deleteUser(int userId) {
    entityManager.remove(userId);
  }

  @Override
  public boolean isUserExist(String firstName, String lastName) {
    String hql = "FROM Users as us WHERE us.firstName = ?";
    int count = entityManager.createQuery(hql).setParameter(1, firstName)
        .getResultList().size();
    return count > 0;
  }
}
