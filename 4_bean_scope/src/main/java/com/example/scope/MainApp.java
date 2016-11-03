package com.example.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      //ApplicationContext context = new ClassPathXmlApplicationContext("Beans-singlton.xml");
      ApplicationContext context = new ClassPathXmlApplicationContext("Beans-prototype.xml");
      HelloWorld objA = (HelloWorld) context.getBean("helloWorld");
      objA.getMessage();
      objA.setMessage("I'm object A");
      objA.getMessage();
      
      System.out.println("it's B's turn");
      HelloWorld objB = (HelloWorld) context.getBean("helloWorld");
      objB.getMessage();
   }
}
