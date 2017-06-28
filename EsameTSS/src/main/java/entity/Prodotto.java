/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Emilio Fucà
 * 
 */

@Entity
@Table(name = "PRODOTTI")
@XmlRootElement
public class Prodotto implements Serializable {

    @Id
    @Column(name = "ID_PRODOTTO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProdotto;
    
    @Column(name = "NOME")
    private String nome;

    @Column(name = "DESCRIZIONE")
    private String descrizione;

    @Column(name = "IMMAGINE")
    private String immagine;
    
    @ManyToOne(optional = false)
	@JoinColumn(name = "UTENTE_PROPR", referencedColumnName = "ID_UTENTE")
	private Utente utente; // foreign key with tabella Utenti
    
    @Column(name = "DATA_SCADENZA")
    @Temporal(TemporalType.DATE)
    private Date dataScadenza;
    
    @Column(name = "BASE_ASTA")
    private int prezzoBase;

    public Prodotto() {
    }

    public Prodotto(String nome, String descrizione, String immagine, Utente utente, Date dataScadenza, int prezzoBase) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.immagine = immagine;
        this.utente = utente;
        this.dataScadenza = dataScadenza;
        this.prezzoBase = prezzoBase;
    }

    public Long getIdProdotto() {
        return idProdotto;
    }

    public void setIdProdotto(Long idProdotto) {
        this.idProdotto = idProdotto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Date getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(Date dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public int getPrezzoBase() {
        return prezzoBase;
    }

    public void setPrezzoBase(int prezzoBase) {
        this.prezzoBase = prezzoBase;
    }

    @Override
    public String toString() {
        return "Prodotto{" + "idProdotto=" + idProdotto + ", nome=" + nome + ", descrizione=" + descrizione + ", immagine=" + immagine + 
                ", utente=" + utente + ", dataScadenza=" + dataScadenza + ", prezzoBase=" + prezzoBase + '}';
    }

   
    
    
}
