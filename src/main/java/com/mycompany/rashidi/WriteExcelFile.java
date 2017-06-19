package com.mycompany.rashidi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mehdi
 */
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
/**
 * Created by anirudh on 23/10/14.
 */
public class WriteExcelFile {
    private static final String FILE_PATH = "/home/mehdi/testWriteStudents.xls";
    //We are making use of a single instance to prevent multiple write access to same file.
    private static final WriteExcelFile INSTANCE = new WriteExcelFile();
 
    public static WriteExcelFile getInstance() {
        return INSTANCE;
    }
 
    public WriteExcelFile() {
    }
 
/*    public static void main(String args[]){
 
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student("Magneto","90","100","80"));
        studentList.add(new Student("Wolverine","60","60","90"));
        studentList.add(new Student("ProfX","100","100","100"));
 
        writeStudentsListToExcel(studentList);
 
    }
 */
    public  void writeListToExcel(List<List<String>> sheet){
 
        // Using XSSF for xlsx format, for xls use HSSF
        Workbook workbook = new XSSFWorkbook();
 
        Sheet studentsSheet = workbook.createSheet("Students");
 
        int rowIndex = 0;
        for(List<String> rows: sheet){
            Row row = studentsSheet.createRow(rowIndex++);
            int cellIndex = 0;
            
            for(String cell : rows){
                row.createCell(cellIndex++).setCellValue(cell);
                
            }
        }
 
        //write this workbook in excel file.
        try {
            FileOutputStream fos = new FileOutputStream(FILE_PATH);
            workbook.write(fos);
            fos.close();
 
            System.out.println(FILE_PATH + " is successfully written");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
 
 
    }
}
