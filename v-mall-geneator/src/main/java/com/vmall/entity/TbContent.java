package com.vmall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author me
 * @since 2022-12-02 11:10:24
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("tb_content")
public class TbContent implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  /**
   * 内容类目ID
   */
  @TableField("category_id")
  private Long categoryId;

  /**
   * 内容标题
   */
  @TableField("title")
  private String title;

  /**
   * 子标题
   */
  @TableField("sub_title")
  private String subTitle;

  /**
   * 标题描述
   */
  @TableField("title_desc")
  private String titleDesc;

  /**
   * 链接
   */
  @TableField("url")
  private String url;

  /**
   * 图片绝对路径
   */
  @TableField("pic")
  private String pic;

  /**
   * 图片2
   */
  @TableField("pic2")
  private String pic2;

  /**
   * 内容
   */
  @TableField("content")
  private String content;

  @TableField("created")
  private Date created;

  @TableField("updated")
  private Date updated;
}
