package com.cn.zyrs.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SystemInterceptor
  implements HandlerInterceptor
{
  private static Logger logger = Logger.getLogger(SystemInterceptor.class);
  private static PathMatcher matcher = new AntPathMatcher();
  private static final String[] noInterceptor = { "/login", "/css/**/*.*" };
  
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
    throws Exception
  {
    logger.info("access: " + request.getRequestURI());
    
    String requestUri = request.getRequestURI();
    String contextPath = request.getContextPath();
    String uri = requestUri.substring(contextPath.length(), requestUri.length());
    
    boolean doInterceptor = true;
    String[] arrayOfString;
    int j = (arrayOfString = noInterceptor).length;
    for (int i = 0; i < j; i++)
    {
      String strUri = arrayOfString[i];
      if (matcher.match(strUri, uri))
      {
        doInterceptor = false;
        break;
      }
    }
    return true;
  }
  
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
    throws Exception
  {}
  
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
    throws Exception
  {}
}
