package org.aziz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by admin on 9/25/16.
 */
public class MainApp {

    public static void main(String[] args){

        AbstractApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");

        HelloWorld objA=(HelloWorld)context.getBean("helloWorld");

        objA.setMessage("I am object A");
        objA.getMessage();

        HelloWorld objB=(HelloWorld)context.getBean("helloWorld");

        objB.getMessage();

        context.registerShutdownHook();



    }
}
