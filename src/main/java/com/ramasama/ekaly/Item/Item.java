package com.ramasama.ekaly.Item;

import com.ramasama.ekaly.Groupe.Groupe;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "libelle" , nullable = false, length = 50)
    private String libelle;

    @Column(name = "payment" , nullable = false, length = 50)
    private String payment;
    
    @Column(name = "mesure" , nullable = false, length = 20)
    private String mesure;

    @Column(name = "date" , nullable = false, length = 20)
    private String date;
  
    @Column(name = "prix_un" , nullable = false, length = 50)
    private int prix_un;
  

    @Column(name = "quantite" , nullable = false, length = 15)
    private int quantite;
  

    @Column(name = "prix" , nullable = false, length = 20)
    private int prix;
    
    @ManyToOne
    private Groupe groupe;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String gePayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getMesure() {
		return mesure;
	}

	public void setMesure(String mesure) {
		this.mesure = mesure;
	}

	public int getPrix_un() {
		return prix_un;
	}

	public void setPrix_un(int prix_un) {
		this.prix_un = prix_un;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}


}
