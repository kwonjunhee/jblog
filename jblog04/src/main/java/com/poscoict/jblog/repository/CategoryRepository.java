package com.poscoict.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.poscoict.jblog.vo.CategoryVo;

@Repository
public class CategoryRepository {
	@Autowired
	private SqlSession sqlSession;

	public List<CategoryVo> category(String id) {
		return sqlSession.selectList("category.select", id);
	}
	
	public int categoryDelete(CategoryVo categoryVo) {
		System.out.println(categoryVo);
		int count =sqlSession.delete("category.categoryDelete", categoryVo);
		return count;
	}
	public Long getCategoryNo(String category) {
		Long categoryNo = sqlSession.selectOne("category.getCategoryNo", category);
		return categoryNo;
	}

	public int categoryInsert(CategoryVo categoryVo) {
		return sqlSession.insert("category.insert", categoryVo);
	}

	public Long getCategoryNobyid(String id) {
		Long categoryNo = sqlSession.selectOne("category.getCategoryNobyid", id);
		return categoryNo;
	}

	public int categoryCount(Long categoryNo) {
		return sqlSession.selectOne("category.count", categoryNo);
	}

}
