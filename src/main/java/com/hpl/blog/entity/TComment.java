package com.hpl.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author HPL
 * @since 2022-04-15
 */
@Data
@ToString
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TComment对象", description="")
public class TComment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String avatar;

    private String content;

    private Date createTime;

    private String email;

    private String nickname;

    private Long blogId;

    private Long parentCommentId;

    private Boolean usertype;


}
