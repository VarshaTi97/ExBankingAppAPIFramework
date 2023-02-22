package utils;

import constants.FilePaths;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

public class ExcelUtility {

    @DataProvider(name="getAPiEndpointData")
    public Iterator<Object[]> getAPITestData(Method method) throws IOException{
        return excelApiData(FilePaths.excelSheetPath, method.getName());
    }

    public static final Iterator<Object[]> excelApiData(String excelSheetPath, String testCaseName) throws IOException {
        ArrayList<Object[]> apiRowData = new ArrayList<>();
        DataFormatter dataFormatter = new DataFormatter();
        FileInputStream fileInputStream = new FileInputStream(excelSheetPath);
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        String sheet = testCaseName.split("_")[1].replace("Test","");
        Sheet sheetName = workbook.getSheet(sheet);
        int columnCount = sheetName.getRow(0).getLastCellNum();
        int rowCount = sheetName.getLastRowNum();
        //Getting row data for testcases
        for(int i=1;i<rowCount;i++){
            Cell testCaseCell = sheetName.getRow(i).getCell(2);

            if(testCaseName.equalsIgnoreCase(testCaseCell.getStringCellValue())){
                Cell serviceBaseUrlCell = sheetName.getRow(i).getCell(3);
                Cell serviceEndpointCell = sheetName.getRow(i).getCell(4);
                Cell queryParameterNameCell = sheetName.getRow(i).getCell(5);
                Cell queryParameterValueCell = sheetName.getRow(i).getCell(6);
                Cell requestHeaderNameCell = sheetName.getRow(i).getCell(7);
                Cell requestHeaderValueCell = sheetName.getRow(i).getCell(8);
                Cell pathParameterNameCell = sheetName.getRow(i).getCell(9);
                Cell pathParameterValueCell = sheetName.getRow(i).getCell(10);
                Cell requestTypeCell = sheetName.getRow(i).getCell(11);
                Cell requestPayloadCell = sheetName.getRow(i).getCell(13);
                Cell statusCodeCell = sheetName.getRow(i).getCell(15);

                String queryParamNameArray[] = null;
                String queryParamValueArray[] = null;
                String headerNameArray[] = null;
                String headerValueArray[] = null;
                String pathParamNameArray[] = null;
                String pathParamValueArray[] = null;
                Map<String, String> queryParamMap = new LinkedHashMap<String, String>();
                Map<String, String> headerParamMap = new LinkedHashMap<String, String>();
                Map<String, String> pathParamMap = new LinkedHashMap<String, String>();

                if(!("NA".equalsIgnoreCase(queryParameterNameCell.getStringCellValue())) && !("NA".equalsIgnoreCase
                        (queryParameterValueCell.getStringCellValue()))){
                    queryParamNameArray = dataFormatter.formatCellValue(queryParameterNameCell).split("\\|");
                    queryParamValueArray = dataFormatter.formatCellValue(queryParameterValueCell).split("\\|");
                    for(int j=0;j<queryParamNameArray.length;j++){
                        queryParamMap.put(queryParamNameArray[j], queryParamValueArray[j]);
                    }
                }

                if(!("NA".equalsIgnoreCase(requestHeaderNameCell.getStringCellValue())) && !("NA".equalsIgnoreCase
                        (requestHeaderValueCell.getStringCellValue()))){
                    headerNameArray = dataFormatter.formatCellValue(requestHeaderNameCell).split("\\|");
                    headerValueArray = dataFormatter.formatCellValue(requestHeaderValueCell).split("\\|");
                    for(int j=0;j<headerNameArray.length;j++){
                        headerParamMap.put(headerNameArray[j], headerValueArray[j]);
                    }
                }

                if(!("NA".equalsIgnoreCase(pathParameterNameCell.getStringCellValue())) && !("NA".equalsIgnoreCase
                        (pathParameterValueCell.getStringCellValue()))){
                    pathParamNameArray = dataFormatter.formatCellValue(pathParameterNameCell).split("\\|");
                    pathParamValueArray = dataFormatter.formatCellValue(pathParameterValueCell).split("\\|");
                    for(int j=0;j<pathParamNameArray.length;j++){
                        pathParamMap.put(pathParamNameArray[j], pathParamValueArray[j]);
                    }
                }
                Object dataObject[] = {serviceBaseUrlCell.getStringCellValue()+serviceEndpointCell.getStringCellValue(),
                        requestTypeCell.getStringCellValue(), headerParamMap, queryParamMap, pathParamMap,
                        (int) statusCodeCell.getNumericCellValue(),
                         requestPayloadCell.getStringCellValue()
                };
                apiRowData.add(dataObject);
                break;
            }

        }
        workbook.close();
        return apiRowData.iterator();
    }
}
