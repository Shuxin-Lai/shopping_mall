package com.vmall.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("tb_test")
public class TbTest implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("id")
    private Integer id;

    @TableField("name")
    private String name;


}
