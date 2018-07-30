package org.apache.ibatis.reflection;

import org.apache.ibatis.model.Person;
import org.apache.ibatis.model.User;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;

import java.lang.reflect.InvocationTargetException;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by mybatis
 *
 * @author xh.d
 * @since 2018/7/30 13:18
 */
public class ObjectFactoryTest {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        ReflectorFactory factory = new DefaultReflectorFactory();
        MetaObject object = MetaObject.forObject(new Person(),new DefaultObjectFactory(),new DefaultObjectWrapperFactory(),factory);
        object.setValue("user.user.name","123");
        User iu = (User)object.getValue("user");
        System.out.println(iu.getUser().getName());
    }
}
