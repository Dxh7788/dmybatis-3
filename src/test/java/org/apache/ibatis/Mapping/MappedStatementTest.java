package org.apache.ibatis.Mapping;

import org.apache.ibatis.builder.SqlSourceBuilder;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.session.Configuration;
import org.junit.Test;

import java.util.HashMap;

/**
 *
 * @author xh.d
 * @since 2018/8/3 12:54
 */
public class MappedStatementTest {

    @Test
    public void test(){
        //直接从内存中读取inputStream
        String sql = "";//sql配置

        SqlSourceBuilder sqlSourceParser = new SqlSourceBuilder(new Configuration());
        Class<?> clazz = Object.class ;
        SqlSource sqlSource = sqlSourceParser.parse(sql, clazz, new HashMap<String, Object>());
    }
}
