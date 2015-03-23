package com.waltermaas.jmis.jsf;

import com.waltermaas.jmis.entities.Ambtsect;
import com.waltermaas.jmis.jsf.util.JsfUtil;
import com.waltermaas.jmis.jsf.util.JsfUtil.PersistAction;
import com.waltermaas.jmis.session.AmbtsectFacade;

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

@Named("ambtsectController")
@SessionScoped
public class AmbtsectController implements Serializable {

    @EJB
    private com.waltermaas.jmis.session.AmbtsectFacade ejbFacade;
    private List<Ambtsect> items = null;
    private Ambtsect selected;

    public AmbtsectController() {
    }

    public Ambtsect getSelected() {
        return selected;
    }

    public void setSelected(Ambtsect selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private AmbtsectFacade getFacade() {
        return ejbFacade;
    }

    public Ambtsect prepareCreate() {
        selected = new Ambtsect();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("AmbtsectCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("AmbtsectUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("AmbtsectDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Ambtsect> getItems() {
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

    public Ambtsect getAmbtsect(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Ambtsect> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Ambtsect> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Ambtsect.class)
    public static class AmbtsectControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AmbtsectController controller = (AmbtsectController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "ambtsectController");
            return controller.getAmbtsect(getKey(value));
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
            if (object instanceof Ambtsect) {
                Ambtsect o = (Ambtsect) object;
                return getStringKey(o.getKeyid());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Ambtsect.class.getName()});
                return null;
            }
        }

    }

}
