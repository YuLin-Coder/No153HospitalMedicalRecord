package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Yishengxinxi;

public interface YishengxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Yishengxinxi record);

    int insertSelective(Yishengxinxi record);

    Yishengxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Yishengxinxi record);
	
    int updateByPrimaryKey(Yishengxinxi record);
	public Yishengxinxi quchongYishengxinxi(Map<String, Object> yishenggonghao);
	public List<Yishengxinxi> getAll(Map<String, Object> map);
	public List<Yishengxinxi> getsyyishengxinxi1(Map<String, Object> map);
	public List<Yishengxinxi> getsyyishengxinxi3(Map<String, Object> map);
	public List<Yishengxinxi> getsyyishengxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Yishengxinxi> getByPage(Map<String, Object> map);
	public List<Yishengxinxi> select(Map<String, Object> map);
//	所有List
}

