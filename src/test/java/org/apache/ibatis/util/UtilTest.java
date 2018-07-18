package org.apache.ibatis.util;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author xh.d
 * @since 2018/7/18 14:55
 */
public class UtilTest {
    @Test
    public void propsTest() throws IOException {
        //系统classLoader
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        //当前线程的classLoader
        ClassLoader threadLoader = Thread.currentThread().getContextClassLoader();
        //当前类的classLoader
        ClassLoader currentClassLoader = getClass().getClassLoader();
        if (systemClassLoader == threadLoader){
            System.out.println("equals 1");
        }
        if (currentClassLoader == threadLoader){
            System.out.println("equals 2");
        }
        if (systemClassLoader == currentClassLoader){
            System.out.println("equals 3");
        }
        InputStream in = currentClassLoader.getResourceAsStream("org/apache/ibatis/databases/blog/blog-mysql.properties");
        InputStream in2 = threadLoader.getResourceAsStream("org/apache/ibatis/databases/blog/blog-mysql.properties");
        InputStream in3 = systemClassLoader.getResourceAsStream("org/apache/ibatis/databases/blog/blog-mysql.properties");
        Properties props = new Properties();
        if (in2 != null){
            props.load(in2);
            System.out.println(props.getProperty("password"));
        }
        if (in3 != null){
            props.load(in3);
            System.out.println(props.getProperty("driver"));
        }

        props.load(in);
        String value = props.getProperty("username");
        System.out.println(value);
    }
}
