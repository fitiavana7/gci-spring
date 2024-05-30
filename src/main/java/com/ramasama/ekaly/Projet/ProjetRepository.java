package com.ramasama.ekaly.Projet;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetRepository extends JpaRepository<Projet, Integer>{
	List<Projet> findByUserId(Integer userId);
}