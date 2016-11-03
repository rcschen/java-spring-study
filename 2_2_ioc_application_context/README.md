- HelloWorld.java
```
package com.example.applicationcontext;

public class HelloWorld {
   private String message;

   public void setMessage(String message){
      this.message  = message;
   }

   public void getMessage(){
      System.out.println("Your Message : " + message);
   }
}
```

- MainApp.java
**(use ClassPathXmlApplicationContext or FileSystemXmlApplicationContext)**
```
package com.example.applicationcontext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class MainApp {
   public static void main(String[] args) {

      //ApplicationContext context = new FileSystemXmlApplicationContext("src/other/Beans.xml");
      ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

      HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
      obj.getMessage();
   }
}
```
  >- use default path (src\main\resources)
  
  >```
  ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
  >```
  >- use customized path (src/other/Beans.xml, can not locate at path rooted at src)
  
  >```
  ApplicationContext context = new FileSystemXmlApplicationContext("src/other/Beans.xml");
  >```

- Beans.xml
```
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

   <bean id="helloWorld" class="com.example.ioc.beanfactory.HelloWorld">
       <property name="message" value="Hello World!"/>
   </bean>
</beans>
```
