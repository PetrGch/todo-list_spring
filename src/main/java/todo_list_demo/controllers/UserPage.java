package todo_list_demo.controllers;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;

@Configuration
public class UserPage {

  @GetMapping("/")
  public String userPage() {
    return "index";
  }

}
