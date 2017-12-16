package com.cn.zyrs.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import com.cn.zyrs.domain.User;

public class SystemFilter
  implements Filter
{
  private static PathMatcher matcher = new AntPathMatcher();
  private static final String[] noInterceptor = { "/user/login.do", "/css/**/*.*", "/images/**/*.*", "/js/**/*.*", "/umeditor/**/*.*", 
    "/upload/**/*.*", "/checkSession.do", "/verifyCode.do", "/login.jsp" };
  
  public void destroy() {}
  
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
    throws IOException, ServletException
  {
    try
    {
      HttpServletRequest request = (HttpServletRequest)servletRequest;
      HttpServletResponse response = (HttpServletResponse)servletResponse;
      User acDB = (User)request.getSession().getAttribute("loginUser");
      String url = request.getServletPath();
      
      boolean doInterceptor = true;
      String[] arrayOfString;
      int j = (arrayOfString = noInterceptor).length;
      for (int i = 0; i < j; i++)
      {
        String strUri = arrayOfString[i];
        if (matcher.match(strUri, url))
        {
          doInterceptor = false;
          break;
        }
      }
      if (doInterceptor)
      {
        if (acDB != null)
        {
          filterChain.doFilter(request, response);
        }
        else if ((request.getHeader("x-requested-with") != null) && 
          (request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")))
        {
          PrintWriter wirter = response.getWriter();
          wirter.write("timeout");
          wirter.flush();
        }
        else
        {
          response.sendRedirect(request.getContextPath());
        }
      }
      else {
        filterChain.doFilter(request, response);
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
  
  public void init(FilterConfig arg0)
    throws ServletException
  {}
}
