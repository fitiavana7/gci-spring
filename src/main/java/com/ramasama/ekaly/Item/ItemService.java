package com.ramasama.ekaly.Item;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramasama.ekaly.Groupe.Groupe;
import com.ramasama.ekaly.Groupe.GroupeRepository;
import com.ramasama.ekaly.Projet.Projet;
import com.ramasama.ekaly.Projet.ProjetRepository;
import com.ramasama.ekaly.types.StatByProjet;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ItemService {
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private GroupeRepository groupeRepository;
	@Autowired
	private ProjetRepository projetRepository;
	
	
	public Item saveItem(Item item) {
		return itemRepository.save(item);
	}
	
	public Item updateItem(Item item) {
		return itemRepository.save(item);
	}
	
	public Item getById(Integer id) {
		return itemRepository.findById(id).get();
	}

	public List<Item> getByGroupe(Integer id) {
		return itemRepository.findByGroupeId(id);
	}
	
	public List<StatByProjet> stats(Integer projet_id) {
		List<Groupe> groupes = groupeRepository.findByProjetId(projet_id);
		List<StatByProjet> lists = new ArrayList();
		for(Groupe g : groupes) {
			int total = getTotalByGroupe(g.getId());
			String nom = g.getNom();
			StatByProjet stat = new StatByProjet();
			stat.nom = nom;
			stat.value = total;
			lists.add(stat);
		}
		return lists;
	}
	
	public List<StatByProjet> userStats(Integer user_id) {
		List<Projet> projets = projetRepository.findByUserId(user_id);
		List<StatByProjet> lists = new ArrayList();
		for(Projet p : projets) {
			int total = getProjetTotal(p.getId());
			String nom = p.getNom();
			StatByProjet stat = new StatByProjet();
			stat.nom = nom;
			stat.value = total;
			lists.add(stat);
		}
		return lists;
	}
	
	public Item update(Item item) {
		return itemRepository.save(item);
	}
	
	public Integer getProjetTotal(Integer projet_id) {
		List<Groupe> groupes = groupeRepository.findByProjetId(projet_id);
		Integer t = 0;
		for(Groupe g : groupes) {
			t = t + getTotalByGroupe(g.getId());
		}
		return t;
	}
	
	public List<Item> getAll(){
		return (List<Item>) itemRepository.findAll();
	}
	
	public Integer getTotalByGroupe(Integer id){
		return itemRepository.sumPrixByGroupeId(id);
	}
	
	public void deleteById(Integer id) {
		itemRepository.deleteById(id);
	}

}
