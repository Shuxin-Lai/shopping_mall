package com.vmall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vmall.entity.TbItemDesc;
import com.vmall.mapper.TbItemDescMapper;
import com.vmall.service.TbItemDescService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品描述表 服务实现类
 * </p>
 *
 * @author me
 * @since 2022-12-02 11:10:24
 */
@Service
public class TbItemDescServiceImpl
  extends ServiceImpl<TbItemDescMapper, TbItemDesc>
  implements TbItemDescService {}
