/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.persistence.annotations.CascadeOnDelete;

/**
 *
 * @author Emilio Fucà
 * 
 */

@Entity
@Table(name = "OFFERTE")
@XmlRootElement
public class Offerta implements Serializable {

    @Id
    @Column(name = "ID_OFFERTA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOfferta;

    @ManyToOne(optional = true)
    @JoinColumn(name = "PRODOTTO", referencedColumnName = "ID_PRODOTTO")
    private Prodotto prodotto; // foreign key tabella Prodotti

    @ManyToOne(optional = true)
    @JoinColumn(name = "UTENTE", referencedColumnName = "ID_UTENTE")
    private Utente utente; // foreign key tabella Utenti
	
    @Column(name = "IMPORTO")
    private int importo;

    public Offerta() {
    }

    public Offerta(Prodotto prodotto, Utente utente, int importo) {
        this.prodotto = prodotto;
        this.utente = utente;
        this.importo = importo;
    }

    public Long getIdOfferta() {
        return idOfferta;
    }

    public void setIdOfferta(Long idOfferta) {
        this.idOfferta = idOfferta;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public int getImporto() {
        return importo;
    }

    public void setImporto(int importo) {
        this.importo = importo;
    }

    @Override
    public String toString() {
        return "Offerta{" + "idOfferta=" + idOfferta + ", prodotto=" + prodotto + ", utente=" + utente + ", importo=" + importo + '}';
    }
    
     
    
}
