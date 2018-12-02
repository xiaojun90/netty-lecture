package com.joyxj.thrift;

import org.apache.thrift.TException;
import thrift.generated.Person;
import thrift.generated.PersonService;

/**
 * PersonService的实现类
 */
public class PersonServiceImpl implements PersonService.Iface {
    @Override
    public Person getPersonByName(String name) throws TException {
        Person person = new Person();
        person.setName(name);
        person.setAge(40);
        person.setMarried(true);
        return person;
    }

    @Override
    public boolean savePerson(Person person) throws TException {
        System.out.println(person.getName());
        System.out.println(person.getAge());
        System.out.println(person.isMarried());
        System.out.println("保存成功");
        return true;
    }
}
