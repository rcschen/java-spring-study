- Beans.xml
  1.  \<bean class="com.example.beanpostprocessors.InitHelloWorld" /\>
  
```
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

   <bean id="helloWorld" class="com.example.beanpostprocessors.HelloWorld"
       init-method="init" destroy-method="destroy">
       <property name="message" value="Hello World!"/>
   </bean>

   <bean class="com.example.beanpostprocessors.InitHelloWorld" />

</beans>

```

- HelloWorld.java
```
package com.example.beanpostprocessors;

public class HelloWorld {
   private String message;

   public void setMessage(String message){
      this.message  = message;
   }

   public void getMessage(){
      System.out.println("Your Message : " + message);
   }

   public void init(){
      System.out.println("Bean is going through init.");
   }

   public void destroy(){
      System.out.println("Bean will destroy now.");
   }
}
```

- InitHelloWorld.java
  1. implement BeanPostProcessor
  2. Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException
  3. Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException
```
package com.example.beanpostprocessors;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.BeansException;

public class InitHelloWorld implements BeanPostProcessor {
 
   public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
      System.out.println("BeforeInitialization : " + beanName);
      return bean;  // you can return any other object as well
   }

   public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
      System.out.println("AfterInitialization : " + beanName);
      return bean;  // you can return any other object as well
   }

}
```

- MainApp.java
  1. context.registerShutdownHook
```
package com.example.beanpostprocessors;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {

      AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

      HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
      obj.getMessage();
      context.registerShutdownHook();
   }
}

```

