package com.poscoict.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poscoict.jblog.vo.BlogVo;
import com.poscoict.jblog.vo.PostVo;

@Repository
public class BlogRepository {

	@Autowired
	private SqlSession sqlSession;

	public BlogVo findOne(String id) {
		return sqlSession.selectOne("blog.findOne", id);
	}

	public int write(PostVo postVo) {
		return sqlSession.insert("blog.write", postVo);
	}
	
	
}
