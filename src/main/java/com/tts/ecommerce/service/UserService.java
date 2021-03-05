package com.tts.ecommerce.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tts.ecommerce.model.Product;
import com.tts.ecommerce.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public Object findByUsername(String username) {
	return userRepository.findByUsername(username);	
	}
	
	public void saveNew(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	}
	
	public void saveExisting(User user) {
		userRepository.save(user);
	}
	
	public User getLoggedInUser() {
		return findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
	}
	
	public void updateCart(Map<Product, Integer> cart) {
		User user = getLoggedInUser();
		user.setCart(cart);
		saveExisting(user);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
	User user = findByUsername(username);
	if (user == null) throw new UsernameNotFoundException("Username not found.");
	return user;
	}
}
