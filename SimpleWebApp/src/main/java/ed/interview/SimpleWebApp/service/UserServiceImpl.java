package ed.interview.SimpleWebApp.service;

import ed.interview.SimpleWebApp.DTO.UserDTO;
import ed.interview.SimpleWebApp.entity.User;
import ed.interview.SimpleWebApp.repository.UserRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService{
    private final UserRepo repo;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        //validation
        User user = userDTO.asUser();
        return new UserDTO(repo.save(user)) ;
    }
    @Override
    public List<UserDTO> readUser() {
        return repo
                .findAll()
                .stream()
                .map(UserDTO::new)
                .collect(Collectors.toList());
    }
    @Override
    public UserDTO readUser(int id) throws Exception {
        return new UserDTO(readCustomerDb(id));
    }

    private User readCustomerDb(int id) throws Exception {
        Optional<User> userOptional = repo.findById(String.valueOf(id));
        if (userOptional.isPresent())
            return  userOptional.get() ;
        throw new Exception("Customer not found id= " + id);
    }
}
