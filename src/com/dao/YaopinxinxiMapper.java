package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Yaopinxinxi;

public interface YaopinxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Yaopinxinxi record);

    int insertSelective(Yaopinxinxi record);

    Yaopinxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Yaopinxinxi record);
	
    int updateByPrimaryKey(Yaopinxinxi record);
	public Yaopinxinxi quchongYaopinxinxi(Map<String, Object> yaopinbianhao);
	public List<Yaopinxinxi> getAll(Map<String, Object> map);
	public List<Yaopinxinxi> getsyyaopinxinxi1(Map<String, Object> map);
	public List<Yaopinxinxi> getsyyaopinxinxi3(Map<String, Object> map);
	public List<Yaopinxinxi> getsyyaopinxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Yaopinxinxi> getByPage(Map<String, Object> map);
	public List<Yaopinxinxi> select(Map<String, Object> map);
//	所有List
}

