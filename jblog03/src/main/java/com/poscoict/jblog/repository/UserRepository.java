package com.poscoict.jblog.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poscoict.jblog.vo.UserVo;
@Repository
public class UserRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	public boolean join(UserVo uservo) {
		return 1 == sqlSession.insert("user.join", uservo);
	}

	public UserVo login(String id, String password) {
		Map<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("p", password);
		return sqlSession.selectOne("user.login", map);
	}

	public boolean insertBlog(UserVo userVo, String logo, String title) {
		Map<String, String> map = new HashMap<>();
		map.put("id", userVo.getId());
		map.put("l", logo);
		map.put("t", title);
		return 1==sqlSession.insert("user.insertblog", map);
	}

}
