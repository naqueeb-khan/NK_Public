package com.rts.utility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseData<T> {

  private T data;
  private String msg;
  private List<T> list;
  private  Map<String,String> inputErrors;
  private String businessError;

  public ResponseData() {
  }


  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public void setData(T data) {
    this.data = data;
  }

  public  T getData() {
    return data;
  }

  public List<T> getList() {
    return list;
  }

  public void setList(List<T> list) {  
    this.list = list;
  }

  public Map<String, String> getInputErrors() {
    return inputErrors;
  }

  public void setInputErrors(Map<String,String> inputErrors) {
    this.inputErrors = inputErrors;
  }

  public String getBusinessError() {
    return businessError;
  }

  public void setBusinessError(String businessError) { 
    this.businessError = businessError;
  }
}
