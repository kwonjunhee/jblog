package com.poscoict.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poscoict.jblog.repository.PostRepository;
import com.poscoict.jblog.vo.PostVo;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;

	public PostVo findOne(Long categoryNo, Long postNo) {
		return postRepository.findOne(categoryNo, postNo);
	}

	public List<PostVo> findAll(Long categoryNo) {
		return postRepository.findAll(categoryNo);
	}

	public Long getPostNo(Long categoryNo) {
		return postRepository.getPostNo(categoryNo);
	}
	
	
}
