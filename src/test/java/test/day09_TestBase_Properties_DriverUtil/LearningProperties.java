package test.day09_TestBase_Properties_DriverUtil;

import org.apache.xmlbeans.SystemProperties;
import org.testng.annotations.Test;

public class LearningProperties {

    //properties type of file  store data in key and value format

    @Test
    public void learningPropertiesTest(){

        System.out.println("SystemProperties.getProperty = " + SystemProperties.getProperty("os.name"));

        System.out.println("SystemProperties.getProperty(\"user.name\") = " + SystemProperties.getProperty("user.name"));

        System.out.println("SystemProperties.getProperty(\"password.name\") = " + SystemProperties.getProperty("password.name"));

    }
}
