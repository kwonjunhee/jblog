package com.poscoict.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poscoict.jblog.repository.BlogRepository;
import com.poscoict.jblog.vo.BlogVo;
import com.poscoict.jblog.vo.CategoryVo;
import com.poscoict.jblog.vo.PostVo;

@Service
public class BlogService {
	@Autowired
	private BlogRepository blogRepository;
	
	public BlogVo findOne(String id) {
		return blogRepository.findOne(id);
	}

	public boolean write(PostVo postVo) {
		return 1==blogRepository.write(postVo);
		
	}

	public boolean basicUpdate(BlogVo blogVo) {
		return 1== blogRepository.basicUpdate(blogVo);
		
	}
	public List<CategoryVo> category(String id) {
		return blogRepository.category(id);
	}
	public boolean categoryInsert(CategoryVo categoryVo) {
		return 1== blogRepository.categoryInsert(categoryVo);
	}

}
