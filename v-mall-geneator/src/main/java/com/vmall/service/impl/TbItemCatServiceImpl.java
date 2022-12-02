package com.vmall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vmall.entity.TbItemCat;
import com.vmall.mapper.TbItemCatMapper;
import com.vmall.service.TbItemCatService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品类目 服务实现类
 * </p>
 *
 * @author me
 * @since 2022-12-02 11:10:24
 */
@Service
public class TbItemCatServiceImpl
  extends ServiceImpl<TbItemCatMapper, TbItemCat>
  implements TbItemCatService {}
