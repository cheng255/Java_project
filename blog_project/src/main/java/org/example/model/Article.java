package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author nuonuo
 * @create 2020-12-05 12:58
 */
@ToString
@Getter
@Setter
public class Article {
    private Integer id;
    private String title;
    private String content;
    private Date createTime;
    private Integer viewCount;
    private Integer userId;

}
