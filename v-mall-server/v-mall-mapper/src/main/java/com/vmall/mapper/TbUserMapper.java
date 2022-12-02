package com.vmall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vmall.entity.TbUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author me
 * @since 2022-12-02 11:10:24
 */
@Mapper
public interface TbUserMapper extends BaseMapper<TbUser> {

}
