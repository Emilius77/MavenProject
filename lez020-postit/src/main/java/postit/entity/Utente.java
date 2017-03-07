/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postit.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tss
 */

@NamedQueries({
    @NamedQuery(name = Utente.FIND_ALL,
            query = "select e from Utente e ORDER BY e.usr")
        ,
    @NamedQuery(name = Utente.FIND_BY_USER_PWD,
            query = "SELECT e FROM Utente e WHERE e.usr= :usr and e.pwd= :pwd")
})

//questa annotazione permette la conversione automatica da Java a Xml/Jason
@XmlRootElement
@Entity
public class Utente implements Serializable {
    
    public static final String FIND_ALL = "Utente.findAll";
    public static final String FIND_BY_USER_PWD = "Utente.findByUserPwd";
    public static final String FIND_BY_ID = "Utente.findById";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String usr;
    
    @Column(nullable = false)
    private String pwd;
    
    private String email;
    

    public Utente() {
    }
    
    public Utente(String utente, String password, String email) {
        this.id = id;
        this.usr = utente;
        this.pwd = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Utente other = (Utente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Utente{" + "id=" + id + ", usr=" + usr + ", pwd=" + pwd + ", email=" + email + '}';
    }
    
    
    
   
    
}
