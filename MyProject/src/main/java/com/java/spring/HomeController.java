package com.java.spring;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@RequestMapping("/home")
	public ModelAndView home() {
		// request 에 담을 Model
		List<String> news=new ArrayList<String>();
		news.add("하나");
		news.add("두울");
		news.add("어쩌구.. 저쩌구...");
		
		ModelAndView mView=new ModelAndView();
		mView.addObject("news", news);
		//view 페이지 정보 설정 (forward 이동)
		mView.setViewName("home");
		
		return mView;
	}
}
