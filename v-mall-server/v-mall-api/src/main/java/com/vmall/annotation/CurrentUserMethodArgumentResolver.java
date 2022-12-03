package com.vmall.annotation;

import cn.hutool.core.util.StrUtil;
import com.vmall.common.Constant;
import com.vmall.common.exception.VMallException;
import com.vmall.common.exception.VMallExceptionEnum;
import com.vmall.service.JwtService;
import com.vmall.vo.CurrentUser;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class CurrentUserMethodArgumentResolver
  implements HandlerMethodArgumentResolver {

  @Autowired
  private JwtService jwtService;

  @Override
  public boolean supportsParameter(MethodParameter parameter) {
    //判断是否支持使用@CurrentUser注解的参数; 如果该参数注解有@CurrentUser且参数类型是User
    return (
      parameter.getParameterAnnotation(User.class) != null &&
      parameter.getParameterType() == CurrentUser.class
    );
  }

  @Override
  public Object resolveArgument(
    MethodParameter parameter,
    ModelAndViewContainer mavContainer,
    NativeWebRequest webRequest,
    WebDataBinderFactory binderFactory
  ) throws VMallException {
    HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest(); //注入参数值
    String authorization = request.getHeader(Constant.TOKEN_HEADER);
    if (StrUtil.isEmpty(authorization)) {
      throw new VMallException(VMallExceptionEnum.UNAUTHORIZED);
    }
    return jwtService.parseForUser(authorization);
  }
}
