package com.vmall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vmall.entity.TbContent;
import com.vmall.mapper.TbContentMapper;
import com.vmall.service.TbContentService;
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
public class TbContentServiceImpl
  extends ServiceImpl<TbContentMapper, TbContent>
  implements TbContentService {}
