package com.ramasama.ekaly.Groupe;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ramasama.ekaly.User.UserService;

import lombok.AllArgsConstructor;



@RestController
@AllArgsConstructor
@RequestMapping("/groupe")
public class GroupeController {
	private GroupeService groupeService;
	
	public GroupeController(GroupeService groupeService) {
		this.groupeService = groupeService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Groupe>> getGroupes() {
		return ResponseEntity.ok(groupeService.getAll());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Groupe> create(@RequestBody Groupe groupe) {
		return ResponseEntity.ok(groupeService.saveGroupe(groupe));
	}
	
	@GetMapping("/projet/{id}")
	public ResponseEntity<List<Groupe>> getByUser(@PathVariable Integer id) {
	    return  ResponseEntity.ok(groupeService.getGroupeByProjet(id));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Groupe> getById(@PathVariable Integer id) {
	    return  ResponseEntity.ok(groupeService.getById(id));
	}
	
	@GetMapping("/total/{id}")
	public void getTotal(@PathVariable Integer id) {
		groupeService.getGroupeTotal(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		groupeService.deleteById(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("groupe effacé");
	}
	
}
