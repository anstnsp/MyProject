package com.java.spring.cafe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.java.spring.cafe.dao.CafeDao;
import com.java.spring.cafe.dto.CafeDto;
import com.java.spring.cafecomment.dto.CafeCommentDto;
@Component
public class CafeServiceImpl implements CafeService{

	@Autowired
	private CafeDao cafeDao;
	
	@Override
	public ModelAndView getList(CafeDto dto) {
		List<CafeDto> list = cafeDao.getList(dto);
		ModelAndView mView = new ModelAndView();
		mView.addObject("list",list);
		mView.setViewName("cafe/list");
		return mView;
	}

	@Override
	public void insert(CafeDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ModelAndView getData(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void increaseViewCount(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CafeDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void commentInsert(CafeCommentDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ModelAndView getListComment(int num) {
		// TODO Auto-generated method stub
		return null;
	}

}
