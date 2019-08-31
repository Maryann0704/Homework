package by.pvt.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    public String getEmailByUserName(String userName) {
        return "user_name@mail.ru";
    }
}
