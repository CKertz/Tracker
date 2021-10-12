package com.cooper.tracker.UI;

import javax.swing.*;
import java.io.*;
import java.nio.file.Path;
import java.util.Properties;

public class ProjectFileChooser {

    File configFile = new File("config.properties");
    JFileChooser fileChooser = new JFileChooser();

    public void chooseFile(JComponent parent)
    {
        //TODO:implement pref directory, the props file formatting is scuffed
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(parent);
        if(result ==JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = fileChooser.getSelectedFile();

            setDefaultFileChooserLocation(configFile,selectedFile.toString().replace("\\","."));
            //setDefaultFileChooserLocation(file,selectedFile.toString());
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());

        }
    }

//    private void setDefaultFileChooserLocation(File file, String directory)
//    {
//        //call this function after user imports a project. it can be updated each time and be their most recently used directory for the app
//
//        Properties props = new Properties();
//        props.setProperty("projectFileChooserHomePath",directory);
//        FileOutputStream fr = null;
//        try {
//            fr = new FileOutputStream(file);
//            props.store(fr,"props");
//            fr.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
///////////////////////////////////////////////////////////////
//
////        Properties properties = new Properties();
////        InputStream in = getClass().getResourceAsStream("application.properties");
////        try {
////            properties.load(in);
////            properties.store(new FileOutputStream("application.properties"),null);
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//
//        //properties.setProperty("projectFileChooserHomePath",homePath);
//    }

    public void setDefaultFileChooserLocation(File file, String directory)
    {
        try{
            Properties props = new Properties();
            props.setProperty("projectFileChooserDefaultPath", directory);
            FileWriter writer = new FileWriter(configFile);
            props.store(writer,"filechooser settings");
            writer.close();
        } catch (FileNotFoundException ex) {
            // file does not exist
        } catch (IOException ex) {
            // I/O error
        }
    }
    private String formatFilePathForFileChooser(String path)
    {
        return path.replace("/",".");
    }
}
