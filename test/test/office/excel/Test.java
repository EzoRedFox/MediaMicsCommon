package test.office.excel;

import com.mediamics.common.office.excel.Excel;
import test.office.excel.template.TestTemplate;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

/**
 *
 * @author Matsu
 */
public class Test {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws org.apache.poi.openxml4j.exceptions.InvalidFormatException
     */
    public static void main(String[] args) throws IOException, InvalidFormatException {

        try (Excel excel = new Excel("D:\\dev\\tmplate", "テスト.xlsx")) {
            TestTemplate temp = new TestTemplate();
            temp.setTest1("テスト１変換後");
            temp.setTest2("テスト２変換後");
            temp.setTest3("テスト３変換後");
            excel.replaceTemplate(temp);
            excel.saveTo("D:\\dev\\tmplate", "出力先.xlsx");
        }

    }

}
