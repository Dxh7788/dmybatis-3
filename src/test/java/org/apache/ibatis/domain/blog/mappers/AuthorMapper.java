package org.apache.ibatis.domain.blog.mappers;

import org.apache.ibatis.domain.blog.Author;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by mybatis
 *
 * @author xh.d
 * @since 2018/7/18 13:15
 */
public interface AuthorMapper{

    Author selectOne(Integer id);
}
