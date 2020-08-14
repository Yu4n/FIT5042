package fit5042.tutex.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
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
@Named("removeProperty")
public class RemoveProperty {
    @ManagedProperty("#{propertyManagedBean}") 
    PropertyManagedBean propertyManagedBean;
    
    private boolean showForm = true;
    private Property property;
    PropertyApplication app;
    
    public void setProperty(Property property){
        this.property = property;
    }
    
    public Property getProperty(){
        return property;
    }
    
    public boolean isShowForm() {
        return showForm;
    }

    public RemoveProperty() {
        ELContext context
                = FacesContext.getCurrentInstance().getELContext();

        app = (PropertyApplication) FacesContext.getCurrentInstance()
                        .getApplication()
                        .getELResolver()
                        .getValue(context, null, "propertyApplication");
    	
//    	ELContext context = CommonInstance.EL_CONTEXT;
//    	app = CommonInstance.PROPERTY_APPLICATION;
        
        app.updatePropertyList();
        
        //instantiate propertyManagedBean
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        propertyManagedBean = (PropertyManagedBean) FacesContext.getCurrentInstance().getApplication()
        .getELResolver().getValue(elContext, null, "propertyManagedBean");
        
//        propertyManagedBean = CommonInstance.PROPERTY_MANAGED_BEAN;
    }

    /**
     * @param property Id 
     */
    public void removeProperty(int propertyId) {
       try
       {
            //remove this property from managed bean
            propertyManagedBean.removeProperty(propertyId);

            //refresh the list in PropertyApplication bean
            app.searchAll();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Property has been deleted succesfully"));     
       }
       catch (Exception ex)
       {
           
       }
       showForm = true;

    }
 
}

