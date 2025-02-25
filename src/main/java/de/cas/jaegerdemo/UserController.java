package de.cas.jaegerdemo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import de.cas.jaegerdemo.exceptions.UserNotFoundException;
import de.cas.jaegerdemo.models.User;
import de.cas.jaegerdemo.repository.UserRepository;

@RestController
@RequestMapping("/")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUsersById(@PathVariable(value = "id") Long userId) throws UserNotFoundException {
		User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found on :: " + userId));
		return ResponseEntity.ok().body(user);
	}

	@PostMapping("/users")
	public User createUser(@Validated @RequestBody User user) {
		return userRepository.save(user);
	}

	@DeleteMapping("/users/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws UserNotFoundException {
		User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found on :: " + userId));
		userRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
