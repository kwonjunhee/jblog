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

import com.poscoict.jblog.service.BlogService;
import com.poscoict.jblog.service.CategoryService;
import com.poscoict.jblog.service.FileUploadService;
import com.poscoict.jblog.vo.BlogVo;
import com.poscoict.jblog.vo.CategoryVo;
import com.poscoict.jblog.vo.PostVo;

@Controller
@RequestMapping("/admin/{id:(?!assets).*}")
public class AdminController {
	@Autowired
	private BlogService blogService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private FileUploadService fileUploadService;
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping(value={"/basic", ""}, method=RequestMethod.GET)
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
	public String write(Model model,
			@PathVariable("id") String id) {
		model.addAttribute("list", categoryService.category(id));
		model.addAttribute("blogVo", blogService.findOne(id));

		return "blog/write";
	}
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(PostVo postVo,
			@RequestParam("category") String category) {
		Long categoryNo = categoryService.getCategoryNo(category);
		postVo.setCategoryNo(categoryNo);
		blogService.write(postVo);
		return "redirect:write";
	}

	@RequestMapping(value="/category", method=RequestMethod.GET)
	public String category(Model model,
			@PathVariable("id") String id) {
		model.addAttribute("list", categoryService.category(id));
		model.addAttribute("blogVo", blogService.findOne(id));

		return "blog/category";
	}
	@RequestMapping(value="/category", method=RequestMethod.POST)
	public String category(Model model, CategoryVo categoryVo,
			@PathVariable("id") String id) {
		categoryService.categoryInsert(categoryVo);
		return "redirect:category";
	}
	
	@RequestMapping(value="/category/delete/{categoryNo}", method=RequestMethod.GET)
	public String categoryDelete(Model model, CategoryVo categoryVo,
			@PathVariable("id") String id,
			@PathVariable("categoryNo") Long categoryNo) {
		categoryVo.setNo(categoryNo);
		categoryVo.setBlogId(id);
		System.out.println(categoryNo);
		System.out.println(categoryService.categoryCount(categoryNo));
		System.out.println("~~~~~~!!!!!!!!!!"+categoryService.category(id).size());

		if(categoryService.categoryCount(categoryNo) == 0) {
			categoryService.categoryDelete(categoryVo);
		}
		
		model.addAttribute("list", categoryService.category(id));
		model.addAttribute("blogVo", blogService.findOne(id));

		return "blog/category";
	}
}
