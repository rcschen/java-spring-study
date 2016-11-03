- HelloWorld.java (init(), destroy())

```
public class HelloWorld {
   private String message;
   public void init() {
      System.out.println("==== This is init ====");

   }
   public void destroy() {
      System.out.println("==== This is destroy ====");

   }
   public void setMessage(String message){
      this.message  = message;
   }

   public void getMessage(){
      System.out.println("Your Message : " + message);
   }
}
```

- MainApp.java (context.registerShutdownHook();)

```
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      //ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
      AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

      HelloWorld objA = (HelloWorld) context.getBean("helloWorld");

      objA.setMessage("I'm object A");
      objA.getMessage();
      context.registerShutdownHook();

   }
}
```
- Beans.xml ( init-method="init" destroy-method="destroy")

```
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

   <bean id="helloWorld" 
       class="com.example.lifecycle.initializingcallback.HelloWorld"
       init-method="init" destroy-method="destroy">
       <property name="message" value="Hello World!"/>
   </bean>

</beans>

```
