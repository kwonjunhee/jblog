package com.poscoict.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poscoict.jblog.repository.BlogRepository;
import com.poscoict.jblog.vo.BlogVo;
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

}
