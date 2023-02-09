package ed.interview.SimpleWebApp.service;

import ed.interview.SimpleWebApp.entity.User;
import ed.interview.SimpleWebApp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepo repo;
    @Override
    public void registerUser(User user) {
        repo.save(user);

    }
}
