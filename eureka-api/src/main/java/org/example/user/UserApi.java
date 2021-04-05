package org.example.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author 刘鹏
 * @Description
 * @date 2021-03-15 14:38
 */
public interface UserApi {

    @GetMapping("/user/{id}")
    User getUser(@PathVariable("id") String id) ;

    @GetMapping("/userList/{ids}")
    List<User> getUserList(@PathVariable("ids") List<String> ids);

}
