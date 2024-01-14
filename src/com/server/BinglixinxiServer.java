package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Binglixinxi;

public interface BinglixinxiServer {

  public int add(Binglixinxi po);

  public int update(Binglixinxi po);
  
  
  
  public int delete(int id);

  public List<Binglixinxi> getAll(Map<String,Object> map);
  public List<Binglixinxi> getsybinglixinxi1(Map<String,Object> map);
  public List<Binglixinxi> getsybinglixinxi2(Map<String,Object> map);
  public List<Binglixinxi> getsybinglixinxi3(Map<String,Object> map);
  public Binglixinxi quchongBinglixinxi(Map<String, Object> acount);

  public Binglixinxi getById( int id);

  public List<Binglixinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Binglixinxi> select(Map<String, Object> map);
}
//	所有List
