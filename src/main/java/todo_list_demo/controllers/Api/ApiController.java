package todo_list_demo.controllers.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import todo_list_demo.db.Db;

@Controller
@RequestMapping("/api")
public class ApiController {

  @Autowired
  private Db db;

  @RequestMapping("/registration")
  public @ResponseBody String registration(@RequestParam(value = "firstName", required = true) String name,
                      @RequestParam(value = "lastName", required = false, defaultValue = "") String surname,
                      @RequestParam(value = "email", required = true) String email,
                      @RequestParam(value = "password", required = true) String password) {

    db.initDb().addNewUser(name, surname, email, password);

    return "hi there new user. Your parameters are: name - " + name
        + ", surname - " + surname + ", email - " + email + ", password - " + password;
  }


}
