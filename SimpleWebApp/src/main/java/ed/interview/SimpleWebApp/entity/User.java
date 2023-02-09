package ed.interview.SimpleWebApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user register")
public class User {
    private String name;
    private String surname;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int userid;

    private String gender;
    private String birthdate;
    private String workAddress;
    private String homeAddress;


}
