package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Bingrenxinxi;

public interface BingrenxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bingrenxinxi record);

    int insertSelective(Bingrenxinxi record);

    Bingrenxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bingrenxinxi record);
	
    int updateByPrimaryKey(Bingrenxinxi record);
	public Bingrenxinxi quchongBingrenxinxi(Map<String, Object> zhanghao);
	public List<Bingrenxinxi> getAll(Map<String, Object> map);
	public List<Bingrenxinxi> getsybingrenxinxi1(Map<String, Object> map);
	public List<Bingrenxinxi> getsybingrenxinxi3(Map<String, Object> map);
	public List<Bingrenxinxi> getsybingrenxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Bingrenxinxi> getByPage(Map<String, Object> map);
	public List<Bingrenxinxi> select(Map<String, Object> map);
//	所有List
}

