package org.apache.ibatis.session;

import org.apache.ibatis.BaseDataTest;
import org.apache.ibatis.domain.blog.Author;
import org.apache.ibatis.domain.blog.Book;
import org.apache.ibatis.domain.blog.mappers.AuthorMapper;
import org.apache.ibatis.domain.blog.mappers.BookMapper;
import org.apache.ibatis.io.Resources;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

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
        createBlogDataSource();
    }

    @Test
    public void createDatasource(){

    }

    /*
        开启session
    */
    @Test
    public void openSessionTest() throws IOException, SQLException {
        final String resource = "org/apache/ibatis/builder/MapperConfig.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = factory.openSession(false);
        AuthorMapper authorMapper = session.getMapper(AuthorMapper.class);
        Author author = authorMapper.selectOne(101);
        System.out.println(author.getUsername());

        BookMapper bookMapper = session.getMapper(BookMapper.class);
        List<Book> books = bookMapper.selectBookAndAuthors(101);
        for (Book book:books){
            Author a = book.getAuthor();
            System.out.println(a.getUsername());
        }
        System.out.println(books.size());

        List<Author> authors = authorMapper.selectAuthors(101);
        System.out.println(authors.get(0).getBooks().size());

        List<Author> authors2 = authorMapper.selectAuthorAndBooks(101);
        System.out.println(authors2.size());

    }

}
