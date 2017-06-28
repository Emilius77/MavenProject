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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Emilio Fucà
 * 
 */

@Entity
@Table(name = "UTENTI")
@XmlRootElement
public class Utente implements Serializable {
    
    public static final String FIND_ALL = "Utente.findAll";
    public static final String FIND_BY_USER_PWD = "Utente.findByUserPwd";
    public static final String FIND_BY_ID = "Utente.findById";

    @Id
    @Column(name = "ID_UTENTE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUtente;
    
    @Column(name = "COGNOME")
    private String cognome;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "EMAIL", unique = true)
    private String email;
    
    @Column(name = "PASSWORD")
    private String password;

    public Utente() {
    }
  
    public Utente(String cognome, String nome, String email, String password) {
        this.cognome = cognome;
        this.nome = nome;
        this.email = email;
        this.password = password;
    }
    
    public Long getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Long id) {
        this.idUtente = id;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Utente{" + "id=" + idUtente + ", cognome=" + cognome + ", nome=" + nome + ", email=" + email + ", password=" + password + '}';
    }
    
    
   
    
}
