/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starr.smartbuilds.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tanya
 */
@Service
public class FileService {

    private String fileName;
    private String fileText;

    public String writeFile() throws FileNotFoundException, IOException {
        String resultMsg = "k";
        /*if (fileName == null || fileName.equals("") || fileText == null || fileText.equals("")) {
            resultMsg = "<font color='red'>Fail: File is not created!</font>";
        } else {
            try {*/
                File dir = new File("D:/builds");
                if (!dir.exists() || !dir.isDirectory()) {
                    dir.mkdir();
               }
               File fileBuild = new File("D:/builds/" + fileName + ".txt");

                FileOutputStream fos = new FileOutputStream(fileBuild, false);
                fos.write(fileText.getBytes());
                fos.close();
                resultMsg = "<font color='green'>Done: File is created!</font>";
            /*} catch (IOException ex) {
                resultMsg = "<font color='red'>Fail: File is not created!</font>";
            }
        }*/
        return resultMsg;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileText() {
        return fileText;
    }

    public void setFileText(String fileText) {
        this.fileText = fileText;
    }

}
