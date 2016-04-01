package com.waltermaas.jmis.jsf;

import com.waltermaas.jmis.entities.Werksodm;
import com.waltermaas.jmis.jsf.util.JsfUtil;
import com.waltermaas.jmis.jsf.util.JsfUtil.PersistAction;
import com.waltermaas.jmis.session.WerksodmFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;


@Named("werksodmController")
@SessionScoped
public class WerksodmController implements Serializable {


    @EJB private com.waltermaas.jmis.session.WerksodmFacade ejbFacade;
    private List<Werksodm> items = null;
    private Werksodm selected;

    public WerksodmController() {
    }

    public Werksodm getSelected() {
        return selected;
    }

    public void setSelected(Werksodm selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private WerksodmFacade getFacade() {
        return ejbFacade;
    }

    public Werksodm prepareCreate() {
        selected = new Werksodm();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("WerksodmCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("WerksodmUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("WerksodmDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Werksodm> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Werksodm getWerksodm(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Werksodm> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Werksodm> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass=Werksodm.class)
    public static class WerksodmControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            WerksodmController controller = (WerksodmController)facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "werksodmController");
            return controller.getWerksodm(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Werksodm) {
                Werksodm o = (Werksodm) object;
                return getStringKey(o.getKeyid());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Werksodm.class.getName()});
                return null;
            }
        }

    }

}
