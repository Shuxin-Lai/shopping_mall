package com.vmall.service.impl;

import com.vmall.common.exception.VMallException;
import com.vmall.common.exception.VMallExceptionEnum;
import com.vmall.entity.TbTest;
import com.vmall.mapper.TbTestMapper;
import com.vmall.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

  @Autowired
  TbTestMapper tbTestMapper;

  @Override
  public Object findTest() {
    return "ok";
  }

  @Override
  public Object findMapper() {
    TbTest tbTest = tbTestMapper.selectById(1);
    return tbTest;
  }

  @Override
  public void shouldThrow() throws VMallException {
    throw new VMallException(VMallExceptionEnum.SYS_ERROR);
  }
}
