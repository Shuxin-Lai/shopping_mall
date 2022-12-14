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
 * 商品规则参数
 * </p>
 *
 * @author me
 * @since 2022-12-02 11:10:24
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("tb_item_param")
public class TbItemParam implements Serializable {

  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private Long id;

  /**
   * 商品类目ID
   */
  @TableField("item_cat_id")
  private Long itemCatId;

  /**
   * 参数数据，格式为json格式
   */
  @TableField("param_data")
  private String paramData;

  @TableField("created")
  private Date created;

  @TableField("updated")
  private Date updated;
}
