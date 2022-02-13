package com.ifi.covidweb.common;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private static String path = Constant.IMAGE_PATH;

    public  Map<String, String> storeFile(String image, String identify ) {
        Map<String, String> map = new HashMap<>();
        try {
            String fileName = (new Date()).getTime() + "_" + identify  + ".txt";
            FileOutputStream outputStream = new FileOutputStream(path+"/"+fileName);
            byte[] strToBytes = image.getBytes();
            outputStream.write(strToBytes);
            outputStream.close();
            Path paths = Paths.get(path);
            Path targetLocation = paths.resolve(fileName);
            File fileServerFile = targetLocation.toFile();
            if (fileServerFile.exists()) {
                map.put(fileName, targetLocation.toString());
                return map;
            }

        } catch (Exception ex) {
            ex.getMessage();
        }
        return map;
    }


}
