/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.Property;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO Exercise 1.3 Step 2 Complete this class.
 * 
 * This class implements the PropertyRepository class. You will need to add the keyword
 * "implements" PropertyRepository. 
 * 
 * @author Junyang
 */
public class SimplePropertyRepositoryImpl implements PropertyRepository {
	
	ArrayList<Property> properties;

    public SimplePropertyRepositoryImpl() {
    	properties = new ArrayList<>();
    }

	@Override
	public void addProperty(Property property) throws Exception {
		properties.add(property);
	}

	@Override
	public Property searchPropertyById(int id) throws Exception {
		return properties.stream().filter(property -> property.getId() == id).findFirst().orElse(null);			
	}

	@Override
	public List<Property> getAllProperties() throws Exception {
		return properties;
	}
    
}
