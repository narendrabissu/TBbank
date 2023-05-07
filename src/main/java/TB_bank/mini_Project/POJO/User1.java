package TB_bank.mini_Project.POJO;


import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.util.Date;


@NamedQuery(name = "User1.findByEmailId",query = "select u from User1 u where u.email =:email")

@Data
@RequiredArgsConstructor
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "user1")
public class User1 implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private String status;

    @Column(name = "role")
    private String role;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "dateOfBirth")
    private String dateOfBirth;


}













//In this version of the User class, each field has a corresponding @Column







