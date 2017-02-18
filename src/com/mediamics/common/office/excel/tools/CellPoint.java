/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mediamics.common.office.excel.tools;

/**
 *
 * @author Matsu
 */
public class CellPoint {
    public int rowIndex;
    public int columnIndex;
    
    public CellPoint(int rowIndex, int columnIndex){
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;      
    }
    
}
