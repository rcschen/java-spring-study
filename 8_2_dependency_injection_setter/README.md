![setter](https://github.com/rcschen/java-spring-study/blob/master/8_2_dependency_injection_setter/setter.jpg)
- MainApp.java
```
package com.example.dc.setter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      ApplicationContext context = 
             new ClassPathXmlApplicationContext("Beans.xml");

      TextEditor te = (TextEditor) context.getBean("textEditor");

      te.spellCheck();
   }
}

```
- SpellChecker.java
```
package com.example.dc.setter;


public class SpellChecker {
   public SpellChecker(){
      System.out.println("Inside SpellChecker constructor." );
   }

   public void checkSpelling() {
      System.out.println("Inside checkSpelling." );
   }
   
}

```

- TextEditor.java
  1. need setter and getter ( setSpellChecker, getSpellChecker)
```
package com.example.dc.setter;

public class TextEditor {
    private SpellChecker spellChecker;


    public void setSpellChecker(SpellChecker spellChecker) {
          System.out.println("Inside setSpellChecker." );
          this.spellChecker = spellChecker;
    }
    public SpellChecker getSpellChecker() {
           return spellChecker;
    }
    public void spellCheck() {
          spellChecker.checkSpelling();
    }
}

```

- Beans.xml
  1. \<property name="spellChecker" ref="spellChecker"/\> inject SpellCheck to setter's arg
```
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">
    
    <bean id="textEditor" class="com.example.dc.setter.TextEditor">
         <property name="spellChecker" ref="spellChecker"/>
    </bean>
    <bean id="spellChecker" class="com.example.dc.setter.SpellChecker"></bean>
</beans>

```
