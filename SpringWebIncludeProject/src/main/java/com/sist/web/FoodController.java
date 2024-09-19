package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.service.*;
import com.sist.vo.*;
// Service(X) => Repository 
// main/main.do
@Controller
/*
 *   "1.컵누들 스프와 후레이크를 넣고 뜨거운 물을 넣어요. 면이 잠길 정도면 적당해요.^https://recipe1.ezmember.co.kr/cache/recipe/2024/08/08/63b1c1893de0b820694a874018f6a9f91.jpg
      2.팬에 기름을 두르고 대파를 볶아요. 프라이팬 , 조리용스푼^https://recipe1.ezmember.co.kr/cache/recipe/2024/08/08/98c771b5a1bd92d27134366a28b4957e1.jpg
      3.파 향이 올라오면 달걀을 넣고 섞어요.^https://recipe1.ezmember.co.kr/cache/recipe/2024/08/08/e296a5122d5b9e37d3b36ae52532e98d1.jpg
      4.달걀 흰자가 익기 시작하면 밥과 컵누들을 부어 강불에서 볶아요. 조리용가위 컵누들은 가위로 잘게 갈라 넣어요.^https://recipe1.ezmember.co.kr/cache/recipe/2024/08/08/e1219e68ac6b0b3a44c7f87df0ae9bc01.jpg
"
 */
public class FoodController {
   @Autowired
   private FoodService fService;
  
   @GetMapping("food/detail_before.do")
   public String food_detail_before(int fno,HttpServletResponse response,RedirectAttributes ra)
   {
	   // Cookie제작 => 저장 => 브라우저 전송 HttpServletResponse response를 매개변수로 받는다 
	   // 전송 => Model : forward 
	   // 전송 => RedirectAttributes : sendRedirect
	   Cookie cookie=new Cookie("food_"+fno, String.valueOf(fno));
	   // 쿠키는 저장위치 : 브라우저 , 문자열만 저장이 가능 
	   //                            키               값
	   //                         getName()         getValue()
	   cookie.setMaxAge(60*60*24); // 초단위 저장 => 저장 기간  
	   cookie.setPath("/"); // 저장위치 
	   // 브라우저로 전송 
	   response.addCookie(cookie);
	   ra.addAttribute("fno", fno);
	   //ra.addFlashAttribute("no", no);
	   return "redirect:../food/detail.do";
   }
   @GetMapping("food/detail.do")
   public String food_detail(int fno,Model model)
   {
	   // 데이터베이스 연결 => 데이터를 읽기 
	   FoodVO vo=fService.foodDetailData(fno);
	 
	   model.addAttribute("vo", vo);


	   
	   // Model은 JSP로 전송시에 사용 : forward
	   model.addAttribute("main_jsp", "../food/detail.jsp");
	   return "main/main";
   }
 
   @GetMapping("food/cookie_all.do")
   public String food_cookie_all(HttpServletRequest request,Model model)
   {
	// 쿠키 출력 
	    Cookie[] cookies=request.getCookies();
	    List<FoodVO> cList=new ArrayList<FoodVO>();
	    // 쿠키 담는 List
	    if(cookies!=null)
	    {
	    	// 최신부터 담는다
	    	for(int i=cookies.length-1;i>=0;i--)
	    	{
	    		if(cookies[i].getName().startsWith("food_"))
	    		{
	    			String fno=cookies[i].getValue();
	    			FoodVO vo=fService.foodCookieInfoData(Integer.parseInt(fno));
	    			cList.add(vo);
	    		}
	    	}
	    }
	    model.addAttribute("cList", cList);
	    model.addAttribute("size", cList.size());
	    model.addAttribute("main_jsp", "../recipe/cookie_all.jsp");
	    return "main/main";
   }
   @GetMapping("food/cookie_delete.do")
   public String food_cookie_delete(HttpServletRequest request,HttpServletResponse response)
   {
	   Cookie[] cookies=request.getCookies();
	   if(cookies!=null)
	   {
		   for(int i=0;i<cookies.length;i++)
		   {
			   if(cookies[i].getName().startsWith("food_"))
			   {
				   cookies[i].setPath("/");
				   cookies[i].setMaxAge(0);// 쿠키 삭제 
				   response.addCookie(cookies[i]); // 브라우저에 알림 
			   }
		   }
	   }
	   return "redirect:../main/main.do";
   }
   
   @GetMapping("food/list.do")
   public String food_list(String page,Model model,HttpServletRequest request)
   {
 	  if(page==null)
 		  page="1";
 	  if(page==null)
 	    	page="1";
 	    int curpage=Integer.parseInt(page);
 	    Map map=new HashMap();
 	    map.put("start", (curpage*20)-19);
 	    map.put("end", curpage*20);
 	    List<FoodVO> list=fService.foodListData(map);
 	    int count=fService.foodRowCount();
 	    int totalpage=(int)(Math.ceil(count/20.0));
 	    
 	    final int BLOCK=10;
 	    int startPage=((curpage-1)/BLOCK*BLOCK)+1;
 	    int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
 	    
 	    if(endPage>totalpage)
 	    	endPage=totalpage;
 	    
 	    model.addAttribute("list", list);
 	    model.addAttribute("count", count);
 	    model.addAttribute("curpage", curpage);
 	    model.addAttribute("totalpage", totalpage);
 	    model.addAttribute("startPage", startPage);
 	    model.addAttribute("endPage", endPage);
 	    
 	    // 쿠키 출력 
 	    Cookie[] cookies=request.getCookies();
 	    List<FoodVO> cList=new ArrayList<FoodVO>();
 	    // 쿠키 담는 List
 	    if(cookies!=null)
 	    {
 	    	// 최신부터 담는다
 	    	for(int i=cookies.length-1;i>=0;i--)
 	    	{
 	    		if(cookies[i].getName().startsWith("food_"))
 	    		{
 	    			String fno=cookies[i].getValue();
 	    			FoodVO vo=fService.foodCookieInfoData(Integer.parseInt(fno));
 	    			cList.add(vo);
 	    		}
 	    	}
 	    }
 	    model.addAttribute("cList", cList);
 	    model.addAttribute("size", cList.size());
 	  // include할 JSP를 지정 
 	    model.addAttribute("main_jsp", "../food/list.jsp");
 	  return "main/main";
   }
}