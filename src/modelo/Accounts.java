/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author reyes
 */
@Entity
@Table(name = "accounts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accounts.findAll", query = "SELECT a FROM Accounts a")
    , @NamedQuery(name = "Accounts.findByAccCod", query = "SELECT a FROM Accounts a WHERE a.accCod = :accCod")
    , @NamedQuery(name = "Accounts.findByAccUser", query = "SELECT a FROM Accounts a WHERE a.accUser = :accUser")
    , @NamedQuery(name = "Accounts.findByAccPass", query = "SELECT a FROM Accounts a WHERE a.accPass = :accPass")})
public class Accounts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "accCod")
    private Integer accCod;
    @Column(name = "accUser")
    private String accUser;
    @Column(name = "accPass")
    private String accPass;
    @JoinColumn(name = "empDni", referencedColumnName = "empDni")
    @ManyToOne
    private Empleados empDni;

    public Accounts() {
    }

    public Accounts(Integer accCod) {
        this.accCod = accCod;
    }

    public Integer getAccCod() {
        return accCod;
    }

    public void setAccCod(Integer accCod) {
        this.accCod = accCod;
    }

    public String getAccUser() {
        return accUser;
    }

    public void setAccUser(String accUser) {
        this.accUser = accUser;
    }

    public String getAccPass() {
        return accPass;
    }

    public void setAccPass(String accPass) {
        this.accPass = accPass;
    }

    public Empleados getEmpDni() {
        return empDni;
    }

    public void setEmpDni(Empleados empDni) {
        this.empDni = empDni;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accCod != null ? accCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accounts)) {
            return false;
        }
        Accounts other = (Accounts) object;
        if ((this.accCod == null && other.accCod != null) || (this.accCod != null && !this.accCod.equals(other.accCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Accounts[ accCod=" + accCod + " ]";
    }
    
}
