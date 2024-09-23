package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	@GetMapping("adminpage/admin_main.do")
	   public String adminpage_main()
	   {
		   return "adminpage";
	   }
	   @GetMapping("adminpage/admin_joinupdate.do")
	   public String adminpage_update()
	   {
		   return "adminpage/admin_joinupdate";
	   }
	   @GetMapping("adminpage/admin_jjim.do")
	   public String adminpage_jjim()
	   {
		   return "adminpage/admin_jjim";
	   }
}
