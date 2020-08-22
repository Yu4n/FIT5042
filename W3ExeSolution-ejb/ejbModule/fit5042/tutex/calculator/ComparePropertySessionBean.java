package fit5042.tutex.calculator;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

import fit5042.tutex.repository.entities.Property;

@Stateful
public class ComparePropertySessionBean implements CompareProperty {

	// store properties
	private List<Property> propertyList;
	
	
	// constructor
	public ComparePropertySessionBean() {
		propertyList = new ArrayList<>();
	}
	
		
	@Override
	public void addProperty(Property property) {
		propertyList.add(property);
		
	}

	@Override
	public void removeProperty(Property property) {
		// remove property which have same property id with given argument
		Property existProperty = propertyList.stream().filter(p -> p.getPropertyId() == property.getPropertyId()).findFirst().orElse(null);
		propertyList.remove(existProperty);
		
	}
	
	@Override
	public int getBestPerRoom() {
		// fine the zoom with minimum value of (price / bad room)
		Property cheapestProperty = propertyList.stream().min((p1,p2)-> (p1.getPrice() / p1.getNumberOfBedrooms()) > (p2.getPrice() / p2.getNumberOfBedrooms()) ? 1 : -1).orElse(null);
		return cheapestProperty == null ? 0 : cheapestProperty.getPropertyId();
	}

}
