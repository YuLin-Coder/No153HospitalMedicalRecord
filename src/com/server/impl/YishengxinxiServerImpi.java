package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.YishengxinxiMapper;
import com.entity.Yishengxinxi;
import com.server.YishengxinxiServer;
@Service
public class YishengxinxiServerImpi implements YishengxinxiServer {
   @Resource
   private YishengxinxiMapper gdao;
	@Override
	public int add(Yishengxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Yishengxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Yishengxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Yishengxinxi> getsyyishengxinxi1(Map<String, Object> map) {
		return gdao.getsyyishengxinxi1(map);
	}
	public List<Yishengxinxi> getsyyishengxinxi2(Map<String, Object> map) {
		return gdao.getsyyishengxinxi2(map);
	}
	public List<Yishengxinxi> getsyyishengxinxi3(Map<String, Object> map) {
		return gdao.getsyyishengxinxi3(map);
	}
	
	@Override
	public Yishengxinxi quchongYishengxinxi(Map<String, Object> account) {
		return gdao.quchongYishengxinxi(account);
	}

	@Override
	public List<Yishengxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Yishengxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Yishengxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

