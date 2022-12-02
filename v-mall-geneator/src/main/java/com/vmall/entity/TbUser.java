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
 * 用户表
 * </p>
 *
 * @author me
 * @since 2022-12-02 11:10:24
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("tb_user")
public class TbUser implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  /**
   * 用户名
   */
  @TableField("username")
  private String username;

  /**
   * 密码，加密存储
   */
  @TableField("password")
  private String password;

  /**
   * 注册手机号
   */
  @TableField("phone")
  private String phone;

  /**
   * 注册邮箱
   */
  @TableField("email")
  private String email;

  @TableField("created")
  private Date created;

  @TableField("updated")
  private Date updated;
}
