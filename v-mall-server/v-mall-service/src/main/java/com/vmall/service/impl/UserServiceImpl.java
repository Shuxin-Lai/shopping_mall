package com.vmall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.vmall.common.exception.VMallException;
import com.vmall.common.exception.VMallExceptionEnum;
import com.vmall.common.utils.CoreUtils;
import com.vmall.common.utils.EncryptUtils;
import com.vmall.entity.TbUser;
import com.vmall.mapper.TbUserMapper;
import com.vmall.service.UserService;
import com.vmall.vo.UserVO;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class UserServiceImpl implements UserService {

  @Autowired
  TbUserMapper tbUserMapper;

  @Override
  public UserVO findUserById(String id) throws VMallException {
    return findUser("id", id);
  }

  @Override
  public UserVO findUserByUsername(String username, String password)
    throws VMallException {
    return findUserWithPassword("username", username, password);
  }

  @Override
  public UserVO findUserByEmail(String email, String password)
    throws VMallException {
    return findUserWithPassword("email", email, password);
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED)
  public UserVO register(String email, String password) throws VMallException {
    QueryWrapper<TbUser> wrapper = new QueryWrapper<>();
    wrapper.eq("email", email);

    TbUser tbUser = tbUserMapper.selectOne(wrapper);
    if (tbUser != null) {
      throw new VMallException(VMallExceptionEnum.USER_EXIST);
    }

    TbUser user = createUser(email, password);
    int count = tbUserMapper.insert(user);
    if (count != 1) {
      throw new VMallException(VMallExceptionEnum.INSERTED_FAILED);
    }

    UserVO userVO = new UserVO();
    BeanUtils.copyProperties(user, userVO);

    return userVO;
  }

  @Override
  public UserVO login(String email, String password) throws VMallException {
    QueryWrapper<TbUser> wrapper = new QueryWrapper<>();
    wrapper.eq("email", email);

    TbUser tbUser = tbUserMapper.selectOne(wrapper);
    if (tbUser == null) {
      throw new VMallException(VMallExceptionEnum.EMAIL_NOT_EXIST);
    }

    QueryWrapper<TbUser> wrapper2 = new QueryWrapper<>();
    wrapper2.eq("email", email).eq("password", EncryptUtils.encrypt(password));

    TbUser tbUser2 = tbUserMapper.selectOne(wrapper2);
    if (tbUser2 == null) {
      throw new VMallException(VMallExceptionEnum.WRONG_PASSWORD);
    }

    UserVO userVO = new UserVO();
    BeanUtils.copyProperties(tbUser2, userVO);
    return userVO;
  }

  @NotNull
  private TbUser createUser(String email, String password) {
    TbUser user = new TbUser();
    user.setEmail(email);
    user.setUsername(email);
    user.setId(CoreUtils.generateId());
    user.setPassword(EncryptUtils.encrypt(password));
    return user;
  }

  private UserVO findUserWithPassword(
    String column,
    Object value,
    String password
  ) throws VMallException {
    QueryWrapper<TbUser> wrapper = new QueryWrapper<>();
    wrapper.eq(column, value).eq("password", EncryptUtils.encrypt(password));

    TbUser tbUser = tbUserMapper.selectOne(wrapper);
    if (tbUser == null) {
      throw new VMallException(VMallExceptionEnum.USER_NOT_FOUND);
    }
    UserVO userVO = new UserVO();
    BeanUtils.copyProperties(tbUser, userVO);
    return userVO;
  }

  private UserVO findUser(String column, Object value) throws VMallException {
    QueryWrapper<TbUser> wrapper = new QueryWrapper<>();
    wrapper.eq(column, value);

    TbUser tbUser = tbUserMapper.selectOne(wrapper);
    if (tbUser == null) {
      throw new VMallException(VMallExceptionEnum.USER_NOT_FOUND);
    }
    UserVO userVO = new UserVO();
    BeanUtils.copyProperties(tbUser, userVO);
    return userVO;
  }
}
