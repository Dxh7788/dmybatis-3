package org.apache.ibatis.domain.blog;

import java.io.Serializable;

/**
 * Copyright (C) 2017-2018 https://www.htouhui.com - A project by mybatis
 *
 * @author xh.d
 * @since 2018/7/31 15:06
 */
public class Book implements Serializable {

    private static final long serialVersionUID = 7698937191776398194L;
    private Long id;
    private String name;
    private Author author;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
