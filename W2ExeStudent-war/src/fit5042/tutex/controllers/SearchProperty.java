package fit5042.tutex.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.tutex.constants.CommonInstance;
import fit5042.tutex.entities.Property;

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
@Named("searchProperty")
public class SearchProperty {
    private Property property;
    
    PropertyApplication app;
    
    private int searchByInt;
    private double searchByDouble;

    public PropertyApplication getApp() {
        return app;
    }

    public void setApp(PropertyApplication app) {
        this.app = app;
    }
    private double searchByBudget;

    public double getSearchByDouble() {
        return searchByDouble;
    }

    public void setSearchByDouble(double searchByDouble) {
        this.searchByDouble = searchByDouble;
    }

    public int getSearchByInt() {
        return searchByInt;
    }

    public void setSearchByInt(int searchByInt) {
        this.searchByInt = searchByInt;
    }

    public double getSearchByBudget() {
        return searchByBudget;
    }

    public void setSearchByBudget(double searchByBudget) {
        this.searchByBudget = searchByBudget;
    }
    
    public void setProperty(Property property){
        this.property = property;
    }
    
    public Property getProperty(){
        return property;
    }
    
    public SearchProperty() {
        ELContext context
                = FacesContext.getCurrentInstance().getELContext();

        app = (PropertyApplication) FacesContext.getCurrentInstance()
                        .getApplication()
                        .getELResolver()
                        .getValue(context, null, "propertyApplication");
    	
//    	app = CommonInstance.PROPERTY_APPLICATION;
        
        app.updatePropertyList();
    }

    
    public void searchAll() 
    {
       try
       {
            //return all properties from db via EJB
             app.searchAll();
       }
       catch (Exception ex)
       {
           
       }
    }
    
}

