package com.vmall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * 商品类目
 * </p>
 *
 * @author me
 * @since 2022-12-02 11:10:24
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("tb_item_cat")
public class TbItemCat implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 类目ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 父类目ID=0时，代表的是一级的类目
     */
    @TableField("parent_id")
    private Long parentId;

    /**
     * 类目名称
     */
    @TableField("name")
    private String name;

    /**
     * 状态。可选值:1(正常),2(删除)
     */
    @TableField("status")
    private Integer status;

    /**
     * 排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
     */
    @TableField("sort_order")
    private Integer sortOrder;

    /**
     * 该类目是否为父类目，1为true，0为false
     */
    @TableField("is_parent")
    private Boolean isParent;

    /**
     * 创建时间
     */
    @TableField("created")
    private Date created;

    /**
     * 创建时间
     */
    @TableField("updated")
    private Date updated;


}
