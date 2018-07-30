package org.apache.ibatis.reflection;

import org.apache.ibatis.model.Person;
import org.apache.ibatis.model.User;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by mybatis
 *
 * @author xh.d
 * @since 2018/7/30 13:18
 */
public class ObjectFactoryTest {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        ReflectorFactory factory = new DefaultReflectorFactory();
        Person p = new Person();
        User user = new User();
        List<User> users = new ArrayList<User>();
        users.add(user);
        p.setUsers(users);
        MetaObject object = MetaObject.forObject(p,new DefaultObjectFactory(),new DefaultObjectWrapperFactory(),factory);
        object.setValue("users[0].user.name","123");
        User iu = p.getUsers().get(0);
        System.out.println(iu.getUser().getName());
    }
}
