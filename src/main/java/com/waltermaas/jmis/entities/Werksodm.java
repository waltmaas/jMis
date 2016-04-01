/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waltermaas.jmis.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author wmaas
 */
@Entity
@Table(name = "werksodm")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Werksodm.findAll", query = "SELECT w FROM Werksodm w"),
    @NamedQuery(name = "Werksodm.findByKeyid", query = "SELECT w FROM Werksodm w WHERE w.keyid = :keyid"),
    @NamedQuery(name = "Werksodm.findByAmbtcode", query = "SELECT w FROM Werksodm w WHERE w.ambtcode = :ambtcode"),
    @NamedQuery(name = "Werksodm.findByNsect", query = "SELECT w FROM Werksodm w WHERE w.nsect = :nsect"),
    @NamedQuery(name = "Werksodm.findByDatum", query = "SELECT w FROM Werksodm w WHERE w.datum = :datum"),
    @NamedQuery(name = "Werksodm.findByPlaats", query = "SELECT w FROM Werksodm w WHERE w.plaats = :plaats"),
    @NamedQuery(name = "Werksodm.findByDoel", query = "SELECT w FROM Werksodm w WHERE w.doel = :doel"),
    @NamedQuery(name = "Werksodm.findByCatn", query = "SELECT w FROM Werksodm w WHERE w.catn = :catn"),
    @NamedQuery(name = "Werksodm.findByUur", query = "SELECT w FROM Werksodm w WHERE w.uur = :uur"),
    @NamedQuery(name = "Werksodm.findByTbv", query = "SELECT w FROM Werksodm w WHERE w.tbv = :tbv")})
public class Werksodm implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "keyid")
    private Integer keyid;
    @Size(max = 3)
    @Column(name = "ambtcode")
    private String ambtcode;
    @Size(max = 3)
    @Column(name = "nsect")
    private String nsect;
    @Column(name = "datum")
    @Temporal(TemporalType.DATE)
    private Date datum;
    @Size(max = 25)
    @Column(name = "plaats")
    private String plaats;
    @Size(max = 25)
    @Column(name = "doel")
    private String doel;
    @Size(max = 7)
    @Column(name = "catn")
    private String catn;
    @Column(name = "uur")
    private Integer uur;
    @Column(name = "tbv")
    private Character tbv;

    public Werksodm() {
    }

    public Werksodm(Integer keyid) {
        this.keyid = keyid;
    }

    public Integer getKeyid() {
        return keyid;
    }

    public void setKeyid(Integer keyid) {
        this.keyid = keyid;
    }

    public String getAmbtcode() {
        return ambtcode;
    }

    public void setAmbtcode(String ambtcode) {
        this.ambtcode = ambtcode;
    }

    public String getNsect() {
        return nsect;
    }

    public void setNsect(String nsect) {
        this.nsect = nsect;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getPlaats() {
        return plaats;
    }

    public void setPlaats(String plaats) {
        this.plaats = plaats;
    }

    public String getDoel() {
        return doel;
    }

    public void setDoel(String doel) {
        this.doel = doel;
    }

    public String getCatn() {
        return catn;
    }

    public void setCatn(String catn) {
        this.catn = catn;
    }

    public Integer getUur() {
        return uur;
    }

    public void setUur(Integer uur) {
        this.uur = uur;
    }

    public Character getTbv() {
        return tbv;
    }

    public void setTbv(Character tbv) {
        this.tbv = tbv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (keyid != null ? keyid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Werksodm)) {
            return false;
        }
        Werksodm other = (Werksodm) object;
        if ((this.keyid == null && other.keyid != null) || (this.keyid != null && !this.keyid.equals(other.keyid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.waltermaas.jmis.entities.Werksodm[ keyid=" + keyid + " ]";
    }
    
}
