package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.YaopinxinxiMapper;
import com.entity.Yaopinxinxi;
import com.server.YaopinxinxiServer;
@Service
public class YaopinxinxiServerImpi implements YaopinxinxiServer {
   @Resource
   private YaopinxinxiMapper gdao;
	@Override
	public int add(Yaopinxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Yaopinxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Yaopinxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Yaopinxinxi> getsyyaopinxinxi1(Map<String, Object> map) {
		return gdao.getsyyaopinxinxi1(map);
	}
	public List<Yaopinxinxi> getsyyaopinxinxi2(Map<String, Object> map) {
		return gdao.getsyyaopinxinxi2(map);
	}
	public List<Yaopinxinxi> getsyyaopinxinxi3(Map<String, Object> map) {
		return gdao.getsyyaopinxinxi3(map);
	}
	
	@Override
	public Yaopinxinxi quchongYaopinxinxi(Map<String, Object> account) {
		return gdao.quchongYaopinxinxi(account);
	}

	@Override
	public List<Yaopinxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Yaopinxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Yaopinxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

