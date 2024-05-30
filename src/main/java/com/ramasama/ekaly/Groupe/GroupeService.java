package com.ramasama.ekaly.Groupe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramasama.ekaly.Projet.Projet;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class GroupeService {
	@Autowired
	private GroupeRepository groupeRepository;
	
	public Groupe saveGroupe(Groupe groupe) {
		return groupeRepository.save(groupe);
	}
	
	public Groupe updateGroupe(Groupe chauffeur) {
		return groupeRepository.save(chauffeur);
	}
	
	public Groupe getById(Integer id) {
		return groupeRepository.findById(id).get();
	}
	
	public List<Groupe> getAll(){
		return (List<Groupe>) groupeRepository.findAll();
	}
	
	public void deleteById(Integer id) {
		groupeRepository.deleteById(id);
	}
	

	public void getGroupeTotal(Integer id) {
		
	}
	
	public List<Groupe> getGroupeByProjet(Integer projetId){
		return groupeRepository.findByProjetId(projetId);
	}
}