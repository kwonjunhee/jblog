package com.poscoict.jblog.controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poscoict.jblog.security.AuthUser;
import com.poscoict.jblog.service.BlogService;
import com.poscoict.jblog.service.CategoryService;
import com.poscoict.jblog.service.PostService;
import com.poscoict.jblog.vo.UserVo;


@Controller
@RequestMapping("/blog/{id:(?!assets).*}")
public class BlogController {
	@Autowired
	private BlogService blogService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private PostService postService;

	
	@RequestMapping({"", "/{pathNo1}", "/{pathNo1}/{pathNo2}"})
	public String main(Model model, 
			@AuthUser UserVo authUser,
			@PathVariable("id") String id,
			@PathVariable("pathNo1") Optional<Long> pathNo1,
		    @PathVariable("pathNo2") Optional<Long>  pathNo2) {
		
		Long categoryNo = categoryService.getCategoryNobyid(id);
		Long postNo = postService.getPostNo(categoryNo);
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$"+categoryNo+postNo);

		if(pathNo2.isPresent()) {
			categoryNo = pathNo1.get();
			postNo = pathNo2.get();
		} else if(pathNo1.isPresent()) {
			categoryNo = pathNo1.get();
			postNo = postService.getPostNo(categoryNo);

		}
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$"+categoryNo+postNo);
		
		model.addAttribute("blogVo", blogService.findOne(id));
		model.addAttribute("categoryList", categoryService.category(id));
		model.addAttribute("postVo", postService.findOne(categoryNo, postNo));
		model.addAttribute("postList", postService.findAll(categoryNo));
		
		return "blog/main";
	}
}
