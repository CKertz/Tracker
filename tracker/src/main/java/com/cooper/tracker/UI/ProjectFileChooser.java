package com.cooper.tracker.UI;

import javax.swing.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ProjectFileChooser {

    File configFile = new File("trackerconfig.properties");
    String defaultPathpropertyName = "projectFileChooserDefaultPath";
    JFileChooser fileChooser = new JFileChooser();
    static final Properties props = new Properties();

    public void chooseFile(JComponent parent) {
        //first, check if default path exists
        if (doesDefaultFileChooserLocationExist())
        {
            File file = new File(props.getProperty(defaultPathpropertyName));
            String propsPath = file.getParent();

            System.out.println(props.getProperty(propsPath));
            fileChooser.setCurrentDirectory(new File(propsPath));

        }
        else
        {
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        }

        int result = fileChooser.showOpenDialog(parent);

        if(result == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = fileChooser.getSelectedFile();

            //setDefaultFileChooserLocation(configFile,selectedFile.toString().replace("\\","."));
            setDefaultFileChooserLocation(configFile,selectedFile.toString());
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
            props.setProperty(defaultPathpropertyName, directory);
            FileWriter writer = new FileWriter(configFile);
            props.store(writer,"filechooser settings");
            writer.close();
        } catch (FileNotFoundException ex) {
            // file does not exist
        } catch (IOException ex) {
            // I/O error
        }
    }

    public boolean doesDefaultFileChooserLocationExist()
    {
        try (InputStream input = new FileInputStream("D:\\CodeProjects\\Java\\TrackerApp\\tracker\\trackerconfig.properties"))
        {
            props.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        if(props.getProperty(defaultPathpropertyName) == null)
            return false;
        else
            return true;


    }
}
