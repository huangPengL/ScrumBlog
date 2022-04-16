package com.hpl.blog.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TBlog对象", description="")
public class TBlog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Boolean appreciationState;

    private Boolean commentState;

    private String content;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    private String firstPicture;

    private String flag;

    private Boolean publishState;

    private Boolean recommendState;

    private Boolean shareState;

    private String title;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    private Integer viewNum;

    private Long typeId;

    private Long userId;

    private String description;


}
