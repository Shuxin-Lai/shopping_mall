package com.vmall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vmall.entity.TbItemParamItem;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 商品规格和商品的关系表 Mapper 接口
 * </p>
 *
 * @author me
 * @since 2022-12-02 11:10:24
 */
@Mapper
public interface TbItemParamItemMapper extends BaseMapper<TbItemParamItem> {}
