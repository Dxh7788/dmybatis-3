package org.apache.ibatis.domain.blog.mappers;

import org.apache.ibatis.domain.blog.Author;
import org.apache.ibatis.model.User;

import java.util.List;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by mybatis
 *
 * @author xh.d
 * @since 2018/7/18 13:15
 */
public interface AuthorMapper{

/*    Author selectOne(Integer id);
    List<Author> selectAuthors(Integer param1,String param2);
    List<Author> selectAuthorAndBooks(Integer id);
    List<Author> selectAuthorsByUser(Author author);*/
    List<Author> selectAuthorsCopy(User user);
}
