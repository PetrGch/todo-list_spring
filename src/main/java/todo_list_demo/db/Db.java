package todo_list_demo.db;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import todo_list_demo.Models.Users;

@Controller
@Lazy
public class Db {

  private SessionFactory sessionFactory;
  private Session session;

  private Users user;

  public Db(Users u) {
    this.user = u;
    sessionFactory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Users.class)
        .buildSessionFactory();

    session = sessionFactory.getCurrentSession();
  }

  @Bean
  public Db initDb() {
    user = new Users();
    return new Db(user);
  }

  public void addNewUser(String name, String surname, String email, String password) {
    System.out.println("hi there new user. Your parameters are: name - " + name
        + ", surname - " + surname + ", email - " + email + ", password - " + password);

    user.setFirstName(name);
    user.setLastName(surname);
    user.setEmail(email);
    user.setPassword(password);

    try {
      session.beginTransaction();
      session.save(user);
      session.getTransaction().commit();
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
      sessionFactory.close();
    }

    System.out.println(user);
  }

}
