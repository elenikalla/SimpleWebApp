package ed.interview.SimpleWebApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user_register")
@SecondaryTable(name = "addresses", pkJoinColumns = @PrimaryKeyJoinColumn(name = "userid"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid;
    private String name;
    private String surname;
    private String gender;
    private String birthdate;
    @Column(name = "homeAddress", table = "addresses")
    private String homeAddress;
    @Column(name = "workAddress", table = "addresses")
    private String workAddress;

}

