/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starr.smartbuilds.service;

import com.starr.smartbuilds.entity.Build;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import javax.servlet.ServletContext;
import org.apache.commons.net.ftp.FTPClient;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tanya
 */
@Service
public class FileService {

    @Autowired
    private BuildService buildService;

    public String getFile(Build build, ServletContext sc) throws FileNotFoundException, IOException, ParseException {

        /*if (fileName == null || fileName.equals("") || fileText == null || fileText.equals("")) {
         resultMsg = "<font color='red'>Fail: File is not created!</font>";
         } else {
         try {*/
        String path = sc.getRealPath("/");
        System.out.println(path);
        File dir = new File(path + "/builds");
        if (!dir.exists() || !dir.isDirectory()) {
            dir.mkdir();
        }

        String fileName = path + "/builds/" + build.getChampion().getKeyChamp() + build.getId() + ".json";
        File fileBuild = new File(fileName);
        if (!fileBuild.exists() || fileBuild.isDirectory()) {
            String file_data = buildService.buildData(build, buildService.parseBlocks(build.getBlocks()));
            fileBuild.createNewFile();
            FileOutputStream fos = new FileOutputStream(fileBuild, false);
            fos.write(file_data.getBytes());
            fos.close();
        }

        FTPClient client = new FTPClient();
        FileInputStream fis = null;

        try {
            client.connect("itelit.ftp.ukraine.com.ua");
            client.login("itelit_dor", "154896");

            // Create an InputStream of the file to be uploaded
            fis = new FileInputStream(fileBuild.getAbsolutePath());

            // Store file to server
            client.storeFile("builds/" + build.getChampion().getKeyChamp() + build.getId() + ".json", fis);
            client.logout();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                client.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        /*} catch (IOException ex) {
         resultMsg = "<font color='red'>Fail: File is not created!</font>";
         }
         }*/
        return "http://dor.it-elit.org/builds/"+build.getChampion().getKeyChamp() + build.getId() + ".json";
    }

}
