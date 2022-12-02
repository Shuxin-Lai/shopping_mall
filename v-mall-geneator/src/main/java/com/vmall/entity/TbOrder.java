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
 * 
 * </p>
 *
 * @author me
 * @since 2022-12-02 11:10:24
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("tb_order")
public class TbOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    @TableId("order_id")
    private String orderId;

    /**
     * 实付金额。精确到2位小数;单位:元。如:200.07，表示:200元7分
     */
    @TableField("payment")
    private String payment;

    /**
     * 支付类型，1、在线支付，2、货到付款
     */
    @TableField("payment_type")
    private Integer paymentType;

    /**
     * 邮费。精确到2位小数;单位:元。如:200.07，表示:200元7分
     */
    @TableField("post_fee")
    private String postFee;

    /**
     * 状态：1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭
     */
    @TableField("status")
    private Integer status;

    /**
     * 订单创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 订单更新时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 付款时间
     */
    @TableField("payment_time")
    private Date paymentTime;

    /**
     * 发货时间
     */
    @TableField("consign_time")
    private Date consignTime;

    /**
     * 交易完成时间
     */
    @TableField("end_time")
    private Date endTime;

    /**
     * 交易关闭时间
     */
    @TableField("close_time")
    private Date closeTime;

    /**
     * 物流名称
     */
    @TableField("shipping_name")
    private String shippingName;

    /**
     * 物流单号
     */
    @TableField("shipping_code")
    private String shippingCode;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 买家留言
     */
    @TableField("buyer_message")
    private String buyerMessage;

    /**
     * 买家昵称
     */
    @TableField("buyer_nick")
    private String buyerNick;

    /**
     * 买家是否已经评价
     */
    @TableField("buyer_rate")
    private Integer buyerRate;


}
