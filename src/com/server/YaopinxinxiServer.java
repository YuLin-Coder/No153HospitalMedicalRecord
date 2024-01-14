package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Yaopinxinxi;

public interface YaopinxinxiServer {

  public int add(Yaopinxinxi po);

  public int update(Yaopinxinxi po);
  
  
  
  public int delete(int id);

  public List<Yaopinxinxi> getAll(Map<String,Object> map);
  public List<Yaopinxinxi> getsyyaopinxinxi1(Map<String,Object> map);
  public List<Yaopinxinxi> getsyyaopinxinxi2(Map<String,Object> map);
  public List<Yaopinxinxi> getsyyaopinxinxi3(Map<String,Object> map);
  public Yaopinxinxi quchongYaopinxinxi(Map<String, Object> acount);

  public Yaopinxinxi getById( int id);

  public List<Yaopinxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Yaopinxinxi> select(Map<String, Object> map);
}
//	所有List
