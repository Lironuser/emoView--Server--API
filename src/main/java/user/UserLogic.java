package user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class UserLogic {
    public List<UserInfo> getUser(){
        return List.of(
                new UserInfo(
                        1L,
                        "Liron",
                        "Solomon",
                        "Lironuser",
                        "lironuser@gmail.com",
                        "gsfgsg",
                        LocalDate.of(2004, Month.DECEMBER, 1)
                )
        );
    }
}
