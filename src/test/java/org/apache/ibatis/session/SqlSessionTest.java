package org.apache.ibatis.session;

import org.apache.ibatis.BaseDataTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by mybatis
 *
 * @author xh.d
 * @since 2018/7/17 17:36
 */
public class SqlSessionTest extends BaseDataTest {

    @BeforeClass
    public static void setUp() throws IOException, SQLException {
        createMysqlstoreDataSource();
    }

    @Test
    public void createDatasource(){

    }
}
