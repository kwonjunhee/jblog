package com.poscoict.jblog.controller;

import javax.servlet.ServletContext;

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
import com.poscoict.jblog.vo.CategoryVo;
import com.poscoict.jblog.vo.PostVo;
import com.poscoict.jblog.vo.UserVo;


@Controller
@RequestMapping("/blog/{id}")
public class BlogController {
	@Autowired
	private BlogService blogService;
	@Autowired
	private FileUploadService fileUploadService;
	@Autowired
	private ServletContext servletContext;
	
	
	@RequestMapping("")
	public String main(Model model, 
			@AuthUser UserVo authUser,
			@PathVariable("id") String id ) {
		
		model.addAttribute("blogVo", blogService.findOne(id));
		return "blog/main";
	}
	
	@RequestMapping(value="/basic", method=RequestMethod.GET)
	public String basic(Model model,
			@PathVariable("id") String id) {
		model.addAttribute("blogVo", blogService.findOne(id));
		return "blog/basic";
	}
	
	@RequestMapping(value="/basic", method=RequestMethod.POST)
	public String basic(BlogVo blogVo,
			@RequestParam(value="logo-file") MultipartFile multipartFile) {
		String logo = fileUploadService.restore(multipartFile);
		if(logo!=null) {
			blogVo.setLogo(logo);
		}
		blogService.basicUpdate(blogVo);
		servletContext.setAttribute("blogVo", blogVo);
		System.out.println(blogVo);
		return "redirect:basic";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write() {
		return "blog/write";
	}
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(PostVo postVo) {
		blogService.write(postVo);
		return "redirect:write";
	}


	@RequestMapping(value="/category", method=RequestMethod.GET)
	public String category(Model model,
			@PathVariable("id") String id) {
		model.addAttribute("list", blogService.category(id));
		return "blog/category";
	}
	@RequestMapping(value="/category", method=RequestMethod.POST)
	public String category(Model model, CategoryVo categoryVo) {
		System.out.println("##########"+categoryVo);
		blogService.categoryInsert(categoryVo);
		String id = categoryVo.getBlogId();
		return "redirect:category";
	}
}
