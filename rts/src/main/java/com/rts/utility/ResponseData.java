package com.rts.utility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseData<T> {

  private Map<String, T> data;
  private Map<String, String> msg;
  private Map<String, List<T>> list;
  private Map<String, List<Map<String, String>>> inputErrors;
  private Map<String, String> businessError;

  public ResponseData() {
  }

  public ResponseData(Map<String, T> data, Map<String, String> msg, Map<String, List<T>> list,
      Map<String, List<Map<String, String>>> inputErrors, Map<String, String> businessError) {
    this.data = data;
    this.msg = msg;
    this.list = list;
    this.inputErrors = inputErrors;
    this.businessError = businessError;
  }

  public Map<String, String> getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    Map<String, String> m = new HashMap<>();
    m.put(Constant.MSG, msg);
    this.msg = m;
  }

  public void setData(T data) {
    Map<String, T> m = new HashMap<>();
    m.put(Constant.DATA, data);
    this.data = m;
  }

  public Map<String, T> getData() {
    return data;
  }

  public Map<String, List<T>> getList() {
    return list;
  }

  public void setList(List<T> list) {
    Map<String, List<T>> m = new HashMap<>();
    m.put(Constant.LIST, list);
    this.list = m;
  }

  public Map<String, List<Map<String, String>>> getInputErrors() {
    return inputErrors;
  }

  public void setInputErrors(List<Map<String, String>> inputErrors) {
    Map<String, List<Map<String, String>>> m = new HashMap<>();

    m.put(Constant.INPUTERRORS, inputErrors);
    this.inputErrors = m;
  }

  public Map<String, String> getBusinessError() {

    return businessError;
  }

  public void setBusinessError(String businessError) {
    Map<String, String> m = new HashMap<>();
    m.put(Constant.BUSINESSERROR, businessError);
    this.businessError = m;
  }

}
