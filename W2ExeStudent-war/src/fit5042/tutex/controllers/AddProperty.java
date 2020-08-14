package fit5042.tutex.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.tutex.constants.CommonInstance;
import fit5042.tutex.entities.Property;
import fit5042.tutex.mbeans.PropertyManagedBean;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Guan
 */
@RequestScoped
@Named("addProperty")
public class AddProperty {

    @ManagedProperty("#{propertyManagedBean}")
    PropertyManagedBean propertyManagedBean;

    private boolean showForm = true;

    private Property property;

    PropertyApplication app;

    public void setProperty(Property property) {
        this.property = property;
    }

    public Property getProperty() {
        return property;
    }

    public boolean isShowForm() {
        return showForm;
    }

    public AddProperty() {
        ELContext context
                = FacesContext.getCurrentInstance().getELContext();

        app = (PropertyApplication) FacesContext.getCurrentInstance()
                .getApplication()
                .getELResolver()
                .getValue(context, null, "propertyApplication");

        //instantiate propertyManagedBean
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        propertyManagedBean = (PropertyManagedBean) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "propertyManagedBean");
    }

    public void addProperty(Property localProperty) {
        try {
        	localProperty.setPropertyId(CommonInstance.PROPERTY_REPOSITORY.getPropertyId() + 1);
            propertyManagedBean.addProperty(localProperty);

            //refresh the list in PropertyApplication bean
            app.searchAll();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Property has been added succesfully"));
        } catch (Exception ex) {

        }
        showForm = true;
    }
    

}
