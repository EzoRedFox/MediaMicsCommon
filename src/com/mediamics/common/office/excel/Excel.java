/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mediamics.common.office.excel;

import com.mediamics.common.office.excel.tools.CellData;
import com.mediamics.common.office.excel.tools.ObjectAnalyser;
import com.mediamics.common.util.file.ExtensionFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

/**
 *
 * @author Matsu
 */
public class Excel implements AutoCloseable {

    private final Workbook workbook;
    
    private final ExtensionFile tmpFile;

    private final Map<String, List<CellData>> map;

    public Excel(String parentPath, String... filePath) throws IOException, InvalidFormatException {
        this(Paths.get(parentPath, filePath).toFile());
    }

    public Excel(File file) throws IOException, InvalidFormatException {
        tmpFile = new ExtensionFile(file).getTempFile();
        workbook = WorkbookFactory.create(tmpFile.toFile());
        map = new HashMap<>();
        for (Sheet sheet : workbook) {
            List<CellData> sheetData = new ArrayList<>();
            for (Row row : sheet) {
                for (Cell cell : row) {
                    if (cell.toString().matches("^\\$.+\\$$")) {
                        sheetData.add(new CellData(cell));
                    }
                }
            }
            map.put(sheet.getSheetName(), sheetData);
        }
    }

    /**
     * 現在開かれているファイルをリネームして保存する
     *
     * @param parentPath
     * @param fileNm
     */
    public void saveTo(String parentPath, String fileNm) throws IOException {
        try (FileOutputStream out = new FileOutputStream(new File(parentPath, fileNm))) {
            workbook.write(out);
        }
    }

    @Override
    public void close() throws IOException {
        workbook.close();
        tmpFile.delete();
    }

    public void replaceTemplate(Object replaceObject) {

        ObjectAnalyser ana = new ObjectAnalyser(replaceObject);
        Sheet sheet = workbook.getSheet(ana.getSheetName());
        map.get(ana.getSheetName()).forEach(c -> sheet.getRow(c.getRowIndex()).getCell(c.getColumnIndex()).setCellValue(ana.getCellValue(c.getKey())));

    }

}
