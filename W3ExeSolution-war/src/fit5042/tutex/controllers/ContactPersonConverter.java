/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.controllers;

import fit5042.tutex.repository.entities.ContactPerson;
/**
 *
 * @author Guan
 */
import fit5042.tutex.mbeans.PropertyManagedBean;
import java.util.ArrayList;
import java.util.List;
import javax.el.ELContext;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = fit5042.tutex.repository.entities.ContactPerson.class, value = "contactPerson")

public class ContactPersonConverter implements Converter {

    @ManagedProperty(value = "#{propertyManagedBean}")
    PropertyManagedBean propertyManagedBean;

    public List<ContactPerson> contactPersonDB; //= propertyManagedBean.getAllContactPeople();

    public ContactPersonConverter() {
        try {
            //instantiate propertyManagedBean
            ELContext elContext = FacesContext.getCurrentInstance().getELContext();
            propertyManagedBean = (PropertyManagedBean) FacesContext.getCurrentInstance().getApplication()
                    .getELResolver().getValue(elContext, null, "propertyManagedBean");

            contactPersonDB = propertyManagedBean.getAllContactPeople();
        } catch (Exception ex) {

        }
    }

    //this method is for converting the submitted value (as String) to the contact person object
    //the reason for using this method is, the dropdown box in the xhtml does not capture the contact person object, but the String.
    public ContactPerson getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {
        if (submittedValue.trim().equals("")) {
            return null;
        } else {
            try {
                int number = Integer.parseInt(submittedValue);

                for (ContactPerson c : contactPersonDB) {
                    if (c.getConactPersonId() == number) {
                        return c;
                    }
                }

            } catch (NumberFormatException exception) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid contact person"));
            }
        }

        return null;
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return String.valueOf(((ContactPerson) value).getConactPersonId());
        }
    }
}
