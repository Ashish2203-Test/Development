package org.aziz;

public class HelloWorld {

    private String message;

    public void setMessage(String message){
        this.message=message;
    }

    public void getMessage(){
        System.out.println("Message: "+this.message);
    }

    public void init(){
        System.out.println("Bean is going through init");
    }

    public void destroy(){
        System.out.println("Bean will be destroyed");
    }
}
