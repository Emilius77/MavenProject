/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clienti.swing.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author tss
 */
@Entity
public class Ordine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;
    private String descrizione;
    private boolean evaso;

    @Temporal(TemporalType.DATE)
    private Date dataOrd;

    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "ordine", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<DettaglioOrdine> dettagli;

    public Ordine() {
    }

    public Ordine(String numero, String descrizione, boolean evaso, Date data, Cliente cliente) {
        this.numero = numero;
        this.descrizione = descrizione;
        this.evaso = evaso;
        this.dataOrd = data;
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.numero);
        hash = 47 * hash + Objects.hashCode(this.descrizione);
        hash = 47 * hash + (this.evaso ? 1 : 0);
        hash = 47 * hash + Objects.hashCode(this.dataOrd);
        hash = 47 * hash + Objects.hashCode(this.cliente);
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
        final Ordine other = (Ordine) obj;
        if (this.evaso != other.evaso) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        if (!Objects.equals(this.descrizione, other.descrizione)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dataOrd, other.dataOrd)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        return true;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setEvaso(boolean evaso) {
        this.evaso = evaso;
    }

    public void setDataOrd(Date dataOrd) {
        this.dataOrd = dataOrd;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Ordine{" + "id=" + id + ", numero=" + numero + ", descrizione=" + descrizione + ", evaso=" + evaso + ", data=" + dataOrd + ", cliente=" + cliente + '}';
    }

    public Long getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public boolean isEvaso() {
        return evaso;
    }

    public Date getDataOrd() {
        return dataOrd;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setDettagli(List<DettaglioOrdine> dettagli) {
        this.dettagli = dettagli;
    }

    public List<DettaglioOrdine> getDettagli() {
        return dettagli;
    }

}
