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
			log.info("LoginService > login:"+e.getMessage());
		}
		
		return response;
	}
	
}
