package dda;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import myBean.mission;
import myUtil.dateUtil;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;

public class dailyReport {
	public static void main(String args[]){
		String theDay=null;
		String today=null;
		if(dateUtil.isMonday()){
			System.out.println("true");
			theDay=dateUtil.getDate(dateUtil.getDayAfter(-3),"yyyyMMdd");
		}else{
			theDay=dateUtil.getDate(dateUtil.getDayAfter(-1),"yyyyMMdd");
		}
		today=dateUtil.getDate(null, "yyyy年-MM月-dd日");
		System.out.println(today);
        String fileToBeRead = "D://信用度项目工作日报-付洋-"+theDay+".xls"; // excel位置
        int rowNum = 6; // 获取第6行
        try {
            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(fileToBeRead));
            HSSFSheet sheet = workbook.getSheet("Sheet1");//读取sheet1	
            int sheetMergeCount = sheet.getNumMergedRegions();
            mission firstMission=null;
            mission secondMission=null;
            mission thirdMission=null;
            boolean isContinue=true;
            int startRow=8;
            int startColumn=1;
            int firstRow=0;
            int firstColumn=0;
            for (int i=0;i<100&&isContinue;i++){
            	firstRow=startRow+i;
            	firstColumn=startColumn;
            	//第一个任务
            	firstMission=new mission(sheet.getRow(firstRow).getCell(firstColumn).getStringCellValue().trim());
            	firstMission.setMissionContent(sheet.getRow(firstRow).getCell(firstColumn+3).getStringCellValue().trim());
            	firstMission.setStatus(sheet.getRow(firstRow).getCell(firstColumn+5).getStringCellValue().trim());
            	firstMission.setStatus(sheet.getRow(firstRow).getCell(firstColumn+6).getStringCellValue().trim());
            	/*if("否".equals(sheet.getRow(firstRow).getCell(firstColumn+7).getStringCellValue().trim())){
            		firstMission.setIsLate(false);
            	}*/
            	/*firstMission.setMissionStartTime(sheet.getRow(firstRow).getCell(firstColumn+8).getStringCellValue().trim());
            	firstMission.setMissionEndTime(sheet.getRow(firstRow).getCell(firstColumn+9).getStringCellValue().trim());
            	firstMission.setMissionRealStartTime(sheet.getRow(firstRow).getCell(firstColumn+10).getStringCellValue().trim());
            	firstMission.setMissionRealEndTime(sheet.getRow(firstRow).getCell(firstColumn+11).getStringCellValue().trim());

            	*/
            	
            	
            	if("".equals(firstMission.getMissionName())&&!(firstMission.getMissionName()!=null)){
            		isContinue=false;
            	}
            	firstMission.setMissionContent(sheet.getRow(firstRow).getCell(firstColumn+3).getStringCellValue());
            	System.out.println(firstMission.getMissionName());
            	System.out.println("firstMission.getMissionContent()"+firstMission.getMissionContent());
            	
            } 
            
            
            
            
            
            String excelDay=sheet.getRow((short)5).getCell((short) 0).getStringCellValue();
            System.out.println(excelDay);
            System.out.println(firstMission);
            System.out.println(sheetMergeCount);
            
            
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
               /* HSSFRow row = sheet.getRow((short) i);
            	HSSFCell cell = row.getCell((short) 0);
            	if(i==5){
            		String cellValue=cell.getStringCellValue();
                	System.out.println(cellValue);
            	}*/
/*                
                if (null == row) {
                    continue;
                } else {
	                HSSFCell cell = row.getCell((short) 3);
	                if (null == cell) {
	                    continue;
	                } else {
	                    System.out.println(cell.getStringCellValue());
	                    int temp = Integer.parseInt(cell.getStringCellValue());
	                    cell.setCellValue(temp + 1);
	                }
                }
*/            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
