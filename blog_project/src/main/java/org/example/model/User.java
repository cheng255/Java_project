package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * 与数据库对应的java对象类
 * @author nuonuo
 * @create 2020-12-05 12:54
 */
@Setter
@Getter
@ToString
public class User {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private Boolean sex;
    private Date birthday;
    private String head;
}
