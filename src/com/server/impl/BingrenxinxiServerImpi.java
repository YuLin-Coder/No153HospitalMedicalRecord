package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.BingrenxinxiMapper;
import com.entity.Bingrenxinxi;
import com.server.BingrenxinxiServer;
@Service
public class BingrenxinxiServerImpi implements BingrenxinxiServer {
   @Resource
   private BingrenxinxiMapper gdao;
	@Override
	public int add(Bingrenxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Bingrenxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Bingrenxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Bingrenxinxi> getsybingrenxinxi1(Map<String, Object> map) {
		return gdao.getsybingrenxinxi1(map);
	}
	public List<Bingrenxinxi> getsybingrenxinxi2(Map<String, Object> map) {
		return gdao.getsybingrenxinxi2(map);
	}
	public List<Bingrenxinxi> getsybingrenxinxi3(Map<String, Object> map) {
		return gdao.getsybingrenxinxi3(map);
	}
	
	@Override
	public Bingrenxinxi quchongBingrenxinxi(Map<String, Object> account) {
		return gdao.quchongBingrenxinxi(account);
	}

	@Override
	public List<Bingrenxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Bingrenxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Bingrenxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

