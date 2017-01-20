package com.java.spring.user.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.java.spring.cafe.dto.CafeDto;
import com.java.spring.cafe.service.CafeService;
import com.java.spring.user.dao.UsersDao;
import com.java.spring.user.dto.UsersDto;
import com.java.spring.user.service.UsersService;


@Controller
public class UsersController {
	//한 페이지에 나타낼 로우의 갯수
	private static final int PAGE_ROW_COUNT=5;
	//하단 디스플레이 페이지 갯수
	private static final int PAGE_DISPLAY_COUNT=5;
	
	@Autowired
	private UsersService usersService; 
	
	@Autowired
	private CafeService cafeService;
	
	@RequestMapping("/users/{url}")
	public void signupAndsigninForm(@PathVariable String url){
		
		
	}
	
	@RequestMapping("/users/signup")
	public String insert(@ModelAttribute UsersDto dto){
		usersService.insert(dto);
		
		return "redirect:/home.do";
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
	public ModelAndView userInfo(HttpSession session){
		String id = (String)session.getAttribute("id");
		ModelAndView mView = usersService.getData(id);
		
		return mView;
	}
	@RequestMapping("users/private/delete")
	public String deleteUsers(HttpSession session){
		String id = (String)session.getAttribute("id");
		session.invalidate();
		usersService.delete(id);
		
		return "redirect:/home.do";
	}
	@RequestMapping("users/private/updateform")
	public ModelAndView updateForm(HttpServletRequest request){
		String id = (String)request.getSession().getAttribute("id");
		ModelAndView mView=usersService.getData(id);
		
		mView.setViewName("users/private/updateform");
		return mView;

		
	}
	
	@RequestMapping("users/private/update")
	public String updateUsers(@ModelAttribute UsersDto dto, HttpServletRequest request){
		
		String id = dto.getId();
		
		 usersService.update(dto);
		 
		request.setAttribute("msg", id+" 회원 정보를 수정함");
		request.setAttribute("redirectUri", request.getContextPath());
		return "users/alert";
	}
	
	@RequestMapping("cafe/list")
	public ModelAndView cafeList(HttpServletRequest request){
		//보여줄 페이지의 번호
		int pageNum=1;
		//보여줄 페이지의 번호가 파라미터로 전달되는지 읽어온다.
		String strPageNum=request.getParameter("pageNum");
		if(strPageNum != null){//페이지 번호가 파라미터로 넘어온다면
			//페이지 번호를 설정한다.
			pageNum=Integer.parseInt(strPageNum);
		}
		//보여줄 페이지 데이터의 시작 ResultSet row 번호
		int startRowNum=1+(pageNum-1)*PAGE_ROW_COUNT;
		//보여줄 페이지 데이터의 끝 ResultSet row 번호
		int endRowNum=pageNum*PAGE_ROW_COUNT;
		//전체 row 의 갯수를 DB 에서 얻어온다.
		int totalRow = cafeService.getCount();
		//전체 페이지의 갯수 구하기
		int totalPageCount=
				(int)Math.ceil(totalRow/(double)PAGE_ROW_COUNT);
		//시작 페이지 번호
		int startPageNum=
			1+((pageNum-1)/PAGE_DISPLAY_COUNT)*PAGE_DISPLAY_COUNT;
		//끝 페이지 번호
		int endPageNum=startPageNum+PAGE_DISPLAY_COUNT-1;
		//끝 페이지 번호가 잘못된 값이라면 
		if(totalPageCount < endPageNum){
			endPageNum=totalPageCount; //보정해준다. 
		}
		
		//시작 row 번호와 끝 row 번호를 dto 에 담는다. 
		CafeDto dto=new CafeDto();
		dto.setStartRowNum(startRowNum);
		dto.setEndRowNum(endRowNum);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);
		// 전재 페이지의 갯수
		request.setAttribute("totalPageCount", totalPageCount);
		ModelAndView mView = cafeService.getList(dto);
		
		return mView;
				
	}
	@RequestMapping("/cafe/private/insertform")
	public void cafeInsertForm(){}
}
