package com.vmall.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
@TableName("tb_order_item")
public class TbOrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    /**
     * 商品id
     */
    @TableField("item_id")
    private String itemId;

    /**
     * 订单id
     */
    @TableField("order_id")
    private String orderId;

    /**
     * 商品购买数量
     */
    @TableField("num")
    private Integer num;

    /**
     * 商品标题
     */
    @TableField("title")
    private String title;

    /**
     * 商品单价
     */
    @TableField("price")
    private Long price;

    /**
     * 商品总金额
     */
    @TableField("total_fee")
    private Long totalFee;

    /**
     * 商品图片地址
     */
    @TableField("pic_path")
    private String picPath;


}
