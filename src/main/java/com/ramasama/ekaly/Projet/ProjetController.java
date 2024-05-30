package com.ramasama.ekaly.Projet;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ramasama.ekaly.Item.ItemService;
import com.ramasama.ekaly.User.User;
import com.ramasama.ekaly.User.UserService;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("/projet")
public class ProjetController {
	private ProjetService projetService;

	public ProjetController(ProjetService projetService) {
		this.projetService = projetService;
	}
		
		@GetMapping("/all")
		public ResponseEntity<List<Projet>> getProjets() {
			return ResponseEntity.ok(projetService.getAll());
		}
		  
		@PostMapping("/create")
		public ResponseEntity<String> create(@RequestBody Projet projet) {
			projetService.saveProjet(projet);
			return ResponseEntity.ok("projet ajouté");
		}
		
		@GetMapping("/user/{id}")
		public ResponseEntity<List<Projet>> getByUser(@PathVariable Integer id) {
		    return ResponseEntity.ok(projetService.getProjetsByUser(id));
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Projet> getById(@PathVariable Integer id) {
		    return ResponseEntity.ok(projetService.getById(id));
		}
		
		@GetMapping("/total/{id}")
		public void getTotal(@PathVariable Integer id) {
			projetService.getProjetTotal(id);
		}
		
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<String> delete(@PathVariable Integer id) {
			projetService.deleteById(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("projet effacé");
		}
		
		@DeleteMapping("/delete/all")
		public ResponseEntity<String> deleteAll() {
			projetService.deleteAll();
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("projet effacé");
		}
}
