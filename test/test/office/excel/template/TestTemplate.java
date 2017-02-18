/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.office.excel.template;

import com.mediamics.common.office.excel.CellField;
import com.mediamics.common.office.excel.ExcelTemplate;

/**
 *
 * @author Matsu
 */
@ExcelTemplate(sheet = "テストシート")
public class TestTemplate {

    @CellField(cell = "TEST1")
    private String test1;

    @CellField(cell = "TEST2")
    private String test2;

    @CellField(cell = "TEST3")
    private String test3;

    public String getTest1() {
        return test1;
    }

    public void setTest1(String test1) {
        this.test1 = test1;
    }

    public String getTest2() {
        return test2;
    }

    public void setTest2(String test2) {
        this.test2 = test2;
    }

    public String getTest3() {
        return test3;
    }

    public void setTest3(String test3) {
        this.test3 = test3;
    }

}
