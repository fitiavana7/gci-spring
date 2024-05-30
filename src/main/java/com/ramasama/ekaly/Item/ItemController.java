package com.ramasama.ekaly.Item;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ramasama.ekaly.Projet.Projet;
import com.ramasama.ekaly.User.UserService;
import com.ramasama.ekaly.types.StatByProjet;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@RequestMapping("/item")
public class ItemController {
	private ItemService itemService;
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@GetMapping("/all")
	public List<Item> getItems() {
		return itemService.getAll();
	}
	
	@PostMapping("/create")
	public ResponseEntity<Item> create(@RequestBody Item item) {
	 	return ResponseEntity.ok(itemService.saveItem(item));
	}
	
	@PutMapping("/update")
	public ResponseEntity<Item> update(@RequestBody Item item) {
	 	return ResponseEntity.ok(itemService.update(item));
	}
	
	@GetMapping("/groupe/{id}")
	public ResponseEntity<List<Item>> getByGroupe(@PathVariable Integer id) {
	    return ResponseEntity.ok(itemService.getByGroupe(id));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Item> getById(@PathVariable Integer id) {
	    return ResponseEntity.ok(itemService.getById(id));
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Integer id) {
		itemService.deleteById(id);
	}

	@GetMapping("/stat/projet/{id}")
	public ResponseEntity<List<StatByProjet>> getStat(@PathVariable Integer id) {
	 	return ResponseEntity.ok(itemService.stats(id));
	}
	
	@GetMapping("/stat/user/{id}")
	public ResponseEntity<List<StatByProjet>> getUserStat(@PathVariable Integer id) {
	 	return ResponseEntity.ok(itemService.userStats(id));
	}
	
	@GetMapping("/total/projet/{id}")
	public ResponseEntity<Integer> getProjetTotal(@PathVariable Integer id) {
	 	return ResponseEntity.ok(itemService.getProjetTotal(id));
	}
	
	@GetMapping("/total/{id}")
	public ResponseEntity<Integer> getTotal(@PathVariable Integer id) {
	 	return ResponseEntity.ok(itemService.getTotalByGroupe(id));
	}
	
}
