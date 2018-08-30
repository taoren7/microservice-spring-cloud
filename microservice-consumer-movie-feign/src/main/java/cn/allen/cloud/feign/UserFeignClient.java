package cn.allen.cloud.feign;

import cn.allen.cloud.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("microservice-provider-user")
public interface UserFeignClient {

    @RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);

    @RequestMapping(value = "user", method = RequestMethod.POST)
    public User postUser(User user);

    //该方法运行不了
    @RequestMapping(value = "get-user", method = RequestMethod.GET)
    public User getUser(User user);

}
