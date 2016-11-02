* reference: https://www.tutorialspoint.com/spring/spring_hello_world_example.htm
* Beans.xml:
      ```
      <bean id="helloWorld" class="com.example.spring.HelloWorld"> 
      <property name="message" value="Hello World!"/>
      </bean>
      //property標籤中 value設定了希望注入至JavaBean的字串值
      ```

* HellWorld.java inject into MainApp.java
* MainApp.java:

       ```
       ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
       HelloWorld obj = (HelloWorld) context.getBean("helloWorld"); //helloWord is bean's id                                        
       obj.getMessage();
       ```
* HelloWorld.java:

       ```
       private String message;
       public void setMessage(String message) {
              this.message = message;
       }
       public void getMessage(){
              System.out.println("Your message: "+ this.message);
       }
       ```
