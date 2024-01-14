package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Yishengxinxi;

public interface YishengxinxiServer {

  public int add(Yishengxinxi po);

  public int update(Yishengxinxi po);
  
  
  
  public int delete(int id);

  public List<Yishengxinxi> getAll(Map<String,Object> map);
  public List<Yishengxinxi> getsyyishengxinxi1(Map<String,Object> map);
  public List<Yishengxinxi> getsyyishengxinxi2(Map<String,Object> map);
  public List<Yishengxinxi> getsyyishengxinxi3(Map<String,Object> map);
  public Yishengxinxi quchongYishengxinxi(Map<String, Object> acount);

  public Yishengxinxi getById( int id);

  public List<Yishengxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Yishengxinxi> select(Map<String, Object> map);
}
//	所有List
