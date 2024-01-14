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

import com.entity.Hushixinxi;
import com.server.HushixinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class HushixinxiController {
	@Resource
	private HushixinxiServer hushixinxiService;


   
	@RequestMapping("addHushixinxi.do")
	public String addHushixinxi(HttpServletRequest request,Hushixinxi hushixinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		hushixinxi.setAddtime(time.toString().substring(0, 19));
		hushixinxiService.add(hushixinxi);
		
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "hushixinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:hushixinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateHushixinxi.do")
	public String doUpdateHushixinxi(int id,ModelMap map,Hushixinxi hushixinxi){
		hushixinxi=hushixinxiService.getById(id);
		map.put("hushixinxi", hushixinxi);
		return "hushixinxi_updt";
	}
	
	@RequestMapping("doUpdateHushixinxi2.do")
	public String doUpdateHushixinxi2(ModelMap map,Hushixinxi hushixinxi,HttpServletRequest request){
		hushixinxi=hushixinxiService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("hushixinxi", hushixinxi);
		return "hushixinxi_updt2";
	}
	
@RequestMapping("updateHushixinxi2.do")
	public String updateHushixinxi2(int id,ModelMap map,Hushixinxi hushixinxi){
		hushixinxiService.update(hushixinxi);
		return "redirect:doUpdateHushixinxi2.do";
	}
	
	
	
//	后台详细
	@RequestMapping("hushixinxiDetail.do")
	public String hushixinxiDetail(int id,ModelMap map,Hushixinxi hushixinxi){
		hushixinxi=hushixinxiService.getById(id);
		map.put("hushixinxi", hushixinxi);
		return "hushixinxi_detail";
	}
//	前台详细
	@RequestMapping("hsxxDetail.do")
	public String hsxxDetail(int id,ModelMap map,Hushixinxi hushixinxi){
		hushixinxi=hushixinxiService.getById(id);
		map.put("hushixinxi", hushixinxi);
		return "hushixinxidetail";
	}
//	
	@RequestMapping("updateHushixinxi.do")
	public String updateHushixinxi(int id,ModelMap map,Hushixinxi hushixinxi,HttpServletRequest request,HttpSession session){
		hushixinxiService.update(hushixinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:hushixinxiList.do";
	}

//	分页查询
	@RequestMapping("hushixinxiList.do")
	public String hushixinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hushixinxi hushixinxi, String hushigonghao, String mima, String hushixingming, String xingbie, String dianhua, String shenfenzheng, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(hushigonghao==null||hushigonghao.equals("")){pmap.put("hushigonghao", null);}else{pmap.put("hushigonghao", hushigonghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(hushixingming==null||hushixingming.equals("")){pmap.put("hushixingming", null);}else{pmap.put("hushixingming", hushixingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=hushixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hushixinxi> list=hushixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hushixinxi_list";
	}
	
	@RequestMapping("hushixinxi_yanben1.do")
	public String hushixinxi_yanben1(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hushixinxi hushixinxi, String hushigonghao, String mima, String hushixingming, String xingbie, String dianhua, String shenfenzheng, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(hushigonghao==null||hushigonghao.equals("")){pmap.put("hushigonghao", null);}else{pmap.put("hushigonghao", hushigonghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(hushixingming==null||hushixingming.equals("")){pmap.put("hushixingming", null);}else{pmap.put("hushixingming", hushixingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=hushixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hushixinxi> list=hushixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hushixinxi_yanben1";
	}
	@RequestMapping("hushixinxi_yanben2.do")
	public String hushixinxi_yanben2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hushixinxi hushixinxi, String hushigonghao, String mima, String hushixingming, String xingbie, String dianhua, String shenfenzheng, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(hushigonghao==null||hushigonghao.equals("")){pmap.put("hushigonghao", null);}else{pmap.put("hushigonghao", hushigonghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(hushixingming==null||hushixingming.equals("")){pmap.put("hushixingming", null);}else{pmap.put("hushixingming", hushixingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=hushixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hushixinxi> list=hushixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hushixinxi_yanben2";
	}
	@RequestMapping("hushixinxi_yanben3.do")
	public String hushixinxi_yanben3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hushixinxi hushixinxi, String hushigonghao, String mima, String hushixingming, String xingbie, String dianhua, String shenfenzheng, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(hushigonghao==null||hushigonghao.equals("")){pmap.put("hushigonghao", null);}else{pmap.put("hushigonghao", hushigonghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(hushixingming==null||hushixingming.equals("")){pmap.put("hushixingming", null);}else{pmap.put("hushixingming", hushixingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=hushixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hushixinxi> list=hushixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hushixinxi_yanben3";
	}
	@RequestMapping("hushixinxi_yanben4.do")
	public String hushixinxi_yanben4(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hushixinxi hushixinxi, String hushigonghao, String mima, String hushixingming, String xingbie, String dianhua, String shenfenzheng, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(hushigonghao==null||hushigonghao.equals("")){pmap.put("hushigonghao", null);}else{pmap.put("hushigonghao", hushigonghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(hushixingming==null||hushixingming.equals("")){pmap.put("hushixingming", null);}else{pmap.put("hushixingming", hushixingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=hushixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hushixinxi> list=hushixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hushixinxi_yanben4";
	}
	@RequestMapping("hushixinxi_yanben5.do")
	public String hushixinxi_yanben5(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hushixinxi hushixinxi, String hushigonghao, String mima, String hushixingming, String xingbie, String dianhua, String shenfenzheng, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(hushigonghao==null||hushigonghao.equals("")){pmap.put("hushigonghao", null);}else{pmap.put("hushigonghao", hushigonghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(hushixingming==null||hushixingming.equals("")){pmap.put("hushixingming", null);}else{pmap.put("hushixingming", hushixingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=hushixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hushixinxi> list=hushixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hushixinxi_yanben5";
	}
	
	
	
	@RequestMapping("hsxxList.do")
	public String hsxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hushixinxi hushixinxi, String hushigonghao, String mima, String hushixingming, String xingbie, String dianhua, String shenfenzheng, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(hushigonghao==null||hushigonghao.equals("")){pmap.put("hushigonghao", null);}else{pmap.put("hushigonghao", hushigonghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(hushixingming==null||hushixingming.equals("")){pmap.put("hushixingming", null);}else{pmap.put("hushixingming", hushixingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=hushixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hushixinxi> list=hushixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hushixinxilist";
	}
	@RequestMapping("hsxxListtp.do")
	public String hsxxListtp(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Hushixinxi hushixinxi, String hushigonghao, String mima, String hushixingming, String xingbie, String dianhua, String shenfenzheng, String beizhu){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(hushigonghao==null||hushigonghao.equals("")){pmap.put("hushigonghao", null);}else{pmap.put("hushigonghao", hushigonghao);}
		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}
		if(hushixingming==null||hushixingming.equals("")){pmap.put("hushixingming", null);}else{pmap.put("hushixingming", hushixingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}
		if(shenfenzheng==null||shenfenzheng.equals("")){pmap.put("shenfenzheng", null);}else{pmap.put("shenfenzheng", shenfenzheng);}
		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}
		
		int total=hushixinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Hushixinxi> list=hushixinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "hushixinxilisttp";
	}
	
	@RequestMapping("deleteHushixinxi.do")
	public String deleteHushixinxi(int id,HttpServletRequest request){
		hushixinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:hushixinxiList.do";
	}
	
	@RequestMapping("quchongHushixinxi.do")
	public void quchongHushixinxi(Hushixinxi hushixinxi,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("hushigonghao", hushixinxi.getHushigonghao());
		   System.out.println("hushigonghao==="+hushixinxi.getHushigonghao());
		   System.out.println("hushigonghao222==="+hushixinxiService.quchongHushixinxi(map));
		   JSONObject obj=new JSONObject();
		   if(hushixinxiService.quchongHushixinxi(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "护士工号可以用！");
				  
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
