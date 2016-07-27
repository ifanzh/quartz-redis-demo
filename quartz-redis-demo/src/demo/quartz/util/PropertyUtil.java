package demo.quartz.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import demo.quartz.common.Constant;

/**
 * 对 .properties 文件的读取操作 
 * 
 * @author zhangfan
 *
 */
public class PropertyUtil {   
  
    /**  
     * 采用静态方法  
     */   
    public static Properties props_redis = new Properties(); 
    public static Properties props_cron = new Properties(); 
    
    static {   
        try {   
            props_redis.load(new FileInputStream(Constant.PROFILEPATH_REDIS));  
            props_cron.load(new FileInputStream(Constant.PROFILEPATH_CRON)); 
        } catch (FileNotFoundException e) {   
            e.printStackTrace();   
            System.exit(-1);   
        } catch (IOException e) {          
            System.exit(-1);   
        }   
    } 
    
    /**  
     * 根据主键key读取主键的值value  
     * @param filePath 属性文件路径  
     * @param key 键名  
     */   
    public static String readValue(String filePath, String key) {   
        Properties props = new Properties();   
        try {   
            InputStream in = new BufferedInputStream(new FileInputStream(   
                    filePath));   
            props.load(in);   
            return props.getProperty(key);   
        } catch (Exception e) {   
            e.printStackTrace();   
            return null;   
        }   
    } 
    
    public static String readValueByRedis (String key) {
    	return readValue(Constant.PROFILEPATH_REDIS, key);
    }
    
    public static String readValueByCron (String key) {
    	return readValue(Constant.PROFILEPATH_CRON, key);
    }
}   