package com.vmall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vmall.entity.TbContentCategory;
import com.vmall.mapper.TbContentCategoryMapper;
import com.vmall.service.TbContentCategoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 内容分类 服务实现类
 * </p>
 *
 * @author me
 * @since 2022-12-02 11:10:24
 */
@Service
public class TbContentCategoryServiceImpl
  extends ServiceImpl<TbContentCategoryMapper, TbContentCategory>
  implements TbContentCategoryService {}
