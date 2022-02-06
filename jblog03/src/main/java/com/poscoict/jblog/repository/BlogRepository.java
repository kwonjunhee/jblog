package com.poscoict.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poscoict.jblog.vo.BlogVo;
import com.poscoict.jblog.vo.CategoryVo;
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

	public int basicUpdate(BlogVo blogVo) {
		return sqlSession.update("blog.basicUpdate", blogVo);
	}

	public List<CategoryVo> category(String id) {
		return sqlSession.selectList("category.select", id);
	}
	
	public int categoryInsert(CategoryVo categoryVo) {
		return sqlSession.insert("category.insert", categoryVo);
	}
	
}
