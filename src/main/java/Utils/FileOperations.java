package Utils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Properties;

public class FileOperations {

    private static final String DIR_PATH_PROPERTIES = System.getProperty("user.dir") + File.separator + "src" +
            File.separator + "main" + File.separator + "resources" + File.separator + "Properties";

    public static Properties getProperties(String fileName){
        InputStream inputStream = null;
        Properties properties = new Properties();

        try{
            inputStream = new FileInputStream(DIR_PATH_PROPERTIES + File.separator + fileName + ".properties");
            properties.load( new InputStreamReader(inputStream , Charset.forName("UTF-8")));
            inputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        return properties;
    }

    public static void setProperties(String fileName, String proKey , String propValue){
        Properties properties = getProperties(fileName);

        try{
            OutputStream outputStream = new FileOutputStream(DIR_PATH_PROPERTIES + File.separator + fileName
                    + ".properties");

            properties.setProperty(proKey , propValue);
            properties.store(outputStream , null);

            outputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}