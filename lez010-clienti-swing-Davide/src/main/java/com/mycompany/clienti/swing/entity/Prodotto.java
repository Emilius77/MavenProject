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

/**
 *
 * @author tss
 */
@Entity
public class Prodotto implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double prezzoUnitario;

    public Prodotto(String nome, Double prezzoUnitario) {
        this.nome = nome;
        this.prezzoUnitario = prezzoUnitario;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getPrezzoUnitario() {
        return prezzoUnitario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.nome);
        hash = 53 * hash + Objects.hashCode(this.prezzoUnitario);
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
        final Prodotto other = (Prodotto) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.prezzoUnitario, other.prezzoUnitario)) {
            return false;
        }
        return true;
    }

    public Prodotto() {
    }

    public Long getIdProd() {
        return id;
    }

    public void setIdProd(Long idProd) {
        this.id = idProd;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrezzoUnitario(Double prezzoUnitario) {
        this.prezzoUnitario = prezzoUnitario;
    }

    @Override
    public String toString() {
        return "Prodotto{" + "id=" + id + ", nome=" + nome + ", prezzoUnitario=" + prezzoUnitario + '}';
    }
    
}
