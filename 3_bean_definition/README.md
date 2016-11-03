# Bean definition

| Properties               | Description                                                                                                                                                          |
|--------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| class                    | This attribute is mandatory and specify the bean class to be used to create the bean.                                                                                |
| name                     | This attribute specifies the bean identifier uniquely. In XML-based configuration metadata, you use the id and/or name attributes to specify the bean identifier(s). |
| scope                    | This attribute specifies the scope of the objects created from a particular bean definition and it will be discussed in bean scopes chapter.                         |
| constructor-arg          | This is used to inject the dependencies and will be discussed in next chapters.                                                                                      |
| properties               | This is used to inject the dependencies and will be discussed in next chapters.                                                                                      |
| autowiring mode          | This is used to inject the dependencies and will be discussed in next chapters.                                                                                      |
| lazy-initialization mode | A lazy-initialized bean tells the IoC container to create a bean instance when it is first requested, rather than at startup.                                        |
| initialization method    | A callback to be called just after all necessary properties on the bean have been set by the container. It will be discussed in bean life cycle chapter.             |
| destruction method       | A callback to be used when the container containing the bean is destroyed. It will be discussed in bean life cycle chapter.                                          |

# Spring Configuration Metadata

- three important methods to provide configuration metadata to the Spring Container:

 1. XML based configuration file.
 2. Annotation-based configuration
 3. Java-based configuration
 

- example
 
 ```
 <?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

   <!-- A simple bean definition -->
   <bean id="..." class="...">
       <!-- collaborators and configuration for this bean go here -->
   </bean>

   <!-- A bean definition with lazy init set on -->
   <bean id="..." class="..." lazy-init="true">
       <!-- collaborators and configuration for this bean go here -->
   </bean>

   <!-- A bean definition with initialization method -->
   <bean id="..." class="..." init-method="...">
       <!-- collaborators and configuration for this bean go here -->
   </bean>

   <!-- A bean definition with destruction method -->
   <bean id="..." class="..." destroy-method="...">
       <!-- collaborators and configuration for this bean go here -->
   </bean>

   <!-- more bean definitions go here -->

</beans>
```
