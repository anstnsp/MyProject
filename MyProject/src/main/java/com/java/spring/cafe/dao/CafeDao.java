package com.java.spring.cafe.dao;

import java.util.List;

import com.java.spring.cafe.dto.CafeDto;
import com.java.spring.cafecomment.dto.CafeCommentDto;

public interface CafeDao {
	public List<CafeDto> getList(CafeDto dto);
	public void insert(CafeDto dto);
	public CafeDto getData(int num);
	public void increaseViewCount(int num);
	public void update(CafeDto dto);
	public void delete(int num);
	public int getCount();
	public void commentInsert(CafeCommentDto dto);
	public List<CafeCommentDto> getListComment(int num);
	
}
