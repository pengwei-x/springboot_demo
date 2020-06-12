package com.peng.spring.service;

import com.peng.spring.entiy.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author pengwei
 * @date 2020/6/11
 */
/*@Component*/
public class PersonService {

    @Autowired
    private Person person;

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return "PersonService{" +
                "person=" + person +
                '}';
    }
}
