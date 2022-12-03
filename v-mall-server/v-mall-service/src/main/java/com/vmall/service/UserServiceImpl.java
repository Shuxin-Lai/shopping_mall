package com.vmall.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vmall.common.exception.VMallException;
import com.vmall.common.exception.VMallExceptionEnum;
import com.vmall.entity.TbUser;
import com.vmall.mapper.TbUserMapper;
import com.vmall.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  TbUserMapper tbUserMapper;

  @Override
  public UserVO findUserById(String id) throws VMallException {
    return findUser("id", id);
  }

  @Override
  public UserVO findUserByUsername(String username) throws VMallException {
    return findUser("username", username);
  }

  @Override
  public UserVO findUserByEmail(String email) throws VMallException {
    return findUser("email", email);
  }

  public UserVO findUser(String column, Object value) throws VMallException {
    if (value == null) {
      throw new VMallException(VMallExceptionEnum.USER_NOT_EXIST);
    }

    QueryWrapper<TbUser> wrapper = new QueryWrapper<>();
    wrapper.eq(column, value);

    TbUser tbUser = tbUserMapper.selectOne(wrapper);
    if (tbUser == null) {
      throw new VMallException(VMallExceptionEnum.USER_NOT_EXIST);
    }
    UserVO userVO = new UserVO();
    BeanUtils.copyProperties(tbUser, userVO);
    return userVO;
  }
}
