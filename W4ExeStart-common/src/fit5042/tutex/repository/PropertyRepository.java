package fit5042.tutex.repository;

import java.util.List;
import java.util.Set;
import javax.ejb.Remote;

import fit5042.tutex.repository.entities.ContactPerson;
import fit5042.tutex.repository.entities.Property;

/**
 * @autor Eddie Leung
 */
@Remote
public interface PropertyRepository {

    /**
     * Add the property being passed as parameter into the repository
     *
     * @param property - the property to add
     */
    public void addProperty(Property property) throws Exception;

    /**
     * Search for a property by its property ID
     *
     * @param id - the propertyId of the property to search for
     * @return the property found
     */
    public Property searchPropertyById(int id) throws Exception;

    /**
     * Return all the properties in the repository
     *
     * @return all the properties in the repository
     */
    public List<Property> getAllProperties() throws Exception;

    /**
     * Return all the contact people in the repository
     *
     * @return all the contact people in the repository
     */
    public List<ContactPerson> getAllContactPeople() throws Exception;

    /**
     * Remove the property, whose property ID matches the one being passed as
     * parameter, from the repository
     *
     * @param propertyId - the ID of the property to remove
     */
    public void removeProperty(int propertyId) throws Exception;

    /**
     * Update a property in the repository
     *
     * @param property - the updated information regarding a property
     */
    public void editProperty(Property property) throws Exception;

    /**
     * Search for properties whose price is less than or equal to a budget
     *
     * @param budget - the budget that the price of the returned properties must
     * be lower than or equal to
     * @return the properties found
     */
    public List<Property> searchPropertyByBudget(double budget) throws Exception;

    /**
     * Search for properties by their contact person
     *
     * @param contactPerson - the contact person that is responsible for the
     * properties
     * @return the properties found
     */
    Set<Property> searchPropertyByContactPerson(ContactPerson contactPerson) throws Exception;
}
