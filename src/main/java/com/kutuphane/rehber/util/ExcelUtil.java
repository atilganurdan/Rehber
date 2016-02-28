/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kutuphane.rehber.util;

import com.kutuphane.rehber.data.dto.Kisi;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author vektorel
 */


/**
 *
 * @author vektorel
 */
public class ExcelUtil {

    public void importFromExcel() {
        try {
            FileInputStream file = new FileInputStream(new File("C:\\TT\\A.xls"));
            HSSFWorkbook workbook = new HSSFWorkbook(file);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t\t");
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t\t");
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.print(cell.getStringCellValue() + "\t\t");
                            break;
                    }
                }
                System.out.println("");
            }

            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exportToExcel() {

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Örnek Sayfa");
        Map<String, Object[]> data = new HashMap<String, Object[]>();
        data.put("1", new Object[]{"Emp No.", "Name", "Salary"});
        data.put("2", new Object[]{1d, "John", 1500000d});
        data.put("3", new Object[]{2d, "Sam", 800000d});
        data.put("4", new Object[]{3d, "Dean", 700000d});

        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof Date) {
                    cell.setCellValue((Date) obj);
                } else if (obj instanceof Boolean) {
                    cell.setCellValue((Boolean) obj);
                } else if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Double) {
                    cell.setCellValue((Double) obj);
                }
            }
        }
        try {
            FileOutputStream out = new FileOutputStream(new File("C:\\TT\\A.xls"));
            workbook.write(out);
            out.close();
            System.out.println("Excel yazıldı..");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void exportToExcel(List<Kisi> liste){
        
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Örnek Sayfa");
        
         Map<String, Object[]> data = new HashMap<String, Object[]>();
         
         for (int i = liste.size(); i >0; i--) {
             Kisi kisi = liste.get(i-1);
            data.put(""+i, new Object[]{kisi.getAd(),kisi.getSoyad(),kisi.getId()});
        }
      
        data.put("" + (liste.size()+1), new Object[]{"Adı", "Soyadı", "Id"});
           
        Set<String> keyset = data.keySet();
        int rownum = 1;
        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof Date) {
                    cell.setCellValue((Date) obj);
                } else if (obj instanceof Boolean) {
                    cell.setCellValue((Boolean) obj);
                } else if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Double) {
                    cell.setCellValue((Double) obj);
                } else if (obj instanceof Long) {
                    cell.setCellValue((Long) obj);
                }
            }
        }
        try {
            FileOutputStream out = new FileOutputStream(new File("C:\\TT\\A.xls"));
            workbook.write(out);
            out.close();
            System.out.println("Excel yazıldı..");
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
            
}