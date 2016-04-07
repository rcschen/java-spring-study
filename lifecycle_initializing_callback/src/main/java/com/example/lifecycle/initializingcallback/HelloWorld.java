package com.example.lifecycle.initializingcallback;

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
