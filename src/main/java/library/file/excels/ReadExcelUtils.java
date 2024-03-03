package library.file.excels;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelUtils {
    public static List<List<Object>> readExcel(String excelFilePath) {

        try {

            List<List<Object>> listRows = new ArrayList<>();

            // Get file
            InputStream inputStream = Files.newInputStream(new File(excelFilePath).toPath());

            // Get workbook
            Workbook workbook = getWorkbook(inputStream, excelFilePath);

            // Get sheet
            Sheet sheet = workbook.getSheetAt(0);

            // Get all rows
            for (Row nextRow : sheet) {
                if (nextRow.getRowNum() == 0) {
                    // Ignore header
                    continue;
                }

                // Get all cells
                Iterator<Cell> cellIterator = nextRow.cellIterator();

                // Read cells and set value for book object
                List<Object> listCells = new ArrayList<>();

                while (cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();
                    Object cellValue = getCellValue(cell);
                    if (cellValue == null || cellValue.toString().isEmpty()) {
                        listCells.add("");
                        continue;
                    }

                    listCells.add(cellValue);
                }

                listRows.add(listCells);
            }

            workbook.close();
            inputStream.close();

            return listRows;

        } catch (IOException ex) {
            System.out.println("Error" + ex.getMessage());
            return new ArrayList<>();
        }
    }

    // Get Workbook
    private static Workbook getWorkbook(InputStream inputStream, String excelFilePath) throws IOException {
        Workbook workbook = null;
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }

        return workbook;
    }

    // Get cell value
    private static Object getCellValue(Cell cell) {
        CellType cellType = cell.getCellType();
        Object cellValue = null;
        switch (cellType) {
            case BOOLEAN:
                cellValue = cell.getBooleanCellValue();
                break;
            case FORMULA:
                Workbook workbook = cell.getSheet().getWorkbook();
                FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                cellValue = evaluator.evaluate(cell).getNumberValue();
                break;
            case NUMERIC:
                cellValue = cell.getNumericCellValue();
                break;
            case STRING:
                cellValue = cell.getStringCellValue();
                break;
            case _NONE:
            case BLANK:
            case ERROR:
                break;
            default:
                break;
        }

        return cellValue;
    }
}
