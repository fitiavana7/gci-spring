package com.ramasama.ekaly.Projet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ProjetService {
	@Autowired
	private ProjetRepository projetRepository;
	
	public Projet saveProjet(Projet projet) {
		return projetRepository.save(projet);
	}
	
	public Projet updateProjet(Projet projet) {
		return projetRepository.save(projet);
	}
	
	public Projet getById(Integer id) {
		return projetRepository.findById(id).get();
	}
	
	public List<Projet> getAll(){
		return (List<Projet>) projetRepository.findAll();
	}
	
	public void deleteById(Integer id) {
		projetRepository.deleteById(id);
	}
	
	public void deleteAll() {
		projetRepository.deleteAll();
	}
	
	public void getProjetTotal(Integer id) {
		
	}
	
	public List<Projet> getProjetsByUser(Integer userId){
		return projetRepository.findByUserId(userId);
	}

}
