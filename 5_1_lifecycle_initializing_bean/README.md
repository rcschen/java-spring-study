
- HelloWorld.java

```
package com.example.lifecycle.InitializingBean;

import org.springframework.beans.factory.InitializingBean;

public class HelloWorld implements InitializingBean {
   private String message;

   public void afterPropertiesSet() {
       System.out.println("this is after properties set");
   }

   public void setMessage(String message){
      this.message  = message;
   }

   public void getMessage(){
      System.out.println("Your Message : " + message);
   }
}
```

- Beans.xml
```
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

   <bean id="helloWorld" class="com.example.lifecycle.initializingbean.HelloWorld" 
      scope="singleton">
   </bean>

</beans>

```
