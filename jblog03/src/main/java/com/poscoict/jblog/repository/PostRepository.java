package com.poscoict.jblog.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poscoict.jblog.vo.PostVo;

@Repository
public class PostRepository {
	@Autowired
	private SqlSession sqlSession;

	public PostVo findOne(Long categoryNo, Long postNo) {
		Map<String, Long> map = new HashMap<>();
		map.put("categoryNo", categoryNo);
		map.put("postNo", postNo);
		return sqlSession.selectOne("post.findOne", map);
	}

	public List<PostVo> findAll(Long categoryNo) {
		return sqlSession.selectList("post.findAll", categoryNo);
	}

	public Long getPostNo(Long categoryNo) {
		return sqlSession.selectOne("post.getPostNo", categoryNo);
	}
	
}
