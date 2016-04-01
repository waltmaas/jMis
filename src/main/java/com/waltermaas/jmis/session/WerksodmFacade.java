/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waltermaas.jmis.session;

import com.waltermaas.jmis.entities.Werksodm;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author wmaas
 */
@Stateless
public class WerksodmFacade extends AbstractFacade<Werksodm> {

    @PersistenceContext(unitName = "com.waltermaas_jMis_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WerksodmFacade() {
        super(Werksodm.class);
    }
    
}
