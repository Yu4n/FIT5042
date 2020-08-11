package fit5042.tutex;

import fit5042.tutex.repository.PropertyRepository;
import fit5042.tutex.repository.PropertyRepositoryFactory;
import fit5042.tutex.repository.entities.Property;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * TODO Exercise 1.3 Step 3 Complete this class. Please refer to tutorial instructions.
 * This is the main driver class. This class contains the main method for Exercise 1A
 * 
 * This program can run without the completion of Exercise 1B.
 * 
 * @author Junyang
 */
public class RealEstateAgency {
    private String name;
    private final PropertyRepository propertyRepository;

    public RealEstateAgency(String name) throws Exception {
        this.name = name;
        this.propertyRepository = PropertyRepositoryFactory.getInstance();
    }
    
    // this method is for initializing the property objects
    // complete this method
    public void createProperty() {
        String[] address = new String[] {"24 Boston Ave, Malvern East VIC 3145, Australia",
        								 "11 Bettina St, Clayton VIC 3168, Australia",
        								 "3 Wattle Ave, Glen Huntly VIC 3162, Australia",
        								 "3 Hamilton St, Bentleigh VIC 3204, Australia",
        								 "82 Spring St, Hampton VIC 3188, Australia"};
        int[] numbersOfBedrooms = new int[] {2,3,5,2,1};
        int[] sizes = new int[] {150,352,800,170,60};
        double[] prices = new double[] {42000000,36000000,65000000,43500000,82000000};
        for(int i = 0; i < address.length; i++) {
        	Property property = new Property(i + 1, address[i], numbersOfBedrooms[i], sizes[i], prices[i]);
        	try {
				propertyRepository.addProperty(property);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        System.out.printf("%d properties added successfully \n", address.length);
    }
    
    // this method is for displaying all the properties
    // complete this method
    public void displayProperties() throws Exception {

		for(Property property: propertyRepository.getAllProperties()) {
			System.out.println(property.toString());
		}

    }
    
    // this method is for searching the property by ID
    // complete this method
    public void searchPropertyById() throws Exception {
    	System.out.print("Enter the ID of the property you want to search: ");
    	Scanner scanner = new Scanner(System.in);
    	int id = scanner.nextInt();
    	Property property = propertyRepository.searchPropertyById(id);
		System.out.println(property.toString());
		scanner.close();
    }
    
    public void run() throws Exception {
        createProperty();
        System.out.println("********************************************************************************");
        displayProperties();
        System.out.println("********************************************************************************");
        searchPropertyById();
    }
    
    public static void main(String[] args) {
        try {
            new RealEstateAgency("FIT5042 Real Estate Agency").run();
        } catch (Exception ex) {
            System.out.println("Application fail to run: " + ex.getMessage());
        }
    }
}
