package com.vmall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vmall.entity.TbUser;
import com.vmall.mapper.TbUserMapper;
import com.vmall.service.TbUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author me
 * @since 2022-12-02 11:10:24
 */
@Service
public class TbUserServiceImpl
  extends ServiceImpl<TbUserMapper, TbUser>
  implements TbUserService {}
