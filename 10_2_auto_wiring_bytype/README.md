- Beans.xml
  1. \<bean id="textEditor" class="com.example.autowiring.bytype.TextEditor" autowire="byType"\>
  2. spellChecker is autowired by type
  
```
<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd">

   <!-- Definition for textEditor bean -->
   <bean id="textEditor" class="com.example.autowiring.bytype.TextEditor" 
      autowire="byType">
      <property name="name" value="Generic Text Editor" />
   </bean>

   <!-- Definition for spellChecker bean -->
   <bean id="SpellChecker" class="com.example.autowiring.bytype.SpellChecker">
   </bean>

</beans>

```

- MainApp.java
```
package com.example.autowiring.bytype;

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
package com.example.autowiring.bytype;

public class SpellChecker {
   public SpellChecker() {
      System.out.println("Inside SpellChecker constructor." );
   }

   public void checkSpelling() {
      System.out.println("Inside checkSpelling." );
   }
   
}

```
- TextEditor.java
```
package com.example.autowiring.bytype;

public class TextEditor {
   private SpellChecker spellChecker;
   private String name;

   public void setSpellChecker( SpellChecker spellChecker ){
      this.spellChecker = spellChecker;
   }
   public SpellChecker getSpellChecker() {
      return spellChecker;
   }

   public void setName(String name) {
      this.name = name;
   }
   public String getName() {
      return name;
   }

   public void spellCheck() {
      spellChecker.checkSpelling();
   }
}

```
