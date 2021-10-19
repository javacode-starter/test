package com.shujiu.test.controller;

import com.shujiu.test.dto.Person;
import org.springframework.web.bind.annotation.*;

/**
 * @author shujiu.cl
 * @since 2021/10/19
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @GetMapping("/")
    public Person get() {
        Person shujiu = new Person();
        shujiu.setName("树九");
        shujiu.setAge(25);
        return shujiu;
    }

    @PostMapping("/add")
    public void add(@RequestBody Person person) {
        System.out.println("name: " + person.getName() + ", age: " + person.getAge());
    }
}
