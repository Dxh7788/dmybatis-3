package org.apache.ibatis.reflection;

import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
import org.apache.ibatis.reflection.invoker.Invoker;
import org.apache.ibatis.reflection.property.PropertyTokenizer;

import javax.sql.DataSource;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by mybatis
 *
 * @author xh.d
 * @since 2018/7/27 10:54
 */
public class MetaObjectTest {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        //part01();
        //part02();
        part03();
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

    private static void part03() throws InvocationTargetException, IllegalAccessException {
        ReflectorFactory factory = new DefaultReflectorFactory();
        User u = new User();
        MetaClass metaClass = MetaClass.forClass(u.getClass(), factory);
        Invoker invoker = metaClass.getSetInvoker("name");
        Object o = new String("5566");
        Object[] os = {o};
        invoker.invoke(u, os);
        System.out.println(u.getName());
    }
}
