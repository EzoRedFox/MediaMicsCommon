/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mediamics.common.office.excel.tools;

import org.apache.poi.ss.usermodel.Cell;

/**
 *
 * @author Matsu
 */
public class CellData {
    
    private final String key;
    private final CellPoint point;
    
    public CellData(Cell cell){
        this.key = cell.toString();
        this.point = new CellPoint(cell.getRowIndex(),cell.getColumnIndex());
    }

    public String getKey() {
        return key;
    }

    public int getRowIndex(){
        return point.rowIndex;
    }
    
    public int getColumnIndex(){
        return point.columnIndex;
    }
  
    
}
