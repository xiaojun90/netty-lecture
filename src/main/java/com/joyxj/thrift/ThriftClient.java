package com.joyxj.thrift;

import org.apache.thrift.TException;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import thrift.generated.Person;
import thrift.generated.PersonService;

/**
 * Thrift客户端
 */
public class ThriftClient {

    public static void main(String[] args) throws TException {
        TTransport transport = new TFramedTransport(new TSocket("localhost",8899),600);
        TProtocol protocol = new TCompactProtocol(transport);
        PersonService.Client client = new PersonService.Client(protocol);

        transport.open();

        Person person = client.getPersonByName("张三");
        System.out.println(person.getAge());
        System.out.println(person.isMarried());

        Person person2 = new Person();
        person2.setName("李四");
        person2.setAge(35);
        person2.setMarried(false);
        client.savePerson(person2);
    }
}
