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

import com.entity.Bingrenxinxi;
import com.server.BingrenxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class BingrenxinxiController {
	@Resource
	private BingrenxinxiServer bingrenxinxiService;


   
	@RequestMapping("addBingrenxinxi.do")
	public String addBingrenxinxi(HttpServletRequest request,Bingrenxinxi bingrenxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		bingrenxinxi.setAddtime(time.toString().substring(0, 19));
		bingrenxinxiService.add(bingrenxinxi);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "bingrenxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:bingrenxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateBingrenxinxi.do")
	public String doUpdateBingrenxinxi(int id,ModelMap map,Bingrenxinxi bingrenxinxi){
		bingrenxinxi=bingrenxinxiService.getById(id);
		map.put("bingrenxinxi", bingrenxinxi);
		return "bingrenxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("bingrenxinxiDetail.do")
	public String bingrenxinxiDetail(int id,ModelMap map,Bingrenxinxi bingrenxinxi){
		bingrenxinxi=bingrenxinxiService.getById(id);
		map.put("bingrenxinxi", bingrenxinxi);
		return "bingrenxinxi_detail";
	}
//	前台详细
	@RequestMapping("brxxDetail.do")
	public String brxxDetail(int id,ModelMap map,Bingrenxinxi bingrenxinxi){
		bingrenxinxi=bingrenxinxiService.getById(id);
		map.put("bingrenxinxi", bingrenxinxi);
		return "bingrenxinxidetail";
	}
//	
	@RequestMapping("updateBingrenxinxi.do")
	public String updateBingrenxinxi(int id,ModelMap map,Bingrenxinxi bingrenxinxi,HttpServletRequest request,HttpSession session){
		bingrenxinxiService.update(bingrenxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:bingrenxinxiList.do";
	}

//	分页查询
	@RequestMapping("bingrenxinxiList.do")
	public String bingrenxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Bingrenxinxi bingrenxinxi, String zhanghao, String xingming, String xingbie, String shenfenzheng, String chushengnianyue1,String chushengnianyue2, String dianhua, String dizhi, String bingshi, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(chushengnianyue1==null||chushengnianyue1.equals("")){pmap.put("chushengnianyue1", null);}else{pmap.put("chushengnianyue1", chushengnianyue1);}
		if(chushengnianyue2==null||chushengnianyue2.equals("")){pmap.put("chushengnianyue2", null);}else{pmap.put("chushengnianyue2", chushengnianyue2);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(bingshi==null||bingshi.equals("")){pmap.put("bingshi", null);}else{pmap.put("bingshi", bingshi);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=bingrenxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Bingrenxinxi> list=bingrenxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "bingrenxinxi_list";
	}
	
	@RequestMapping("bingrenxinxi_yanben1.do")
	public String bingrenxinxi_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Bingrenxinxi bingrenxinxi, String zhanghao, String xingming, String xingbie, String shenfenzheng, String chushengnianyue1,String chushengnianyue2, String dianhua, String dizhi, String bingshi, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(chushengnianyue1==null||chushengnianyue1.equals("")){pmap.put("chushengnianyue1", null);}else{pmap.put("chushengnianyue1", chushengnianyue1);}
		if(chushengnianyue2==null||chushengnianyue2.equals("")){pmap.put("chushengnianyue2", null);}else{pmap.put("chushengnianyue2", chushengnianyue2);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(bingshi==null||bingshi.equals("")){pmap.put("bingshi", null);}else{pmap.put("bingshi", bingshi);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=bingrenxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Bingrenxinxi> list=bingrenxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "bingrenxinxi_yanben1";
	}
	@RequestMapping("bingrenxinxi_yanben2.do")
	public String bingrenxinxi_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Bingrenxinxi bingrenxinxi, String zhanghao, String xingming, String xingbie, String shenfenzheng, String chushengnianyue1,String chushengnianyue2, String dianhua, String dizhi, String bingshi, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(chushengnianyue1==null||chushengnianyue1.equals("")){pmap.put("chushengnianyue1", null);}else{pmap.put("chushengnianyue1", chushengnianyue1);}
		if(chushengnianyue2==null||chushengnianyue2.equals("")){pmap.put("chushengnianyue2", null);}else{pmap.put("chushengnianyue2", chushengnianyue2);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(bingshi==null||bingshi.equals("")){pmap.put("bingshi", null);}else{pmap.put("bingshi", bingshi);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=bingrenxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Bingrenxinxi> list=bingrenxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "bingrenxinxi_yanben2";
	}
	@RequestMapping("bingrenxinxi_yanben3.do")
	public String bingrenxinxi_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Bingrenxinxi bingrenxinxi, String zhanghao, String xingming, String xingbie, String shenfenzheng, String chushengnianyue1,String chushengnianyue2, String dianhua, String dizhi, String bingshi, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(chushengnianyue1==null||chushengnianyue1.equals("")){pmap.put("chushengnianyue1", null);}else{pmap.put("chushengnianyue1", chushengnianyue1);}
		if(chushengnianyue2==null||chushengnianyue2.equals("")){pmap.put("chushengnianyue2", null);}else{pmap.put("chushengnianyue2", chushengnianyue2);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(bingshi==null||bingshi.equals("")){pmap.put("bingshi", null);}else{pmap.put("bingshi", bingshi);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=bingrenxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Bingrenxinxi> list=bingrenxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "bingrenxinxi_yanben3";
	}
	@RequestMapping("bingrenxinxi_yanben4.do")
	public String bingrenxinxi_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Bingrenxinxi bingrenxinxi, String zhanghao, String xingming, String xingbie, String shenfenzheng, String chushengnianyue1,String chushengnianyue2, String dianhua, String dizhi, String bingshi, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(chushengnianyue1==null||chushengnianyue1.equals("")){pmap.put("chushengnianyue1", null);}else{pmap.put("chushengnianyue1", chushengnianyue1);}
		if(chushengnianyue2==null||chushengnianyue2.equals("")){pmap.put("chushengnianyue2", null);}else{pmap.put("chushengnianyue2", chushengnianyue2);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(bingshi==null||bingshi.equals("")){pmap.put("bingshi", null);}else{pmap.put("bingshi", bingshi);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=bingrenxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Bingrenxinxi> list=bingrenxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "bingrenxinxi_yanben4";
	}
	@RequestMapping("bingrenxinxi_yanben5.do")
	public String bingrenxinxi_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Bingrenxinxi bingrenxinxi, String zhanghao, String xingming, String xingbie, String shenfenzheng, String chushengnianyue1,String chushengnianyue2, String dianhua, String dizhi, String bingshi, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(chushengnianyue1==null||chushengnianyue1.equals("")){pmap.put("chushengnianyue1", null);}else{pmap.put("chushengnianyue1", chushengnianyue1);}
		if(chushengnianyue2==null||chushengnianyue2.equals("")){pmap.put("chushengnianyue2", null);}else{pmap.put("chushengnianyue2", chushengnianyue2);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(bingshi==null||bingshi.equals("")){pmap.put("bingshi", null);}else{pmap.put("bingshi", bingshi);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=bingrenxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Bingrenxinxi> list=bingrenxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "bingrenxinxi_yanben5";
	}
	
	
	
	@RequestMapping("brxxList.do")
	public String brxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Bingrenxinxi bingrenxinxi, String zhanghao, String xingming, String xingbie, String shenfenzheng, String chushengnianyue1,String chushengnianyue2, String dianhua, String dizhi, String bingshi, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(chushengnianyue1==null||chushengnianyue1.equals("")){pmap.put("chushengnianyue1", null);}else{pmap.put("chushengnianyue1", chushengnianyue1);}
		if(chushengnianyue2==null||chushengnianyue2.equals("")){pmap.put("chushengnianyue2", null);}else{pmap.put("chushengnianyue2", chushengnianyue2);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(bingshi==null||bingshi.equals("")){pmap.put("bingshi", null);}else{pmap.put("bingshi", bingshi);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=bingrenxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Bingrenxinxi> list=bingrenxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "bingrenxinxilist";
	}
	@RequestMapping("brxxListtp.do")
	public String brxxListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Bingrenxinxi bingrenxinxi, String zhanghao, String xingming, String xingbie, String shenfenzheng, String chushengnianyue1,String chushengnianyue2, String dianhua, String dizhi, String bingshi, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(zhanghao==null||zhanghao.equals("")){pmap.put("zhanghao", null);}else{pmap.put("zhanghao", zhanghao);}
		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(chushengnianyue1==null||chushengnianyue1.equals("")){pmap.put("chushengnianyue1", null);}else{pmap.put("chushengnianyue1", chushengnianyue1);}
		if(chushengnianyue2==null||chushengnianyue2.equals("")){pmap.put("chushengnianyue2", null);}else{pmap.put("chushengnianyue2", chushengnianyue2);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}
		if(bingshi==null||bingshi.equals("")){pmap.put("bingshi", null);}else{pmap.put("bingshi", bingshi);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=bingrenxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Bingrenxinxi> list=bingrenxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "bingrenxinxilisttp";
	}
	
	@RequestMapping("deleteBingrenxinxi.do")
	public String deleteBingrenxinxi(int id,HttpServletRequest request){
		bingrenxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:bingrenxinxiList.do";
	}
	
	@RequestMapping("quchongBingrenxinxi.do")
	public void quchongBingrenxinxi(Bingrenxinxi bingrenxinxi,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("zhanghao", bingrenxinxi.getZhanghao());
		   System.out.println("zhanghao==="+bingrenxinxi.getZhanghao());
		   System.out.println("zhanghao222==="+bingrenxinxiService.quchongBingrenxinxi(map));
		   JSONObject obj=new JSONObject();
		   if(bingrenxinxiService.quchongBingrenxinxi(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "账号可以用！");
				  
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
