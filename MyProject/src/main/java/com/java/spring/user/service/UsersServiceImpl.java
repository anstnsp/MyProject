package com.java.spring.user.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;


import com.java.spring.user.dao.UsersDao;
import com.java.spring.user.dto.UsersDto;
@Component
public class UsersServiceImpl implements UsersService{
	@Autowired // 의존 객체를 주입 받기 위한 어노테이션 
	private UsersDao usersDao;
	
	@Override
	public void insert(UsersDto dto) {
		usersDao.insert(dto);
		
	}

	@Override
	public boolean isValid(UsersDto dto) {
		boolean isValid=usersDao.isValid(dto);
		return isValid;
	}

	@Override
	public ModelAndView getData(String id) {
		UsersDto dto = usersDao.getData(id);
		ModelAndView mView = new ModelAndView();
		mView.addObject("dto",dto);
		mView.setViewName("users/private/info");
		return mView;
	}

	@Override
	public void update(UsersDto dto) {
		 usersDao.update(dto);
		
	}

	@Override
	public void delete(String id) {
		usersDao.delete(id);
		
		
	}

	@Override
	public ModelAndView getList() {
		//FileDao 객체를 이용해서 파일 목록을 얻어온다. 
				List<UsersDto> list=usersDao.getList();
				//ModelAndView 객체에 담아서 리턴해준다.
				ModelAndView mView=new ModelAndView();
				mView.addObject("list", list);
				
				return mView;
	}

	public ModelAndView canUseId(String id) {
		
		boolean canUse=	usersDao.canUseId(id);
		ModelAndView mView=new ModelAndView();
		mView.addObject("canUse", canUse);
		
		return mView;
	
	
	}

}
