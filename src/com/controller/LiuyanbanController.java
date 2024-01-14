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

import com.entity.Liuyanban;
//import com.chengxusheji.po.News;
import com.server.LiuyanbanServer;
import com.util.PageBean;
import net.sf.json.JSONObject;

@Controller
public class LiuyanbanController {
	@Resource
	private LiuyanbanServer liuyanbanService;


//	
   @RequestMapping("showLiuyanban.do")
   public String showLiuyanban(int id,ModelMap map,HttpSession session){
	 /*  Map<String,Object> bmap=new HashMap<String,Object>();
	   bmap.put("uid", id);*/
	  // map.put("blist", liuyanbanService.getAll(bmap));
	   map.put("liuyanban", liuyanbanService.getById(id));
	   return "read";
   }
   
	@RequestMapping("addLiuyanban.do")
	public String addLiuyanban(HttpServletRequest request,Liuyanban liuyanban,HttpSession session){
		Timestamp time=new Timestamp(System.currentTimeMillis());
		//Users u=(Users)session.getAttribute("user");
		/*if(u==null||u.equals("")){
			return "redirect:showIndex.do";
		}else{*/
			
		    liuyanban.setAddtime(time.toString().substring(0, 19));
			liuyanbanService.add(liuyanban);
			session.setAttribute("backxx", "添加成功");
			session.setAttribute("backurl", "lybList.do");
			return "redirect:postback.jsp";
			//return "redirect:liuyanbanList.do";
		/*}*/
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateLiuyanban.do")
	public String doUpdateLiuyanban(int id,ModelMap map,Liuyanban liuyanban){
		liuyanban=liuyanbanService.getById(id);
		map.put("liuyanban", liuyanban);
		return "liuyanban_updt";
	}
	
	
	
	@RequestMapping("doUpdateLiuyanbanlb.do")
	public String doUpdateLiuyanbanlb(int id,ModelMap map,Liuyanban liuyanban){
		liuyanban=liuyanbanService.getById(id);
		map.put("liuyanban", liuyanban);
		return "liuyanban_updtlb";
	}
	
@RequestMapping("updateLiuyanbanlb.do")
	public String updateLiuyanbanlb(int id,ModelMap map,Liuyanban liuyanban){
		liuyanbanService.updatelb(liuyanban);
		return "redirect:liuyanbanList.do";
	}
	
//	后台详细
	@RequestMapping("LiuyanbanDetail.do")
	public String LiuyanbanDetail(int id,ModelMap map,Liuyanban liuyanban){
		liuyanban=liuyanbanService.getById(id);
		map.put("liuyanban", liuyanban);
		return "liuyanban_detail";
	}
//	前台详细
	@RequestMapping("lybDetail.do")
	public String lybDetail(int id,ModelMap map,Liuyanban liuyanban){
		liuyanban=liuyanbanService.getById(id);
		map.put("liuyanban", liuyanban);
		return "liuyanbandetail";
	}
//	
	@RequestMapping("updateLiuyanban.do")
	public String updateLiuyanban(int id,ModelMap map,Liuyanban liuyanban){
		liuyanbanService.update(liuyanban);
		return "redirect:liuyanbanList.do";
	}

//	分页查询
	@RequestMapping("liuyanbanList.do")
	public String liuyanbanList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Liuyanban liuyanban, String cheng, String xingbie, String QQ, String youxiang, String shouji, String neirong, String huifuneirong){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(cheng==null||cheng.equals("")){pmap.put("cheng", null);}else{pmap.put("cheng", cheng);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(QQ==null||QQ.equals("")){pmap.put("QQ", null);}else{pmap.put("QQ", QQ);}
		if(youxiang==null||youxiang.equals("")){pmap.put("youxiang", null);}else{pmap.put("youxiang", youxiang);}
		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}
		if(neirong==null||neirong.equals("")){pmap.put("neirong", null);}else{pmap.put("neirong", neirong);}
		if(huifuneirong==null||huifuneirong.equals("")){pmap.put("huifuneirong", null);}else{pmap.put("huifuneirong", huifuneirong);}
		
		int total=liuyanbanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Liuyanban> list=liuyanbanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "liuyanban_list";
	}
	
	
	
	@RequestMapping("lybList.do")
	public String lybList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Liuyanban liuyanban, String cheng, String xingbie, String QQ, String youxiang, String shouji, String neirong, String huifuneirong){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(cheng==null||cheng.equals("")){pmap.put("cheng", null);}else{pmap.put("cheng", cheng);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(QQ==null||QQ.equals("")){pmap.put("QQ", null);}else{pmap.put("QQ", QQ);}
		if(youxiang==null||youxiang.equals("")){pmap.put("youxiang", null);}else{pmap.put("youxiang", youxiang);}
		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}
		if(neirong==null||neirong.equals("")){pmap.put("neirong", null);}else{pmap.put("neirong", neirong);}
		if(huifuneirong==null||huifuneirong.equals("")){pmap.put("huifuneirong", null);}else{pmap.put("huifuneirong", huifuneirong);}
		
		int total=liuyanbanService.getCount(pmap);
		pageBean.setTotal(total);
		List<Liuyanban> list=liuyanbanService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "lyblist";
	}
	
	@RequestMapping("deleteLiuyanban.do")
	public String deleteLiuyanban(int id,HttpServletRequest request){
		liuyanbanService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:liuyanbanList.do";
	}
	
	
}
