package com.ramasama.ekaly.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramasama.ekaly.types.Login;
import com.ramasama.ekaly.types.UserIdType;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
	private  UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getUsers() {
		return ResponseEntity.ok(userService.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable Integer id) {
		return ResponseEntity.ok(userService.getUser(id));
	}
	
	@GetMapping("/test")
	public ResponseEntity<String> ger() {
		return ResponseEntity.ok("connecté");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
		userService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> create(@RequestBody User user) {		
		userService.saveUser(user);
		return ResponseEntity.ok("user ajouté");
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserIdType> login(@RequestBody Login login) {
		User user = userService.login(login);
		if(user != null) {
			UserIdType res = new UserIdType();
			res.UserId = user.getId();
			return ResponseEntity.ok(res);
		}
		else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
		}
	}
	
}
