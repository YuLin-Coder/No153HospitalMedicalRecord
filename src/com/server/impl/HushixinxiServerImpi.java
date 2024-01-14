package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.HushixinxiMapper;
import com.entity.Hushixinxi;
import com.server.HushixinxiServer;
@Service
public class HushixinxiServerImpi implements HushixinxiServer {
   @Resource
   private HushixinxiMapper gdao;
	@Override
	public int add(Hushixinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Hushixinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Hushixinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Hushixinxi> getsyhushixinxi1(Map<String, Object> map) {
		return gdao.getsyhushixinxi1(map);
	}
	public List<Hushixinxi> getsyhushixinxi2(Map<String, Object> map) {
		return gdao.getsyhushixinxi2(map);
	}
	public List<Hushixinxi> getsyhushixinxi3(Map<String, Object> map) {
		return gdao.getsyhushixinxi3(map);
	}
	
	@Override
	public Hushixinxi quchongHushixinxi(Map<String, Object> account) {
		return gdao.quchongHushixinxi(account);
	}

	@Override
	public List<Hushixinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Hushixinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Hushixinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

