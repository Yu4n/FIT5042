package fit5042.tutex.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import fit5042.tutex.mbeans.PropertyManagedBean;
import javax.faces.bean.ManagedProperty;

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
    private boolean showForm = true;

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

    public void setProperty(Property property) {
        this.property = property;
    }

    public Property getProperty() {
        return property;
    }

    public boolean isShowForm() {
        return showForm;
    }

    public SearchProperty() {
        ELContext context
                = FacesContext.getCurrentInstance().getELContext();

        app = (PropertyApplication) FacesContext.getCurrentInstance()
                .getApplication()
                .getELResolver()
                .getValue(context, null, "propertyApplication");

        app.updatePropertyList();

    }

    /**
     * Normally each page should have a backing bean but you can actually do it
     * any how you want.
     *
     * @param property Id
     */
    public void searchPropertyById(int propertyId) {
        try {
            //search this property then refresh the list in PropertyApplication bean
            app.searchPropertyById(propertyId);
        } catch (Exception ex) {

        }
        showForm = true;

    }

    public void searchPropertyByBudget(double budget) {
        try {
            //search this property from db via EJB
            app.searchPropertyByBudget(budget);
        } catch (Exception ex) {

        }
        showForm = true;
    }

    public void searchAll() {
        try {
            //return all properties from db via EJB
            app.searchAll();
        } catch (Exception ex) {

        }
        showForm = true;
    }

}
