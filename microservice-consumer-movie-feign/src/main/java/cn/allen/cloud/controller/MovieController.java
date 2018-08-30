package cn.allen.cloud.controller;

import cn.allen.cloud.entity.User;
import cn.allen.cloud.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {
        return userFeignClient.findById(id);
    }

    @GetMapping("testPost")
    public User testPost(User user) {
        return userFeignClient.postUser(user);
    }

    @GetMapping("testGet")
    public User testGet(User user) {
        return userFeignClient.getUser(user);
    }

}
