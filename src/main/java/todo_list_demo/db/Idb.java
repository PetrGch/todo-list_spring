package todo_list_demo.db;

import todo_list_demo.Models.Users;

import java.util.List;

/**
 * Created by petr on 20.12.17.
 */
public interface Idb {
  List<Users> getAllUsers();
  int getUsersBeEmailAndName(String firstName, String email);
  Users getUserById(int userId);
  void addUser(Users user);
  void updateUser(Users user);
  void deleteUser(int userId);
  boolean isUserExist(String firstName, String lastName);
}
