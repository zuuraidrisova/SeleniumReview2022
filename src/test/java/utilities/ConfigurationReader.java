package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    //1- we created properties object of Properties class
    private static Properties properties = new Properties();

    //static block runs once and before anything else
    static {

        //2- we need to get the path of the file first
        String path = "Configuration.properties";

        try {//we have to handle compile time exception which FileInputStream is throwing

            //3-we create an object of FileInputStream in order to be able to open the file
            FileInputStream file = new FileInputStream(path);

            //we load the file into properties object
            properties.load(file);

            //5- close file previously opened file
            file.close();

        }catch (IOException e){

            e.printStackTrace();

            e.getMessage();

            System.out.println("Properties file is not found");

        }

    }

    //our own custom method to read and get values from configuration.properties file
    public static String getProperty(String keyWord){

        //getProperty() method comes from Java itself, from Properties class
        return properties.getProperty(keyWord);

    }

}
