package com.vmall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vmall.entity.TbOrderItem;
import com.vmall.mapper.TbOrderItemMapper;
import com.vmall.service.TbOrderItemService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author me
 * @since 2022-12-02 11:10:24
 */
@Service
public class TbOrderItemServiceImpl
  extends ServiceImpl<TbOrderItemMapper, TbOrderItem>
  implements TbOrderItemService {}
