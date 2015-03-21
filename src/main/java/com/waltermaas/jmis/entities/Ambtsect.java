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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author wmaas
 */
@Entity
@Table(name = "ambtsect")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ambtsect.findAll", query = "SELECT a FROM Ambtsect a"),
    @NamedQuery(name = "Ambtsect.findByKeyid", query = "SELECT a FROM Ambtsect a WHERE a.keyid = :keyid"),
    @NamedQuery(name = "Ambtsect.findByAmbtcode", query = "SELECT a FROM Ambtsect a WHERE a.ambtcode = :ambtcode"),
    @NamedQuery(name = "Ambtsect.findByNewsect", query = "SELECT a FROM Ambtsect a WHERE a.newsect = :newsect"),
    @NamedQuery(name = "Ambtsect.findByKei2log", query = "SELECT a FROM Ambtsect a WHERE a.kei2log = :kei2log"),
    @NamedQuery(name = "Ambtsect.findByDienst", query = "SELECT a FROM Ambtsect a WHERE a.dienst = :dienst"),
    @NamedQuery(name = "Ambtsect.findByTelIntern", query = "SELECT a FROM Ambtsect a WHERE a.telIntern = :telIntern")})
public class Ambtsect implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "keyid")
    private Integer keyid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ambtcode")
    private String ambtcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "newsect")
    private String newsect;
    @Column(name = "geb_dat")
    @Temporal(TemporalType.DATE)
    private Date gebDat;
    @Size(max = 25)
    @Column(name = "naam")
    private String naam;
    @Size(max = 20)
    @Column(name = "lognaam")
    private String lognaam;
    @Size(max = 20)
    @Column(name = "kei2log")
    private String kei2log;
    @Size(max = 25)
    @Column(name = "emailadr")
    private String emailadr;
    @Column(name = "is_er")
    private Character isEr;
    @Size(max = 18)
    @Column(name = "cnaam")
    private String cnaam;
    @Column(name = "last_in")
    @Temporal(TemporalType.DATE)
    private Date lastIn;
    @Column(name = "dienst")
    private Character dienst;
    @Column(name = "uit_dienst")
    @Temporal(TemporalType.DATE)
    private Date uitDienst;
    @Size(max = 10)
    @Column(name = "passw")
    private String passw;
    @Size(max = 4)
    @Column(name = "kamer")
    private String kamer;
    @Size(max = 5)
    @Column(name = "tel_intern")
    private String telIntern;
    @Size(max = 3)
    @Column(name = "functie")
    private String functie;
    @Column(name = "udate")
    @Temporal(TemporalType.DATE)
    private Date udate;
    @Size(max = 3)
    @Column(name = "udoor")
    private String udoor;
    @Column(name = "med_keur")
    @Temporal(TemporalType.DATE)
    private Date medKeur;
    @Column(name = "med_keur_vv")
    @Temporal(TemporalType.DATE)
    private Date medKeurVv;
    @Size(max = 30)
    @Column(name = "adres")
    private String adres;
    @Size(max = 7)
    @Column(name = "pc")
    private String pc;
    @Size(max = 12)
    @Column(name = "gsm")
    private String gsm;
    @Size(max = 30)
    @Column(name = "stad")
    private String stad;
    @Lob
    @Size(max = 65535)
    @Column(name = "onsmis")
    private String onsmis;

    public Ambtsect() {
    }

    public Ambtsect(Integer keyid) {
        this.keyid = keyid;
    }

    public Ambtsect(Integer keyid, String ambtcode, String newsect) {
        this.keyid = keyid;
        this.ambtcode = ambtcode;
        this.newsect = newsect;
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

    public String getNewsect() {
        return newsect;
    }

    public void setNewsect(String newsect) {
        this.newsect = newsect;
    }

    public Date getGebDat() {
        return gebDat;
    }

    public void setGebDat(Date gebDat) {
        this.gebDat = gebDat;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getLognaam() {
        return lognaam;
    }

    public void setLognaam(String lognaam) {
        this.lognaam = lognaam;
    }

    public String getKei2log() {
        return kei2log;
    }

    public void setKei2log(String kei2log) {
        this.kei2log = kei2log;
    }

    public String getEmailadr() {
        return emailadr;
    }

    public void setEmailadr(String emailadr) {
        this.emailadr = emailadr;
    }

    public Character getIsEr() {
        return isEr;
    }

    public void setIsEr(Character isEr) {
        this.isEr = isEr;
    }

    public String getCnaam() {
        return cnaam;
    }

    public void setCnaam(String cnaam) {
        this.cnaam = cnaam;
    }

    public Date getLastIn() {
        return lastIn;
    }

    public void setLastIn(Date lastIn) {
        this.lastIn = lastIn;
    }

    public Character getDienst() {
        return dienst;
    }

    public void setDienst(Character dienst) {
        this.dienst = dienst;
    }

    public Date getUitDienst() {
        return uitDienst;
    }

    public void setUitDienst(Date uitDienst) {
        this.uitDienst = uitDienst;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public String getKamer() {
        return kamer;
    }

    public void setKamer(String kamer) {
        this.kamer = kamer;
    }

    public String getTelIntern() {
        return telIntern;
    }

    public void setTelIntern(String telIntern) {
        this.telIntern = telIntern;
    }

    public String getFunctie() {
        return functie;
    }

    public void setFunctie(String functie) {
        this.functie = functie;
    }

    public Date getUdate() {
        return udate;
    }

    public void setUdate(Date udate) {
        this.udate = udate;
    }

    public String getUdoor() {
        return udoor;
    }

    public void setUdoor(String udoor) {
        this.udoor = udoor;
    }

    public Date getMedKeur() {
        return medKeur;
    }

    public void setMedKeur(Date medKeur) {
        this.medKeur = medKeur;
    }

    public Date getMedKeurVv() {
        return medKeurVv;
    }

    public void setMedKeurVv(Date medKeurVv) {
        this.medKeurVv = medKeurVv;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public String getGsm() {
        return gsm;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }

    public String getStad() {
        return stad;
    }

    public void setStad(String stad) {
        this.stad = stad;
    }

    public String getOnsmis() {
        return onsmis;
    }

    public void setOnsmis(String onsmis) {
        this.onsmis = onsmis;
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
        if (!(object instanceof Ambtsect)) {
            return false;
        }
        Ambtsect other = (Ambtsect) object;
        if ((this.keyid == null && other.keyid != null) || (this.keyid != null && !this.keyid.equals(other.keyid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.waltermaas.jmis.entities.Ambtsect[ keyid=" + keyid + " ]";
    }
    
}
