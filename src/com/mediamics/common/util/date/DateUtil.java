/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mediamics.common.util.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Matsu
 */
public class DateUtil {
    
    public static String getNowDate(DateType type){
        return new SimpleDateFormat(type.toString()).format(new Date());
        
    }

}
