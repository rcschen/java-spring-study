package com.example.lifecycle.initializingbean;

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
