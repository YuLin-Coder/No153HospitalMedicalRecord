package com.controller;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Yishengxinxi;
import com.server.YishengxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class YishengxinxiController {
	@Resource
	private YishengxinxiServer yishengxinxiService;


   
	@RequestMapping("addYishengxinxi.do")
	public String addYishengxinxi(HttpServletRequest request,Yishengxinxi yishengxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		yishengxinxi.setAddtime(time.toString().substring(0, 19));
		yishengxinxiService.add(yishengxinxi);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "yishengxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:yishengxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateYishengxinxi.do")
	public String doUpdateYishengxinxi(int id,ModelMap map,Yishengxinxi yishengxinxi){
		yishengxinxi=yishengxinxiService.getById(id);
		map.put("yishengxinxi", yishengxinxi);
		return "yishengxinxi_updt";
	}
	
	@RequestMapping("doUpdateYishengxinxi2.do")
	public String doUpdateYishengxinxi2(ModelMap map,Yishengxinxi yishengxinxi,HttpServletRequest request){
		yishengxinxi=yishengxinxiService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("yishengxinxi", yishengxinxi);
		return "yishengxinxi_updt2";
	}
	
@RequestMapping("updateYishengxinxi2.do")
	public String updateYishengxinxi2(int id,ModelMap map,Yishengxinxi yishengxinxi){
		yishengxinxiService.update(yishengxinxi);
		return "redirect:doUpdateYishengxinxi2.do";
	}
	
	
	
//	后台详细
	@RequestMapping("yishengxinxiDetail.do")
	public String yishengxinxiDetail(int id,ModelMap map,Yishengxinxi yishengxinxi){
		yishengxinxi=yishengxinxiService.getById(id);
		map.put("yishengxinxi", yishengxinxi);
		return "yishengxinxi_detail";
	}
//	前台详细
	@RequestMapping("ysxxDetail.do")
	public String ysxxDetail(int id,ModelMap map,Yishengxinxi yishengxinxi){
		yishengxinxi=yishengxinxiService.getById(id);
		map.put("yishengxinxi", yishengxinxi);
		return "yishengxinxidetail";
	}
//	
	@RequestMapping("updateYishengxinxi.do")
	public String updateYishengxinxi(int id,ModelMap map,Yishengxinxi yishengxinxi,HttpServletRequest request,HttpSession session){
		yishengxinxiService.update(yishengxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:yishengxinxiList.do";
	}

//	分页查询
	@RequestMapping("yishengxinxiList.do")
	public String yishengxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yishengxinxi yishengxinxi, String yishenggonghao, String yishengxingming, String mima, String xingbie, String zhicheng, String suozaikeshi, String zhuzhizhengzhuang, String lianxidianhua, String shenfenzheng, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yishenggonghao==null||yishenggonghao.equals("")){pmap.put("yishenggonghao", null);}else{pmap.put("yishenggonghao", yishenggonghao);}
		if(yishengxingming==null||yishengxingming.equals("")){pmap.put("yishengxingming", null);}else{pmap.put("yishengxingming", yishengxingming);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(zhicheng==null||zhicheng.equals("")){pmap.put("zhicheng", null);}else{pmap.put("zhicheng", zhicheng);}
		if(suozaikeshi==null||suozaikeshi.equals("")){pmap.put("suozaikeshi", null);}else{pmap.put("suozaikeshi", suozaikeshi);}
		if(zhuzhizhengzhuang==null||zhuzhizhengzhuang.equals("")){pmap.put("zhuzhizhengzhuang", null);}else{pmap.put("zhuzhizhengzhuang", zhuzhizhengzhuang);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=yishengxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yishengxinxi> list=yishengxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yishengxinxi_list";
	}
	
	@RequestMapping("yishengxinxi_yanben1.do")
	public String yishengxinxi_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yishengxinxi yishengxinxi, String yishenggonghao, String yishengxingming, String mima, String xingbie, String zhicheng, String suozaikeshi, String zhuzhizhengzhuang, String lianxidianhua, String shenfenzheng, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yishenggonghao==null||yishenggonghao.equals("")){pmap.put("yishenggonghao", null);}else{pmap.put("yishenggonghao", yishenggonghao);}
		if(yishengxingming==null||yishengxingming.equals("")){pmap.put("yishengxingming", null);}else{pmap.put("yishengxingming", yishengxingming);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(zhicheng==null||zhicheng.equals("")){pmap.put("zhicheng", null);}else{pmap.put("zhicheng", zhicheng);}
		if(suozaikeshi==null||suozaikeshi.equals("")){pmap.put("suozaikeshi", null);}else{pmap.put("suozaikeshi", suozaikeshi);}
		if(zhuzhizhengzhuang==null||zhuzhizhengzhuang.equals("")){pmap.put("zhuzhizhengzhuang", null);}else{pmap.put("zhuzhizhengzhuang", zhuzhizhengzhuang);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=yishengxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yishengxinxi> list=yishengxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yishengxinxi_yanben1";
	}
	@RequestMapping("yishengxinxi_yanben2.do")
	public String yishengxinxi_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yishengxinxi yishengxinxi, String yishenggonghao, String yishengxingming, String mima, String xingbie, String zhicheng, String suozaikeshi, String zhuzhizhengzhuang, String lianxidianhua, String shenfenzheng, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yishenggonghao==null||yishenggonghao.equals("")){pmap.put("yishenggonghao", null);}else{pmap.put("yishenggonghao", yishenggonghao);}
		if(yishengxingming==null||yishengxingming.equals("")){pmap.put("yishengxingming", null);}else{pmap.put("yishengxingming", yishengxingming);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(zhicheng==null||zhicheng.equals("")){pmap.put("zhicheng", null);}else{pmap.put("zhicheng", zhicheng);}
		if(suozaikeshi==null||suozaikeshi.equals("")){pmap.put("suozaikeshi", null);}else{pmap.put("suozaikeshi", suozaikeshi);}
		if(zhuzhizhengzhuang==null||zhuzhizhengzhuang.equals("")){pmap.put("zhuzhizhengzhuang", null);}else{pmap.put("zhuzhizhengzhuang", zhuzhizhengzhuang);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=yishengxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yishengxinxi> list=yishengxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yishengxinxi_yanben2";
	}
	@RequestMapping("yishengxinxi_yanben3.do")
	public String yishengxinxi_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yishengxinxi yishengxinxi, String yishenggonghao, String yishengxingming, String mima, String xingbie, String zhicheng, String suozaikeshi, String zhuzhizhengzhuang, String lianxidianhua, String shenfenzheng, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yishenggonghao==null||yishenggonghao.equals("")){pmap.put("yishenggonghao", null);}else{pmap.put("yishenggonghao", yishenggonghao);}
		if(yishengxingming==null||yishengxingming.equals("")){pmap.put("yishengxingming", null);}else{pmap.put("yishengxingming", yishengxingming);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(zhicheng==null||zhicheng.equals("")){pmap.put("zhicheng", null);}else{pmap.put("zhicheng", zhicheng);}
		if(suozaikeshi==null||suozaikeshi.equals("")){pmap.put("suozaikeshi", null);}else{pmap.put("suozaikeshi", suozaikeshi);}
		if(zhuzhizhengzhuang==null||zhuzhizhengzhuang.equals("")){pmap.put("zhuzhizhengzhuang", null);}else{pmap.put("zhuzhizhengzhuang", zhuzhizhengzhuang);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=yishengxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yishengxinxi> list=yishengxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yishengxinxi_yanben3";
	}
	@RequestMapping("yishengxinxi_yanben4.do")
	public String yishengxinxi_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yishengxinxi yishengxinxi, String yishenggonghao, String yishengxingming, String mima, String xingbie, String zhicheng, String suozaikeshi, String zhuzhizhengzhuang, String lianxidianhua, String shenfenzheng, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yishenggonghao==null||yishenggonghao.equals("")){pmap.put("yishenggonghao", null);}else{pmap.put("yishenggonghao", yishenggonghao);}
		if(yishengxingming==null||yishengxingming.equals("")){pmap.put("yishengxingming", null);}else{pmap.put("yishengxingming", yishengxingming);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(zhicheng==null||zhicheng.equals("")){pmap.put("zhicheng", null);}else{pmap.put("zhicheng", zhicheng);}
		if(suozaikeshi==null||suozaikeshi.equals("")){pmap.put("suozaikeshi", null);}else{pmap.put("suozaikeshi", suozaikeshi);}
		if(zhuzhizhengzhuang==null||zhuzhizhengzhuang.equals("")){pmap.put("zhuzhizhengzhuang", null);}else{pmap.put("zhuzhizhengzhuang", zhuzhizhengzhuang);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=yishengxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yishengxinxi> list=yishengxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yishengxinxi_yanben4";
	}
	@RequestMapping("yishengxinxi_yanben5.do")
	public String yishengxinxi_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yishengxinxi yishengxinxi, String yishenggonghao, String yishengxingming, String mima, String xingbie, String zhicheng, String suozaikeshi, String zhuzhizhengzhuang, String lianxidianhua, String shenfenzheng, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yishenggonghao==null||yishenggonghao.equals("")){pmap.put("yishenggonghao", null);}else{pmap.put("yishenggonghao", yishenggonghao);}
		if(yishengxingming==null||yishengxingming.equals("")){pmap.put("yishengxingming", null);}else{pmap.put("yishengxingming", yishengxingming);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(zhicheng==null||zhicheng.equals("")){pmap.put("zhicheng", null);}else{pmap.put("zhicheng", zhicheng);}
		if(suozaikeshi==null||suozaikeshi.equals("")){pmap.put("suozaikeshi", null);}else{pmap.put("suozaikeshi", suozaikeshi);}
		if(zhuzhizhengzhuang==null||zhuzhizhengzhuang.equals("")){pmap.put("zhuzhizhengzhuang", null);}else{pmap.put("zhuzhizhengzhuang", zhuzhizhengzhuang);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=yishengxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yishengxinxi> list=yishengxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yishengxinxi_yanben5";
	}
	
	
	
	@RequestMapping("ysxxList.do")
	public String ysxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yishengxinxi yishengxinxi, String yishenggonghao, String yishengxingming, String mima, String xingbie, String zhicheng, String suozaikeshi, String zhuzhizhengzhuang, String lianxidianhua, String shenfenzheng, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yishenggonghao==null||yishenggonghao.equals("")){pmap.put("yishenggonghao", null);}else{pmap.put("yishenggonghao", yishenggonghao);}
		if(yishengxingming==null||yishengxingming.equals("")){pmap.put("yishengxingming", null);}else{pmap.put("yishengxingming", yishengxingming);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(zhicheng==null||zhicheng.equals("")){pmap.put("zhicheng", null);}else{pmap.put("zhicheng", zhicheng);}
		if(suozaikeshi==null||suozaikeshi.equals("")){pmap.put("suozaikeshi", null);}else{pmap.put("suozaikeshi", suozaikeshi);}
		if(zhuzhizhengzhuang==null||zhuzhizhengzhuang.equals("")){pmap.put("zhuzhizhengzhuang", null);}else{pmap.put("zhuzhizhengzhuang", zhuzhizhengzhuang);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=yishengxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yishengxinxi> list=yishengxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yishengxinxilist";
	}
	@RequestMapping("ysxxListtp.do")
	public String ysxxListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yishengxinxi yishengxinxi, String yishenggonghao, String yishengxingming, String mima, String xingbie, String zhicheng, String suozaikeshi, String zhuzhizhengzhuang, String lianxidianhua, String shenfenzheng, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yishenggonghao==null||yishenggonghao.equals("")){pmap.put("yishenggonghao", null);}else{pmap.put("yishenggonghao", yishenggonghao);}
		if(yishengxingming==null||yishengxingming.equals("")){pmap.put("yishengxingming", null);}else{pmap.put("yishengxingming", yishengxingming);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(zhicheng==null||zhicheng.equals("")){pmap.put("zhicheng", null);}else{pmap.put("zhicheng", zhicheng);}
		if(suozaikeshi==null||suozaikeshi.equals("")){pmap.put("suozaikeshi", null);}else{pmap.put("suozaikeshi", suozaikeshi);}
		if(zhuzhizhengzhuang==null||zhuzhizhengzhuang.equals("")){pmap.put("zhuzhizhengzhuang", null);}else{pmap.put("zhuzhizhengzhuang", zhuzhizhengzhuang);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=yishengxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yishengxinxi> list=yishengxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yishengxinxilisttp";
	}
	
	@RequestMapping("deleteYishengxinxi.do")
	public String deleteYishengxinxi(int id,HttpServletRequest request){
		yishengxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:yishengxinxiList.do";
	}
	
	@RequestMapping("quchongYishengxinxi.do")
	public void quchongYishengxinxi(Yishengxinxi yishengxinxi,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("yishenggonghao", yishengxinxi.getYishenggonghao());
		   System.out.println("yishenggonghao==="+yishengxinxi.getYishenggonghao());
		   System.out.println("yishenggonghao222==="+yishengxinxiService.quchongYishengxinxi(map));
		   JSONObject obj=new JSONObject();
		   if(yishengxinxiService.quchongYishengxinxi(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "医生工号可以用！");
				  
			   }
		   response.setContentType("text/html;charset=utf-8");
		   PrintWriter out=null;
		   try {
			out=response.getWriter();
			out.print(obj);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
}
