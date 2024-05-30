package com.ramasama.ekaly.User;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramasama.ekaly.types.Login;


@Service
@AllArgsConstructor
public class UserService {
	@Autowired
    private UserRepository userRepository;

	public User login(Login login) {
		return userRepository.findByEmailAndPassword(login.email, login.password);
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public User updateUser(User user) {
		return userRepository.save(user);
	}
	
	public User getUser(Integer id) {
		return userRepository.findById(id).get();
	}
	
	public List<User> getAll(){
		return (java.util.List<User>) userRepository.findAll();
	}
	
	public void deleteById(Integer id) {
		userRepository.deleteById(id);
	}
	
}
