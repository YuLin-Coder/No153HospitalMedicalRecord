package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Bingrenxinxi;

public interface BingrenxinxiServer {

  public int add(Bingrenxinxi po);

  public int update(Bingrenxinxi po);
  
  
  
  public int delete(int id);

  public List<Bingrenxinxi> getAll(Map<String,Object> map);
  public List<Bingrenxinxi> getsybingrenxinxi1(Map<String,Object> map);
  public List<Bingrenxinxi> getsybingrenxinxi2(Map<String,Object> map);
  public List<Bingrenxinxi> getsybingrenxinxi3(Map<String,Object> map);
  public Bingrenxinxi quchongBingrenxinxi(Map<String, Object> acount);

  public Bingrenxinxi getById( int id);

  public List<Bingrenxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Bingrenxinxi> select(Map<String, Object> map);
}
//	所有List
