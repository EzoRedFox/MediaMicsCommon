package com.mediamics.common.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Matsu
 */
public class ServiceRuntimeException extends RuntimeException{
    
    public Exception exception;
    
    public ServiceRuntimeException(String message, Exception exception){
        super(message);
        this.exception = exception;
    }
    
    public List<String> getMessages(){
        List<String> list = new ArrayList<>();
        list.add("エラーが発生しました。 : " + getMessage());
        list.add(exception.getClass().getName() + " : " + exception.getMessage());
        list.addAll(Stream.of(exception.getStackTrace()).map( e -> "  at " + e.toString() ).collect( Collectors.toList() ));
        return list;
    }
    
    
}
