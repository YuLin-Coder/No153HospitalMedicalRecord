package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.BinglixinxiMapper;
import com.entity.Binglixinxi;
import com.server.BinglixinxiServer;
@Service
public class BinglixinxiServerImpi implements BinglixinxiServer {
   @Resource
   private BinglixinxiMapper gdao;
	@Override
	public int add(Binglixinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Binglixinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Binglixinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Binglixinxi> getsybinglixinxi1(Map<String, Object> map) {
		return gdao.getsybinglixinxi1(map);
	}
	public List<Binglixinxi> getsybinglixinxi2(Map<String, Object> map) {
		return gdao.getsybinglixinxi2(map);
	}
	public List<Binglixinxi> getsybinglixinxi3(Map<String, Object> map) {
		return gdao.getsybinglixinxi3(map);
	}
	
	@Override
	public Binglixinxi quchongBinglixinxi(Map<String, Object> account) {
		return gdao.quchongBinglixinxi(account);
	}

	@Override
	public List<Binglixinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Binglixinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Binglixinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

