package com.poscoict.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.poscoict.jblog.security.AuthUser;
import com.poscoict.jblog.service.BlogService;
import com.poscoict.jblog.service.FileUploadService;
import com.poscoict.jblog.vo.BlogVo;
import com.poscoict.jblog.vo.PostVo;
import com.poscoict.jblog.vo.UserVo;


@Controller
@RequestMapping("/blog")
public class BlogController {
	@Autowired
	private BlogService blogService;
	@Autowired
	private FileUploadService fileUploadService;
	
	@RequestMapping("/{id}")
	public String main(Model model, 
			@AuthUser UserVo authUser,
			@PathVariable("id") String id ) {
		
		model.addAttribute("blogVo", blogService.findOne(id));
		return "blog/blog-main";
	}
	
	@RequestMapping(value="/basic", method=RequestMethod.GET)
	public String basic() {
		return "blog/blog-admin-basic";
	}
	
	@RequestMapping(value="/basic", method=RequestMethod.POST)
	public String basic(BlogVo blogVo,
			@RequestParam(value="logo-file") MultipartFile multipartFile) {
		String logo = fileUploadService.restore(multipartFile);
		if(logo!=null) {
			blogVo.setLogo(logo);
		}
		blogService.basicUpdate(blogVo);
		return "redirect:blog/blog-admin-basic";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write() {
		return "blog/blog-admin-write";
	}
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(PostVo postVo) {
		blogService.write(postVo);
		return "redirect:blog/blog-admin-write";
	}

	
	@RequestMapping("/category")
	public String category() {
		return "blog/blog-admin-category";
	}
}
