package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Hushixinxi;

public interface HushixinxiServer {

  public int add(Hushixinxi po);

  public int update(Hushixinxi po);
  
  
  
  public int delete(int id);

  public List<Hushixinxi> getAll(Map<String,Object> map);
  public List<Hushixinxi> getsyhushixinxi1(Map<String,Object> map);
  public List<Hushixinxi> getsyhushixinxi2(Map<String,Object> map);
  public List<Hushixinxi> getsyhushixinxi3(Map<String,Object> map);
  public Hushixinxi quchongHushixinxi(Map<String, Object> acount);

  public Hushixinxi getById( int id);

  public List<Hushixinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Hushixinxi> select(Map<String, Object> map);
}
//	所有List
