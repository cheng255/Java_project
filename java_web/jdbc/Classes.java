package com.cheng.jdbc;

/**
 * @author nuonuo
 * @create 2020-11-16 13:55
 */
public class Classes {
    private int id;
    private String name;

    private String desc;//描述

    public Classes() {
    }

    public Classes(int id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
