package com.shujiu.test.service;

import com.shujiu.test.dao.PersonDAO;
import com.shujiu.test.dto.Person;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;

/**
 * @author shujiu.cl
 * @since 2021/11/2
 */
@Service
public class PersonService {

    @Resource
    private PersonDAO personDAO;


    public Person get(Long id) {
        return personDAO.get(id);
    }

    public Long add(Person person) {
        return personDAO.insert(person);
    }
}
