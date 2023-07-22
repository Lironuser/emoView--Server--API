package user;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table
@Data
public class UserInfo {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String fname;
    private String lname;
    private String nickname;
    private String mail;
    private String secretKey;
    private LocalDate dob;

    public UserInfo() {
    }

    public UserInfo(Long id, String fname, String lname, String nickname, String mail, String secretKey, LocalDate dob) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.nickname = nickname;
        this.mail = mail;
        this.secretKey = secretKey;
        this.dob = dob;
    }

    public UserInfo(String fname, String lname, String nickname, String mail, String secretKey, LocalDate dob) {
        this.fname = fname;
        this.lname = lname;
        this.nickname = nickname;
        this.mail = mail;
        this.secretKey = secretKey;
        this.dob = dob;
    }

}
