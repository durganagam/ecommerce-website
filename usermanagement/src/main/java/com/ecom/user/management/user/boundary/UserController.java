package com.ecom.user.management.user.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.user.management.user.controller.UserService;
import com.ecom.user.management.user.entity.OtpVerificationRequest;
import com.ecom.user.management.user.entity.User;
import com.ecom.user.management.user.entity.UserSignUpRequest;

@RestController
@RequestMapping("users")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("create")
	@ResponseStatus(HttpStatus.OK)
	public User createUser(@RequestBody final UserSignUpRequest request) {
		User createUser = userService.createUser(request.getName(), request.getMobileNo());
		return createUser;
	}

	@PostMapping("verify")
	@ResponseStatus(HttpStatus.OK)
	public String verifyOtp(@RequestBody final OtpVerificationRequest request) {
		userService.verifyOtp(request.getOtp(), request.getUserId());
		return request.getUserId();
	}
}
