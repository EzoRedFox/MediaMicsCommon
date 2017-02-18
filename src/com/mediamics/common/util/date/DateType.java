/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mediamics.common.util.date;

/**
 *
 * @author Matsu
 */
public enum DateType {
    
    yyyyMMddHHmmssSSS("yyyy/MM/dd HH:mm:ss.SSS")
    ,yyyyMMddHHmmssSSS_simple("yyyyMMddHHmmssSSS");
    
    private final String type;
    
    private DateType(String type){
        this.type = type;
    }
    
    @Override
    public String toString(){
        return type;
    }
}
