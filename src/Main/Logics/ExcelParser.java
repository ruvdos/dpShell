package Main.Logics;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

// https://javadevblog.com/rabotaem-s-excel-v-java.html
public class ExcelParser {

    public static String parse(String fullPath) {
        String exp = ReadFilesFromFolder.getFileExtension(fullPath);
        if (exp != null && exp.equals(".xlsx")) {
            return parseNew(fullPath);
        }
        if (exp != null && exp.equals(".xls")) {
            return parseOld(fullPath);
        }
        return "";
    }


    public static String parseOld(String fullPath) {
        //инициализируем потоки
        String result = "";
        InputStream inputStream = null;
        HSSFWorkbook workBook = null;
        try {
            inputStream = new FileInputStream(fullPath);
            workBook = new HSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //разбираем первый лист входного файла на объектную модель
        Sheet sheet = workBook.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();
        //проходим по всему листу
        while (it.hasNext()) {
            Row row = it.next();
            Iterator<Cell> cells = row.iterator();
            while (cells.hasNext()) {
                Cell cell = cells.next();
                CellType cellType = cell.getCellType();
                //перебираем возможные типы €чеек
                switch (cellType) {
                    case STRING:
                        result += cell.getStringCellValue() + "=";
                        break;
                    case NUMERIC:
                        result += "[" + cell.getNumericCellValue() + "]";
                        break;

                    case FORMULA:
                        result += "[" + cell.getNumericCellValue() + "]";
                        break;
                    default:
                        result += "|";
                        break;
                }
            }
            result += "\n";
        }

        return result;
    }


    public static String parseNew(String fullPath) {
        //инициализируем потоки
        String result = "";
        InputStream inputStream = null;
        XSSFWorkbook workBook = null;
        try {
            inputStream = new FileInputStream(fullPath);
            workBook = new XSSFWorkbook(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //разбираем первый лист входного файла на объектную модель
        Sheet sheet = workBook.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();
        //проходим по всему листу
        while (it.hasNext()) {
            Row row = it.next();
            Iterator<Cell> cells = row.iterator();
            while (cells.hasNext()) {
                Cell cell = cells.next();
                CellType cellType = cell.getCellType();
                //перебираем возможные типы €чеек
                switch (cellType) {
                    case STRING:
                        result += cell.getStringCellValue() + "=";
                        break;
                    case NUMERIC:
                        result += "[" + cell.getNumericCellValue() + "]";
                        break;

                    case FORMULA:
                        result += "[" + cell.getNumericCellValue() + "]";
                        break;
                    default:
                        result += "|";
                        break;
                }
            }
            result += "\n";
        }

        return result;
    }


}