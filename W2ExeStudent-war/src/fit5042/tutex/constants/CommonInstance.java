package fit5042.tutex.constants;

import javax.el.ELContext;
import javax.faces.context.FacesContext;

import fit5042.tutex.controllers.PropertyApplication;
import fit5042.tutex.entities.Address;
import fit5042.tutex.entities.ContactPerson;
import fit5042.tutex.entities.Property;
import fit5042.tutex.mbeans.PropertyManagedBean;
import fit5042.tutex.repository.PropertyRepository;

public class CommonInstance {
	private final static ContactPerson CONTACT_PERSON_FIRST = new ContactPerson(1, "Eddie Leung", "0411234567");
	private final static ContactPerson CONTACT_PERSON_SECOND = new ContactPerson(2, "Sunil Panda", "0422334335");
	private final static ContactPerson CONTACT_PERSON_THIRD = new ContactPerson(3, "Jian Liew", "0409233432");
	
	private final static Address ADDRESS_FIRST = new Address("24", "Boston Avenue", "Malvern East", "3145", "Victoria");
	private final static Address ADDRESS_SECOND = new Address("11", "Bettina Street", "Clayton", "3168", "Victoria");
	private final static Address ADDRESS_THIRD = new Address("3", "Wattle Avenue", "Glen Huntly", "3163", "Victoria");
	private final static Address ADDRESS_FOURTH = new Address("5", "Hamilton Street", "Bentleigh", "3204", "Victoria");
	
	public final static Property PROPERTY_FIRST = new Property(1, ADDRESS_FIRST, 2, 150.00, 250000.00, CONTACT_PERSON_FIRST, null);
	public final static Property PROPERTY_SECOND = new Property(2, ADDRESS_SECOND, 4, 360.00, 425000.00, CONTACT_PERSON_FIRST, null);
	public final static Property PROPERTY_THIRD = new Property(3, ADDRESS_THIRD, 3, 150.00, 600000.00, CONTACT_PERSON_SECOND, null);
	public final static Property PROPERTY_FOURTH = new Property(4, ADDRESS_FOURTH, 5, 150.00, 553000.00, CONTACT_PERSON_THIRD, null);
	
	public final static PropertyRepository PROPERTY_REPOSITORY = new PropertyRepository();
}
