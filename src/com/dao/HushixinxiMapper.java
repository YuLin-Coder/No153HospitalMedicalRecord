package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Hushixinxi;

public interface HushixinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hushixinxi record);

    int insertSelective(Hushixinxi record);

    Hushixinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hushixinxi record);
	
    int updateByPrimaryKey(Hushixinxi record);
	public Hushixinxi quchongHushixinxi(Map<String, Object> hushigonghao);
	public List<Hushixinxi> getAll(Map<String, Object> map);
	public List<Hushixinxi> getsyhushixinxi1(Map<String, Object> map);
	public List<Hushixinxi> getsyhushixinxi3(Map<String, Object> map);
	public List<Hushixinxi> getsyhushixinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Hushixinxi> getByPage(Map<String, Object> map);
	public List<Hushixinxi> select(Map<String, Object> map);
//	所有List
}

