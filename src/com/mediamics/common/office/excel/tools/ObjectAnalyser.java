package com.mediamics.common.office.excel.tools;

import com.mediamics.common.office.excel.ExcelTemplate;
import com.mediamics.common.office.excel.CellField;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Matsu
 */
public class ObjectAnalyser {

    private String sheetName;

    private List<CellFieldData> cellList;

    private class CellFieldData {

        private final String name;
        private final String value;

        private CellFieldData() {
            name = "";
            value = "";
        }

        private CellFieldData(Object object, Field field) {
            this.name = "$" + ((CellField) field.getAnnotation(CellField.class)).cell() + "$";
            String methodName = "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
            String valueString = "";
            try {
                valueString = object.getClass().getMethod(methodName).invoke(object).toString();
            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                // 値の取得に失敗した場合は何もしない
                // StreamAPIから呼ばれるための処置
            }
            this.value = valueString;
            
        }
        
        @Override
        public String toString(){
            return name + ":" + value;
        }
    }

    public ObjectAnalyser(Object target) {
        ExcelTemplate sheet = target.getClass().getAnnotation(ExcelTemplate.class);
        if(sheet==null){
            return;
        }
        sheetName = sheet.sheet();
        cellList = Stream.of(target.getClass().getDeclaredFields())
                .filter(f -> f.getAnnotation(CellField.class) != null)
                .map(f -> new CellFieldData(target, f))
                .collect(Collectors.toList());
        
        cellList.forEach(System.out :: println);

    }

    public String getSheetName() {
        return this.sheetName;
    }

    public String getCellValue(String cellName) {
        return cellList.stream()
                .filter(c -> c.name.equals(cellName))
                .findFirst()
                .orElse(new CellFieldData())
                .value;
    }
    

    }
