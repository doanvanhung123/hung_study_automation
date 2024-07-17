package actions.utilities;

import actions.commons.GlobalConstants;
import com.poiji.bind.Poiji;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import testdata.People;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelHelper {
    XSSFWorkbook workbook = new XSSFWorkbook();
//    XSSFSheet spreadsheet = workbook.createSheet("JavaByKiran");

        public String[] ExcelToArrayConverter(String columnWanted,String sheetName){
            int i=0;
            String[] column_content_array =new String[140];
            try{
                int instindicator=-1;
                InputStream fileIn = new FileInputStream(GlobalConstants.UPLOAD_FILE_FOLDER +"ExcelTest.xlsx");
                XSSFWorkbook filename = new XSSFWorkbook(fileIn);
                XSSFSheet sheet = filename.getSheet(sheetName);                                                                                                // search for column index containing string "Inst_Code"
                Integer columnNo = null;
                Integer rowNo = null;
                List<Cell> cells = new ArrayList<Cell>();
                Row firstRow = sheet.getRow(0);
                for (Cell cell : firstRow) {
                    if (cell.getStringCellValue().equals(columnWanted)) {
                        columnNo = cell.getColumnIndex();
                        rowNo=cell.getRowIndex();
                    }
                }
                if (columnNo != null) {
                    for (Row row : sheet) {
                        Cell c = row.getCell(columnNo);
                        String cell_value=""+c;
                        cell_value=cell_value.trim();
                        try{
                            if((!cell_value.equals(""))&&(!cell_value.equals("null"))&&(!cell_value.equals(columnWanted))){
                                column_content_array[i]=cell_value;
                                i++;
                            }}
                        catch(Exception e){
                        }

                    }
                    return column_content_array;
                }}
            catch(Exception ex){
                ex.printStackTrace();
            }
            return column_content_array;
        }

        public static List<People> excelDataToListOfObjets_withPOIJI(String fileName){
            return Poiji.fromExcel(new File(GlobalConstants.UPLOAD_FILE_FOLDER + fileName), People.class);
        }


    public static void main(String[] args) {
        ExcelHelper excel = new ExcelHelper();
        String[] listExcelValue = excel.ExcelToArrayConverter("Name","People");
        System.out.println(listExcelValue[0]);
        System.out.println(listExcelValue[1]);

        List<People> peoList= excel.excelDataToListOfObjets_withPOIJI("ExcelTest.xlsx");
        System.out.println(peoList.get(0).getName());
    }

}
