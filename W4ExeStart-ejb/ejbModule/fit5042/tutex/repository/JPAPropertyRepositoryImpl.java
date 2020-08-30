package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.ContactPerson;
import fit5042.tutex.repository.entities.Property;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Eddie Leung
 */
@Stateless
public class JPAPropertyRepositoryImpl implements PropertyRepository {

    //insert code (annotation) here to use container managed entity manager to complete these methods  
	@PersistenceContext(unitName = "W4ExeSolution-ejbPU")
	private EntityManager entityManager;

    @Override
    public void addProperty(Property property) throws Exception {
        List<Property> properties = entityManager.createNamedQuery(Property.GET_ALL_QUERY_NAME).getResultList();
        property.setPropertyId(properties.get(0).getPropertyId() + 1);
        entityManager.persist(property);
    }

    @Override
    public Property searchPropertyById(int id) throws Exception {
        Property property = entityManager.find(Property.class, id);
        property.getTags();
        return property;
    }

    @Override
    public List<Property> getAllProperties() throws Exception {
        return entityManager.createNamedQuery(Property.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public Set<Property> searchPropertyByContactPerson(ContactPerson contactPerson) throws Exception {
        contactPerson = entityManager.find(ContactPerson.class, contactPerson.getConactPersonId());
        contactPerson.getProperties().size();
        entityManager.refresh(contactPerson);

        return contactPerson.getProperties();
    }

    @Override
    public List<ContactPerson> getAllContactPeople() throws Exception {
        return entityManager.createNamedQuery(ContactPerson.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public void removeProperty(int propertyId) throws Exception {
        //complete this method
    	entityManager.remove(entityManager.find(Property.class, propertyId));
    }

    @Override
    public void editProperty(Property property) throws Exception {       
        entityManager.merge(property);
    }

    @Override
    public List<Property> searchPropertyByBudget(double budget) throws Exception {
        //complete this method using Criteria API
    	CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    	CriteriaQuery cQuery = builder.createQuery(List.class);
    	Root<Property> p = cQuery.from(Property.class);
    	cQuery.select(p);
    	Predicate predicate = builder.lessThanOrEqualTo(p.get("price").as(double.class), budget);
    	cQuery.where(predicate);
    	TypedQuery tQuery = entityManager.createQuery(cQuery);
        return tQuery.getResultList();
    }
}
