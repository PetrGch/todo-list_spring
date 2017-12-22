package todo_list_demo.controllers.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import todo_list_demo.Models.Users;
import todo_list_demo.Service.IUserService;
import todo_list_demo.db.Db;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@RequestMapping("/api")
public class ApiController {

  @Autowired
  private IUserService iUserService;

  @GetMapping("/users")
  public ResponseEntity<List<Users>> getAllUsers() {
    List<Users> list = iUserService.getAllUsers();
    return new ResponseEntity<List<Users>>(list, HttpStatus.OK);
  }

  @GetMapping("/users/{id}")
  public ResponseEntity<Users> getUserById(@PathVariable("id") Integer id) {
    Users users = iUserService.getUserById(id);
    return new ResponseEntity<Users>(users, HttpStatus.OK);
  }

  @PostMapping(value = "/users")
  public @ResponseBody ResponseEntity<Void> addUser(Users users, UriComponentsBuilder builder) {
    boolean flag = iUserService.addUser(users);

    if (flag == false) {
      return new ResponseEntity<Void>(HttpStatus.CONFLICT);
    } else {
      HttpHeaders headers = new HttpHeaders();
      headers.setLocation(builder.path("/users/{id}").buildAndExpand(users.getId()).toUri());
      return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
  }

  @PutMapping("/users")
  public ResponseEntity<Users> updateUser(@RequestBody Users users) {
    iUserService.updateUser(users);
    return new ResponseEntity<Users>(users, HttpStatus.OK);
  }

  @DeleteMapping("/users/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
    iUserService.deleteUser(id);
    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
  }

  @GetMapping("/users/test")
  public ResponseEntity<Integer> getUsersBeEmailAndName(@RequestParam(name = "name", required = false, defaultValue = "petr") String name,
                                                        @RequestParam(name = "email", required = false, defaultValue = "asdf") String email) {
    int num = iUserService.getUsersBeEmailAndName(name, email);

    return new ResponseEntity<Integer>(num, HttpStatus.OK);
  }

}
