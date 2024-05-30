package com.ramasama.ekaly.Groupe;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface GroupeRepository  extends JpaRepository<Groupe, Integer> {
	List<Groupe> findByProjetId(Integer projetId);
	
//	@Query("SELECT SUM(i.prix) FROM Item i WHERE i.groupe.id = :groupeId")
//	Integer totalById(Integer GroupeId);
}
