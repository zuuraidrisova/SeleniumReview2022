package test.day09_TestBase_Properties_DriverUtil;

import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingFromPropertiesFile {

    @Test
    public void howToReadFromPropertiesFile(){

        Properties properties = new Properties();

        String path = "Configuration.properties";

        try {

            FileInputStream file = new FileInputStream(path);

            properties.load(file);

            String browser = properties.getProperty("browser");
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");

            System.out.println("browser = " + browser);
            System.out.println("username = " + username);
            System.out.println("password = " + password);

            file.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }



    @Test
    public void readFromPropertiesFileUsingUtility(){


        String browser = ConfigurationReader.getProperty("browser");
        String username = ConfigurationReader.getProperty("username");
        String password = ConfigurationReader.getProperty("password");

        System.out.println("browser = " + browser);
        System.out.println("username = " + username);
        System.out.println("password = " + password);


    }

}
