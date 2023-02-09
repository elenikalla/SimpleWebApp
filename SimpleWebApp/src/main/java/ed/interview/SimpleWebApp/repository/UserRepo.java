package ed.interview.SimpleWebApp.repository;

import ed.interview.SimpleWebApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,String>{

}
