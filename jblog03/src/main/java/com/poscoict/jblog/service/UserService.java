package com.poscoict.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poscoict.jblog.repository.UserRepository;
import com.poscoict.jblog.vo.UserVo;
@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public void join(UserVo userVo) {
		userRepository.join(userVo);
	}
	
	public UserVo login(String id, String password) {
		return userRepository.login(id, password);
	}

	public void insertBlog(UserVo userVo, String logo, String title) {
		userRepository.insertBlog(userVo, logo, title);
	}
	
	public void insertCategory(UserVo userVo, String name, String description) {
		userRepository.insertCategory(userVo, name, description);
	}

}
