package fit5042.tutex.controllers;

import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;

import fit5042.tutex.constants.CommonInstance;
import fit5042.tutex.entities.Property;
import fit5042.tutex.mbeans.PropertyManagedBean;
import javax.inject.Named;
import javax.el.ELContext;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

/**
 * The class is a demonstration of how the application scope works. You can
 * change this scope.
 *
 * @author Guan
 */

@Named("propertyApplication")
@ApplicationScoped

public class PropertyApplication {
	// dependency injection of managed bean here so that we can use its methods
	@ManagedProperty(value = "#{propertyManagedBean}")
	PropertyManagedBean propertyManagedBean;

	private ArrayList<Property> properties;

	private boolean showForm = true;

	public boolean isShowForm() {
		return showForm;
	}

	// Add some property data from db to app
	public PropertyApplication() throws Exception {

		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		propertyManagedBean = (PropertyManagedBean) FacesContext.getCurrentInstance().getApplication().getELResolver()
				.getValue(elContext, null, "propertyManagedBean");

		properties = new ArrayList<>();

		// get properties from db
		updatePropertyList();

	}

	public ArrayList<Property> getProperties() {
		return properties;
	}

	private void setProperties(ArrayList<Property> newProperties) {
		this.properties = newProperties;
	}

	// when loading, and after adding or deleting, the property list needs to be
	// refreshed
	// this method is for that purpose
	public void updatePropertyList() {
		if (properties != null && properties.size() > 0) {

		} else {
			this.searchAll();
		}
	}

	public void searchAll() {
		properties.clear();

		for (Property property : propertyManagedBean.getAllProperties()) {
			properties.add(property);
		}
	}
}