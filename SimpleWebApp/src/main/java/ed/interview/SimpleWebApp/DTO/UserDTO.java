package ed.interview.SimpleWebApp.DTO;

import ed.interview.SimpleWebApp.entity.User;
import lombok.*;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class UserDTO {

    private int userid;
    private String name;
    private String surname;
    private String gender;
    private String birthdate;
    private String homeAddress;
    private String workAddress;

        public UserDTO(User user){
            if (user!= null){
                userid = user.getUserid();
                name = user.getName();
                surname = user.getSurname();
                birthdate = user.getBirthdate();
                gender = user.getGender();
                homeAddress = user.getHomeAddress();
                workAddress = user.getWorkAddress();
            }
        }
        public User asUser(){
            User user = new User();
            user.setUserid(userid);
            user.setName(name);
            user.setSurname(surname);
            user.setGender(gender);
            user.setBirthdate(birthdate);
            user.setHomeAddress(homeAddress);
            user.setWorkAddress(workAddress);
            return user;
        }
}
