package com.trafficstatus.trafficstatus.controller;

import com.trafficstatus.trafficstatus.DAO.UserRepository;
import com.trafficstatus.trafficstatus.DTO.HelloWsDTO;
import com.trafficstatus.trafficstatus.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ContentController {

    private static final String contentTemplate = "Hello, tarane! %s" ;
    private final AtomicLong contentCounter = new AtomicLong();

    private UserRepository userRepository;
    @GetMapping("/salut")
    public HelloWsDTO helloCall(@RequestParam(value = "name", defaultValue = "Merge Treaba?") String name){
        return new HelloWsDTO(String.format(contentTemplate, name), (contentCounter.incrementAndGet()));
    }

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String name
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }
}
