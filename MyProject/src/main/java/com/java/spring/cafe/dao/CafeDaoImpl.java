package com.java.spring.cafe.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.spring.cafe.dto.CafeDto;
import com.java.spring.cafecomment.dto.CafeCommentDto;
@Repository
public class CafeDaoImpl implements CafeDao{

	@Autowired
	private SqlSession session;
	
	@Override
	public List<CafeDto> getList(CafeDto dto) {
		
		
		List<CafeDto> list=session.selectList("cafe.getList", dto);
		return list;
	}

	@Override
	public void insert(CafeDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CafeDto getData(int num) {
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
	public List<CafeCommentDto> getListComment(int num) {
		// TODO Auto-generated method stub
		return null;
	}

}
