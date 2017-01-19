package com.java.spring.user.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.java.spring.user.dto.UsersDto;

public interface UsersService {
	public void insert(UsersDto dto);
	public boolean isValid(UsersDto dto);
	public ModelAndView getData(String id);
	public void update(UsersDto dto);
	public void delete(String id);
	public ModelAndView getList();
	public ModelAndView canUseId(String id);
}
