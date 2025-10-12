package com.example.mmng_back.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mmng_back.entity.User;
import com.example.mmng_back.model.UserRequest;
import com.example.mmng_back.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	@Transactional
	public String login(UserRequest request) {
		String response = null;
		try {
			User user = this.userRepository.findByUserName(request.getUserName());
			if (user != null) {
				if (! this.passwordEncoder.matches(request.getPassword(), user.getPassword())) {
					response = "パスワードが違います";
				}
			} else {
				response = "ユーザーが見つかりません";
			}
			
		} catch (Exception e) {
			log.info("■■■ login ERROR ■■■");
			log.info("■■■ ERROR MESSAGES:"+e);
		}
		return response;
	}
	
	@Transactional
	public void updateUser(UserRequest request) {
		try {
			User user = this.userRepository.getReferenceById(request.getUserId());
			switch(request.getUpdateType()) {
				case "userName":
					user.setUserName(request.getUserName());
					break;
				case "password":
					user.setPassword(request.getPassword());
					break;
				default:
					log.info("■■■ updateType ERROR ■■■");
			}
			this.userRepository.save(user);				
			
		} catch (Exception e) {
			log.info("■■■ updateUser ERROR ■■■");
			log.info("■■■ ERROR MESSAGES:"+e);
		}
	}
	
	public boolean existUserCheck(Integer userId, String userName) {
		User myUser = this.userRepository.getReferenceById(userId);
		User existUser = this.userRepository.findByUserName(userName);
		return existUser != null && (myUser.getUserId() != existUser.getUserId());
	}
	
}
