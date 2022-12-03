package com.vmall.service;

import com.vmall.common.exception.VMallException;

public interface TestService {
  Object findTest();

  Object findMapper();

  void shouldThrow() throws VMallException;
}
