package com.java.spring.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.spring.user.dto.UsersDto;

@Repository
public class UsersDaoImpl implements UsersDao {
	// 의존객체
	@Autowired // 의존객체 주입 받는 어노테이션
	private SqlSession session;

	@Override
	public void insert(UsersDto dto) {
		// TODO Auto-generated method stub
		session.insert("users.insert", dto);
	}

	@Override
	public boolean isValid(UsersDto dto) {
		UsersDto resultDto = null;

		resultDto = session.selectOne("users.isValid", dto);
		if (resultDto == null) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public UsersDto getData(String id) {
		UsersDto dto = session.selectOne("users.getData", id);
		return dto;
	}

	@Override
	public void update(UsersDto dto) {
		session.update("users.update", dto);

	}

	@Override
	public void delete(String id) {
		session.delete("users.delete", id);

	}

	@Override
	public List<UsersDto> getList() {
		List<UsersDto> list = session.selectList("users.getList");
		return list;
	}

	@Override
	public boolean canUseId(String id) {

		UsersDto dto = session.selectOne("users.isExistId", id);

		// result 가 null 이면 사용가능한 아이디 이다.
		if (dto == null) {
			return true;
		} else {
			return false;
		}
	}

}
