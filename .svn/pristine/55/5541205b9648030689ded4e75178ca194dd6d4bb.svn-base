package com.cn.zyrs.domain;

import java.io.Serializable;

public class ResultJsonBean
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private boolean success;
  private Object result;
  private String errorCode;
  private String errorDescription;
  
  public ResultJsonBean()
  {
    this.result = "";
    this.errorCode = "";
    this.errorDescription = "";
  }
  
  public ResultJsonBean(boolean success, Object result)
  {
    this.success = success;
    this.result = result;
    this.errorCode = "";
    this.errorDescription = "";
  }
  
  public ResultJsonBean(Object result)
  {
    this.result = result;
  }
  
  public ResultJsonBean(boolean success, String errorCode, String errorDescription)
  {
    this.success = success;
    this.result = "";
    this.errorCode = errorCode;
    this.errorDescription = errorDescription;
  }
  
  public ResultJsonBean(boolean success, Object result, String errorCode, String errorDescription)
  {
    this.success = success;
    this.result = result;
    this.errorCode = errorCode;
    this.errorDescription = errorDescription;
  }
  
  public ResultJsonBean(boolean success, Object result, String errorCode)
  {
    this.success = success;
    this.result = result;
    this.errorCode = errorCode;
  }
  
  public boolean isSuccess()
  {
    return this.success;
  }
  
  public void setSuccess(boolean success)
  {
    this.success = success;
  }
  
  public Object getResult()
  {
    return this.result;
  }
  
  public void setResult(Object result)
  {
    this.result = result;
  }
  
  public String getErrorCode()
  {
    return this.errorCode;
  }
  
  public void setErrorCode(String errorCode)
  {
    this.errorCode = errorCode;
  }
  
  public String getErrorDescription()
  {
    return this.errorDescription;
  }
  
  public void setErrorDescription(String errorDescription)
  {
    this.errorDescription = errorDescription;
  }
}
