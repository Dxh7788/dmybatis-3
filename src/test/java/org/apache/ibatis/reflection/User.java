package org.apache.ibatis.reflection;

/**
 *
 * @author xh.d
 * @since 2018/7/27 17:33
 */
public class User {
    private String name;
    private String pwd;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
