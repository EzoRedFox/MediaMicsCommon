/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mediamics.common.logger;

import com.mediamics.common.exception.ServiceRuntimeException;

/**
 *
 * @author Matsu
 */
public class Log {
    
    public void info(String message){
        System.out.println(message);
    }
    
    public void error(String message){
        System.out.println(message);
    }
    
    public void error(Throwable ex){
        error(null, new ServiceRuntimeException(ex));
    }
    
    public void error(String message, Throwable ex){
        error(message, new ServiceRuntimeException(ex));
        
    }
    
    public void error(String message, ServiceRuntimeException ex){
        if(message != null){
            System.out.println(message);
        }
        ex.getMessages().forEach(System.out::println);
    }
    
    
}
