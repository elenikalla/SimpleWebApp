package ed.interview.SimpleWebApp.service;

import ed.interview.SimpleWebApp.DTO.UserDTO;
import ed.interview.SimpleWebApp.entity.User;

import java.util.List;

public interface UserService {

//    void registerUser(User user);
    UserDTO createUser(UserDTO customer);
    List<UserDTO> readUser();
    UserDTO readUser(int id) throws Exception;

}
