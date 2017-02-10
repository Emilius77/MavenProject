/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clienti.swing.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author tss
 */
@NamedQueries({
    @NamedQuery(name = "Cliente.all", query = "select c from Cliente c order by c.ragioneSociale DESC"),
    @NamedQuery(name = "Cliente.findByName", query = "select c from Cliente c where c.ragioneSociale= :ragsoc")

})
@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ragioneSociale;
    private String indirizzo;
//    private List<Ordine> ordini;

    public Cliente() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.ragioneSociale);
        hash = 41 * hash + Objects.hashCode(this.indirizzo);
        return hash;
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.ragioneSociale, other.ragioneSociale)) {
            return false;
        }
        if (!Objects.equals(this.indirizzo, other.indirizzo)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", ragioneSociale=" + ragioneSociale + ", indirizzo=" + indirizzo + '}';
    }

    public Long getId() {
        return id;
    }

    public String getRagioneSociale() {
        return ragioneSociale;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public Cliente(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }
}
