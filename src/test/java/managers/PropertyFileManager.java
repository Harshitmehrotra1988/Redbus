package managers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileManager {
	static FileInputStream fis;
	static Properties prop;
	
	public static String getPropertyValue(String propertyFileName,String key) throws IOException
	{
	fis= new FileInputStream("src\\test\\resources\\properFiles\\"+propertyFileName+".properties");
	prop=new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}

}
