package todo_list_demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todo_list_demo.Models.Users;
import todo_list_demo.db.Idb;

import java.util.List;

@Service
public class UserService implements IUserService {

  @Autowired
  private Idb idb;

  @Override
  public List<Users> getAllUsers() {
    return idb.getAllUsers();
  }

  @Override
  public Users getUserById(int userId) {
    Users u = idb.getUserById(userId);
    return u;
  }

  @Override
  public int getUsersBeEmailAndName(String firstName, String email) {
    int num = idb.getUsersBeEmailAndName(firstName, email);
    return num;
  }

  @Override
  public synchronized boolean addUser(Users user) {
    if (idb.isUserExist(user.getFirstName(), user.getLastName())) {
      return false;
    } else {
      idb.addUser(user);
      return true;
    }
  }

  @Override
  public void updateUser(Users user) {
    idb.updateUser(user);
  }

  @Override
  public void deleteUser(int userId) {
    idb.deleteUser(userId);
  }
}
