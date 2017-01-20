package com.java.spring.cafe.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.java.spring.cafe.dto.CafeDto;
import com.java.spring.cafecomment.dto.CafeCommentDto;

public interface CafeService {
	public ModelAndView getList(CafeDto dto);
	public void insert(CafeDto dto);
	public ModelAndView getData(int num);
	public void increaseViewCount(int num);
	public void update(CafeDto dto);
	public void delete(int num);
	public int getCount();
	public void commentInsert(CafeCommentDto dto);
	public ModelAndView getListComment(int num);
}
