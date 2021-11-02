package com.shujiu.test.controller;

import com.shujiu.test.dto.Person;
import com.shujiu.test.dto.Response;
import com.shujiu.test.service.PersonService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 交藤
 * @since 2021/10/19
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @Resource
    private PersonService personService;

    @GetMapping("/{id}")
    public Response get(@PathVariable Long id) {
        return Response.success(personService.get(id));
    }

    @PostMapping("/add")
    public Response add(@RequestBody Person person) {
        Long id = personService.add(person);
        return Response.success(id);
    }
}
