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
@TableName("tb_order_shipping")
public class TbOrderShipping implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * 订单ID
   */
  @TableId("order_id")
  private String orderId;

  /**
   * 收货人全名
   */
  @TableField("receiver_name")
  private String receiverName;

  /**
   * 固定电话
   */
  @TableField("receiver_phone")
  private String receiverPhone;

  /**
   * 移动电话
   */
  @TableField("receiver_mobile")
  private String receiverMobile;

  /**
   * 省份
   */
  @TableField("receiver_state")
  private String receiverState;

  /**
   * 城市
   */
  @TableField("receiver_city")
  private String receiverCity;

  /**
   * 区/县
   */
  @TableField("receiver_district")
  private String receiverDistrict;

  /**
   * 收货地址，如：xx路xx号
   */
  @TableField("receiver_address")
  private String receiverAddress;

  /**
   * 邮政编码,如：310001
   */
  @TableField("receiver_zip")
  private String receiverZip;

  @TableField("created")
  private Date created;

  @TableField("updated")
  private Date updated;
}
