package com.rest.datapool;

import java.util.Date;

/**
 * To generate an unique ID series for customer ID field
 * 
 * @author Ping Yang(Kevin) Wei
 * @since 2015-09-02
 */
public final class IdFactory {

    private static final int timeout = 1000*30;
    private int increment = 0;
    private Date date = new Date();
    private static IdFactory instance;

    private IdFactory(){}

    public static IdFactory getInstance(){
        if(instance==null){
           instance =  new IdFactory();
        }else{
            if(((new Date()).getTime() - instance.date .getTime())>timeout || instance.increment >=9){
                instance.date = new Date();
            }
        }
        return instance;
    }

    public synchronized String generate(){
        long code = date.getTime() ;
        return ""+code+(increment++);
    }

    public static void main(String[] a){
    	//For Debugging Purpose
        System.out.println(IdFactory.getInstance() .generate() );
        System.out.println(IdFactory.getInstance() .generate() );
        System.out.println(IdFactory.getInstance() .generate() );
        System.out.println(IdFactory.getInstance() .generate() );
        System.out.println(IdFactory.getInstance() .generate() );

    }

}
