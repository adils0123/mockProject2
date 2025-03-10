package utility;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
    public static String getCellValue(String filePath, String sheetName, int row, int col) throws IOException {
        FileInputStream fis = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(sheetName);
        Row dataRow = sheet.getRow(row);
        Cell cell = dataRow.getCell(col);
        String value = cell.getStringCellValue();
        workbook.close();
        fis.close();
        return value;
    }
}
