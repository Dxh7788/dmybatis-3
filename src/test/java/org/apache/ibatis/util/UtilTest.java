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
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream in = classLoader.getResourceAsStream("org/apache/ibatis/databases/blog/blog-mysql.properties");
        Properties props = new Properties();
        props.load(in);
        String value = props.getProperty("username");
        System.out.println(value);
    }
}
