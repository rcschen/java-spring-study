package com.example.dc.constructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

 
class MainApp {
    public static void main(String[] args) {
           ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
           TextEditor te = (TextEditor) context.getBean("textEditor");
           te.spellCheck();
    }
}
