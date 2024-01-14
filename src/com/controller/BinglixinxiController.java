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

import com.entity.Binglixinxi;
import com.server.BinglixinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class BinglixinxiController {
	@Resource
	private BinglixinxiServer binglixinxiService;


   
	@RequestMapping("addBinglixinxi.do")
	public String addBinglixinxi(HttpServletRequest request,Binglixinxi binglixinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		binglixinxi.setAddtime(time.toString().substring(0, 19));
		binglixinxiService.add(binglixinxi);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "binglixinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:binglixinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateBinglixinxi.do")
	public String doUpdateBinglixinxi(int id,ModelMap map,Binglixinxi binglixinxi){
		binglixinxi=binglixinxiService.getById(id);
		map.put("binglixinxi", binglixinxi);
		return "binglixinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("binglixinxiDetail.do")
	public String binglixinxiDetail(int id,ModelMap map,Binglixinxi binglixinxi){
		binglixinxi=binglixinxiService.getById(id);
		map.put("binglixinxi", binglixinxi);
		return "binglixinxi_detail";
	}
//	前台详细
	@RequestMapping("blxxDetail.do")
	public String blxxDetail(int id,ModelMap map,Binglixinxi binglixinxi){
		binglixinxi=binglixinxiService.getById(id);
		map.put("binglixinxi", binglixinxi);
		return "binglixinxidetail";
	}
//	
	@RequestMapping("updateBinglixinxi.do")
	public String updateBinglixinxi(int id,ModelMap map,Binglixinxi binglixinxi,HttpServletRequest request,HttpSession session){
		binglixinxiService.update(binglixinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:binglixinxiList.do";
	}

//	分页查询
	@RequestMapping("binglixinxiList.do")
	public String binglixinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Binglixinxi binglixinxi, String zhanghao, String xingming, String shenfenzheng, String chushengnianyue, String dianhua, String bingshi, String bingzheng, String zhenduan, String zhiliaofangan){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(chushengnianyue==null||chushengnianyue.equals("")){pmap.put("chushengnianyue", null);}else{pmap.put("chushengnianyue", chushengnianyue);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(bingshi==null||bingshi.equals("")){pmap.put("bingshi", null);}else{pmap.put("bingshi", bingshi);}
		if(bingzheng==null||bingzheng.equals("")){pmap.put("bingzheng", null);}else{pmap.put("bingzheng", bingzheng);}
		if(zhenduan==null||zhenduan.equals("")){pmap.put("zhenduan", null);}else{pmap.put("zhenduan", zhenduan);}
		if(zhiliaofangan==null||zhiliaofangan.equals("")){pmap.put("zhiliaofangan", null);}else{pmap.put("zhiliaofangan", zhiliaofangan);}
		
		int total=binglixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Binglixinxi> list=binglixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "binglixinxi_list";
	}
	
	@RequestMapping("binglixinxi_yanben1.do")
	public String binglixinxi_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Binglixinxi binglixinxi, String zhanghao, String xingming, String shenfenzheng, String chushengnianyue, String dianhua, String bingshi, String bingzheng, String zhenduan, String zhiliaofangan){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(chushengnianyue==null||chushengnianyue.equals("")){pmap.put("chushengnianyue", null);}else{pmap.put("chushengnianyue", chushengnianyue);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(bingshi==null||bingshi.equals("")){pmap.put("bingshi", null);}else{pmap.put("bingshi", bingshi);}
		if(bingzheng==null||bingzheng.equals("")){pmap.put("bingzheng", null);}else{pmap.put("bingzheng", bingzheng);}
		if(zhenduan==null||zhenduan.equals("")){pmap.put("zhenduan", null);}else{pmap.put("zhenduan", zhenduan);}
		if(zhiliaofangan==null||zhiliaofangan.equals("")){pmap.put("zhiliaofangan", null);}else{pmap.put("zhiliaofangan", zhiliaofangan);}
		
		int total=binglixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Binglixinxi> list=binglixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "binglixinxi_yanben1";
	}
	@RequestMapping("binglixinxi_yanben2.do")
	public String binglixinxi_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Binglixinxi binglixinxi, String zhanghao, String xingming, String shenfenzheng, String chushengnianyue, String dianhua, String bingshi, String bingzheng, String zhenduan, String zhiliaofangan){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(chushengnianyue==null||chushengnianyue.equals("")){pmap.put("chushengnianyue", null);}else{pmap.put("chushengnianyue", chushengnianyue);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(bingshi==null||bingshi.equals("")){pmap.put("bingshi", null);}else{pmap.put("bingshi", bingshi);}
		if(bingzheng==null||bingzheng.equals("")){pmap.put("bingzheng", null);}else{pmap.put("bingzheng", bingzheng);}
		if(zhenduan==null||zhenduan.equals("")){pmap.put("zhenduan", null);}else{pmap.put("zhenduan", zhenduan);}
		if(zhiliaofangan==null||zhiliaofangan.equals("")){pmap.put("zhiliaofangan", null);}else{pmap.put("zhiliaofangan", zhiliaofangan);}
		
		int total=binglixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Binglixinxi> list=binglixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "binglixinxi_yanben2";
	}
	@RequestMapping("binglixinxi_yanben3.do")
	public String binglixinxi_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Binglixinxi binglixinxi, String zhanghao, String xingming, String shenfenzheng, String chushengnianyue, String dianhua, String bingshi, String bingzheng, String zhenduan, String zhiliaofangan){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(chushengnianyue==null||chushengnianyue.equals("")){pmap.put("chushengnianyue", null);}else{pmap.put("chushengnianyue", chushengnianyue);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(bingshi==null||bingshi.equals("")){pmap.put("bingshi", null);}else{pmap.put("bingshi", bingshi);}
		if(bingzheng==null||bingzheng.equals("")){pmap.put("bingzheng", null);}else{pmap.put("bingzheng", bingzheng);}
		if(zhenduan==null||zhenduan.equals("")){pmap.put("zhenduan", null);}else{pmap.put("zhenduan", zhenduan);}
		if(zhiliaofangan==null||zhiliaofangan.equals("")){pmap.put("zhiliaofangan", null);}else{pmap.put("zhiliaofangan", zhiliaofangan);}
		
		int total=binglixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Binglixinxi> list=binglixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "binglixinxi_yanben3";
	}
	@RequestMapping("binglixinxi_yanben4.do")
	public String binglixinxi_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Binglixinxi binglixinxi, String zhanghao, String xingming, String shenfenzheng, String chushengnianyue, String dianhua, String bingshi, String bingzheng, String zhenduan, String zhiliaofangan){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(chushengnianyue==null||chushengnianyue.equals("")){pmap.put("chushengnianyue", null);}else{pmap.put("chushengnianyue", chushengnianyue);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(bingshi==null||bingshi.equals("")){pmap.put("bingshi", null);}else{pmap.put("bingshi", bingshi);}
		if(bingzheng==null||bingzheng.equals("")){pmap.put("bingzheng", null);}else{pmap.put("bingzheng", bingzheng);}
		if(zhenduan==null||zhenduan.equals("")){pmap.put("zhenduan", null);}else{pmap.put("zhenduan", zhenduan);}
		if(zhiliaofangan==null||zhiliaofangan.equals("")){pmap.put("zhiliaofangan", null);}else{pmap.put("zhiliaofangan", zhiliaofangan);}
		
		int total=binglixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Binglixinxi> list=binglixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "binglixinxi_yanben4";
	}
	@RequestMapping("binglixinxi_yanben5.do")
	public String binglixinxi_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Binglixinxi binglixinxi, String zhanghao, String xingming, String shenfenzheng, String chushengnianyue, String dianhua, String bingshi, String bingzheng, String zhenduan, String zhiliaofangan){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(chushengnianyue==null||chushengnianyue.equals("")){pmap.put("chushengnianyue", null);}else{pmap.put("chushengnianyue", chushengnianyue);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(bingshi==null||bingshi.equals("")){pmap.put("bingshi", null);}else{pmap.put("bingshi", bingshi);}
		if(bingzheng==null||bingzheng.equals("")){pmap.put("bingzheng", null);}else{pmap.put("bingzheng", bingzheng);}
		if(zhenduan==null||zhenduan.equals("")){pmap.put("zhenduan", null);}else{pmap.put("zhenduan", zhenduan);}
		if(zhiliaofangan==null||zhiliaofangan.equals("")){pmap.put("zhiliaofangan", null);}else{pmap.put("zhiliaofangan", zhiliaofangan);}
		
		int total=binglixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Binglixinxi> list=binglixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "binglixinxi_yanben5";
	}
	
	
	
	@RequestMapping("blxxList.do")
	public String blxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Binglixinxi binglixinxi, String zhanghao, String xingming, String shenfenzheng, String chushengnianyue, String dianhua, String bingshi, String bingzheng, String zhenduan, String zhiliaofangan){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(chushengnianyue==null||chushengnianyue.equals("")){pmap.put("chushengnianyue", null);}else{pmap.put("chushengnianyue", chushengnianyue);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(bingshi==null||bingshi.equals("")){pmap.put("bingshi", null);}else{pmap.put("bingshi", bingshi);}
		if(bingzheng==null||bingzheng.equals("")){pmap.put("bingzheng", null);}else{pmap.put("bingzheng", bingzheng);}
		if(zhenduan==null||zhenduan.equals("")){pmap.put("zhenduan", null);}else{pmap.put("zhenduan", zhenduan);}
		if(zhiliaofangan==null||zhiliaofangan.equals("")){pmap.put("zhiliaofangan", null);}else{pmap.put("zhiliaofangan", zhiliaofangan);}
		
		int total=binglixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Binglixinxi> list=binglixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "binglixinxilist";
	}
	@RequestMapping("blxxListtp.do")
	public String blxxListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Binglixinxi binglixinxi, String zhanghao, String xingming, String shenfenzheng, String chushengnianyue, String dianhua, String bingshi, String bingzheng, String zhenduan, String zhiliaofangan){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(chushengnianyue==null||chushengnianyue.equals("")){pmap.put("chushengnianyue", null);}else{pmap.put("chushengnianyue", chushengnianyue);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(bingshi==null||bingshi.equals("")){pmap.put("bingshi", null);}else{pmap.put("bingshi", bingshi);}
		if(bingzheng==null||bingzheng.equals("")){pmap.put("bingzheng", null);}else{pmap.put("bingzheng", bingzheng);}
		if(zhenduan==null||zhenduan.equals("")){pmap.put("zhenduan", null);}else{pmap.put("zhenduan", zhenduan);}
		if(zhiliaofangan==null||zhiliaofangan.equals("")){pmap.put("zhiliaofangan", null);}else{pmap.put("zhiliaofangan", zhiliaofangan);}
		
		int total=binglixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Binglixinxi> list=binglixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "binglixinxilisttp";
	}
	
	@RequestMapping("deleteBinglixinxi.do")
	public String deleteBinglixinxi(int id,HttpServletRequest request){
		binglixinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:binglixinxiList.do";
	}
	
	
}
