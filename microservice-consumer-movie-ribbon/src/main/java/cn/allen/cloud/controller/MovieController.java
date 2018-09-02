package cn.allen.cloud.controller;

import cn.allen.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {
        return restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
    }

    @GetMapping("test")
    public String test() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("microservice-provider-user");
        System.out.println(serviceInstance.getUri()+"----------"+serviceInstance.getServiceId());
        ServiceInstance serviceInstance2 = loadBalancerClient.choose("microservice-provider-user2");
        System.out.println(serviceInstance2.getUri()+"----------"+serviceInstance2.getServiceId());
        return "1";
    }

    @GetMapping("/list-all")
    public List<User> listAll() {
        // wrong
        //    List<User> list = this.restTemplate.getForObject("http://microservice-provider-user/list-all", List.class);
        //    for (User user : list) {
        //      System.out.println(user.getId());
        //    }

        // right
        User[] users = this.restTemplate.getForObject("http://microservice-provider-user/list-all", User[].class);
        List<User> list2 = Arrays.asList(users);
        for (User user : list2) {
            System.out.println(user.getId());
        }

        return list2;
    }



}
