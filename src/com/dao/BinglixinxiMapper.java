package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Binglixinxi;

public interface BinglixinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Binglixinxi record);

    int insertSelective(Binglixinxi record);

    Binglixinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Binglixinxi record);
	
    int updateByPrimaryKey(Binglixinxi record);
	public Binglixinxi quchongBinglixinxi(Map<String, Object> zhanghao);
	public List<Binglixinxi> getAll(Map<String, Object> map);
	public List<Binglixinxi> getsybinglixinxi1(Map<String, Object> map);
	public List<Binglixinxi> getsybinglixinxi3(Map<String, Object> map);
	public List<Binglixinxi> getsybinglixinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Binglixinxi> getByPage(Map<String, Object> map);
	public List<Binglixinxi> select(Map<String, Object> map);
//	所有List
}

