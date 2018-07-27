package org.apache.ibatis.reflection;

import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
import org.apache.ibatis.reflection.property.PropertyTokenizer;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by mybatis
 *
 * @author xh.d
 * @since 2018/7/27 10:54
 */
public class MetaObjectTest {

    public static void main(String[] args) {
        //part01();
        part02();
    }

    private static void part01() {
        PropertyTokenizer tokenizer = new PropertyTokenizer("com.dxh.name");
        while (tokenizer.hasNext()){
            System.out.println("name:"+tokenizer.getName()+",index:"+tokenizer.getIndex()+",children:"+tokenizer.getChildren()+",indexName:"+tokenizer.getIndexedName());
            tokenizer = tokenizer.next();
        }
    }

    private static void part02() {
        Properties driverProperties = new Properties();
        driverProperties.put("url","sss");
        driverProperties.put("username","root");
        driverProperties.put("password","anan1215");
        driverProperties.put("driver","com.mysql.jdbc.Driver");
        UnpooledDataSource dataSource = new UnpooledDataSource();
        MetaObject metaDatasource = SystemMetaObject.forObject(dataSource);
        metaDatasource.setValue("driverProperties",driverProperties);
        System.out.println(dataSource.getDriverProperties().getProperty("username"));
    }
}
