package com.java.spring.user.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.java.spring.user.dao.UsersDao;
import com.java.spring.user.dto.UsersDto;
import com.java.spring.user.service.UsersService;


@Controller
public class UsersController {
	
	@Autowired
	private UsersService usersService; 
	
	@RequestMapping("/users/signup_form")
	public String signupform(){
		
		return "users/signup_form";
	}
	
	@RequestMapping("/users/signup")
	public String insert(@ModelAttribute UsersDto dto){
		usersService.insert(dto);
		
		return "redirect:/home.do";
	}
	
	@RequestMapping("users/signin_form")
	public String signinform(){
		return "users/signin_form";
	}
	
	@RequestMapping("users/signin")
	public String signin(HttpServletRequest request){
		//파라미터로 전달되는 내용 읽어오기 
		String uri=request.getParameter("uri");
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		UsersDto dto =new UsersDto();
		dto.setId(id);
		dto.setPwd(pwd);
		boolean isValid = usersService.isValid(dto);
			if(isValid){
				//로그인 처리를 해준다.
				request.getSession().setAttribute("id", id);
				request.setAttribute("msg", id+"님 로그인 되었습니다.");
				request.setAttribute("redirectUri", uri);
			}else{
				request.setAttribute("msg", "아이디 혹은 비밀번호가 틀려요!");
				String location=request.getContextPath()
						+"/users/signin_form.do?uri="+uri;
				request.setAttribute("redirectUri", location);
			}
			return "users/alert";
		}
	@RequestMapping("users/signout")
	public String signout(HttpSession session){
		session.invalidate();
		return "redirect:/home.do";
	}
	@RequestMapping("users/checkid")
	@ResponseBody
	public ModelAndView checkid(@RequestParam String inputId){
		 
		
		 return  usersService.canUseId(inputId);
	}
	@RequestMapping("users/private/info")
	public ModelAndView userInfo(@RequestParam String id){
		ModelAndView mView = usersService.getData(id);
		
		return mView;
	}
	
}
