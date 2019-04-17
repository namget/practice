package com.namget.firstcitizen;

public class JavaSingleton {
    private static JavaSingleton instance;

    public static JavaSingleton getInstance() {
        synchronized (instance){
            if(instance == null){
                instance = new JavaSingleton();
            }
        }
        return instance;
    }
    public void getList(){
        //~~
    }


}
