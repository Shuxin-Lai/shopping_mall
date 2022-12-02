package com.vmall.entity;

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
 * 商品表
 * </p>
 *
 * @author me
 * @since 2022-12-02 11:10:24
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("tb_item")
public class TbItem implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id，同时也是商品编号
     */
    @TableId("id")
    private Long id;

    /**
     * 商品标题
     */
    @TableField("title")
    private String title;

    /**
     * 商品卖点
     */
    @TableField("sell_point")
    private String sellPoint;

    /**
     * 商品价格，单位为：分
     */
    @TableField("price")
    private Long price;

    /**
     * 库存数量
     */
    @TableField("num")
    private Integer num;

    /**
     * 商品条形码
     */
    @TableField("barcode")
    private String barcode;

    /**
     * 商品图片
     */
    @TableField("image")
    private String image;

    /**
     * 所属类目，叶子类目
     */
    @TableField("cid")
    private Long cid;

    /**
     * 商品状态，1-正常，2-下架，3-删除
     */
    @TableField("status")
    private Integer status;

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
