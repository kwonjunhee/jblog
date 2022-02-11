package com.poscoict.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poscoict.jblog.repository.CategoryRepository;
import com.poscoict.jblog.vo.CategoryVo;
@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<CategoryVo> category(String id) {
		return categoryRepository.category(id);
	}
	public boolean categoryInsert(CategoryVo categoryVo) {
		return 1== categoryRepository.categoryInsert(categoryVo);
	}

	public Long getCategoryNo(String category) {
		return categoryRepository.getCategoryNo(category);
	}

	public boolean categoryDelete(CategoryVo categoryVo) {
		return 1==categoryRepository.categoryDelete(categoryVo);
	}
	public Long getCategoryNobyid(String id) {
		return categoryRepository.getCategoryNobyid(id);
	}
	public int categoryCount(Long categoryNo) {
		return categoryRepository.categoryCount(categoryNo);
	}
}
