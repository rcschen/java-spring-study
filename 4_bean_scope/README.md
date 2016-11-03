# Scope type

- The Spring Framework supports following five scopes, three of which are available only if you use a web-aware ApplicationContext.

| Scope          | Description                                                                                                                 |
|----------------|-----------------------------------------------------------------------------------------------------------------------------|
| singleton      | This scopes the bean definition to a single instance per Spring IoC container (default).                                    |
| prototype      | This scopes a single bean definition to have any number of object instances.                                                |
| request        | This scopes a bean definition to an HTTP request. Only valid in the context of a web-aware Spring ApplicationContext.       |
| session        | This scopes a bean definition to an HTTP session. Only valid in the context of a web-aware Spring ApplicationContext.       |
| global-session | This scopes a bean definition to a global HTTP session. Only valid in the context of a web-aware Spring ApplicationContext. |

- singlton
```
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

   <bean id="helloWorld" class="com.tutorialspoint.HelloWorld" 
      scope="singleton">
   </bean>

</beans>
```
- prototype

```
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

   <bean id="helloWorld" class="com.tutorialspoint.HelloWorld" 
      scope="prototype">
   </bean>

</beans>
```
