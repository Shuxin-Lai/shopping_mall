package com.vmall.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 商品描述表
 * </p>
 *
 * @author me
 * @since 2022-12-02 11:10:24
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("tb_item_desc")
public class TbItemDesc implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品ID
     */
    @TableId("item_id")
    private Long itemId;

    /**
     * 商品描述
     */
    @TableField("item_desc")
    private String itemDesc;

    /**
     * 创建时间
     */
    @TableField("created")
    private Date created;

    /**
     * 更新时间
     */
    @TableField("updated")
    private Date updated;


}
