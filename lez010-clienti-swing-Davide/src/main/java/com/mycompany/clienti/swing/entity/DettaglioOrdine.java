/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clienti.swing.entity;

import com.mycompany.clienti.swing.entity.Prodotto;
import com.mycompany.clienti.swing.entity.Ordine;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author tss
 */
@Entity
public class DettaglioOrdine implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private int quantità;
    
    @ManyToOne
    private Prodotto prodotto;
    
    @ManyToOne
    private Ordine ordine;

    public DettaglioOrdine() {
    }

    public DettaglioOrdine(int quantità, Prodotto prodotto, Ordine ordine) {
        this.quantità = quantità;
        this.prodotto = prodotto;
        this.ordine = ordine;
    }

    @Override
    public String toString() {
        return "DettaglioOrdine{" + "id=" + id + ", quantit\u00e0=" + quantità + ", prodotto=" + prodotto + ", ordine=" + ordine + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + this.quantità;
        hash = 79 * hash + Objects.hashCode(this.prodotto);
        hash = 79 * hash + Objects.hashCode(this.ordine);
        return hash;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuantità(int quantità) {
        this.quantità = quantità;
    }

    public void setProdotto(Prodotto prodotto) {
        this.prodotto = prodotto;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DettaglioOrdine other = (DettaglioOrdine) obj;
        if (this.quantità != other.quantità) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.prodotto, other.prodotto)) {
            return false;
        }
        if (!Objects.equals(this.ordine, other.ordine)) {
            return false;
        }
        return true;
    }

    public Long getId() {
        return id;
    }

    public int getQuantità() {
        return quantità;
    }

    public Prodotto getProdotto() {
        return prodotto;
    }

    public Ordine getOrdine() {
        return ordine;
    }
}
