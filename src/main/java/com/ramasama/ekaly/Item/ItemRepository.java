package com.ramasama.ekaly.Item;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	List<Item> findByGroupeId(Integer groupeId);
	
	@Query("SELECT SUM(i.prix) FROM Item i WHERE i.groupe.id=:id")
	Integer sumPrixByGroupeId(Integer id);
}