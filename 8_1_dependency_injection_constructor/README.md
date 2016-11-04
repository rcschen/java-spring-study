![alt tag](https://github.com/rcschen/java-spring-study/blob/master/8_1_dependency_injection_constructor/conType.jpg)

- MainApp.java
```
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

```
- SpellChecker.java
```
package com.example.dc.constructor;

class SpellChecker {
      public SpellChecker() {
           System.out.println("Inside SpellChecker Constructor.");
      }
      public void checkSpelling() {
          System.out.println("Inside checkSpelling." );
      }
}

```
- TextEditor.java
  1. need constructor arg to receive spellChecker
```
package com.example.dc.constructor;

class TextEditor {
      private SpellChecker spellChecker;
      public TextEditor( SpellChecker spellChecker) {
             System.out.println("Inside TextEditor constructor.");
             this.spellChecker = spellChecker;
      }
      public void spellCheck() {
             spellChecker.checkSpelling();
      }
}

```
- Beans.xml
  1. <constructor-arg ref="spellChecker"/> inject spellChecker to constructor-arg
```
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">
   
    <bean id="textEditor" class="com.example.dc.constructor.TextEditor">
       <constructor-arg ref="spellChecker"/>
    </bean>
    <bean id="spellChecker" class="com.example.dc.constructor.SpellChecker">
    </bean>

</beans>

```
