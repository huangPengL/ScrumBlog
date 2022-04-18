package com.hpl.blog.display;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/3/21 10:52
 */

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CommentTree {

    private Long id;
    private String nickName;
    private String content;
    private String email;
    private Date createTime;

    private List<CommentTree> children;
    private String parentNickName;
}
