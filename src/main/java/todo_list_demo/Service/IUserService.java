package todo_list_demo.Service;


import todo_list_demo.Models.Users;

import java.util.List;

public interface IUserService {
  List<Users> getAllUsers();
  Users getUserById(int userId);
  int getUsersBeEmailAndName(String firstName, String email);
  boolean addUser(Users user);
  void updateUser(Users user);
  void deleteUser(int userId);
}
