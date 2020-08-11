package fit5042.tutex.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * The class is responsible for creating property repository.
 *
 * This class introduces the Factory design pattern. It makes use of the
 * .properties file which is a text file with the .properties extension. 
 * You can view this file under the files tab on the upper left hand side.
 *
 * TODO Exercise 1.3 Step 0 Understand this class. This class uses the design
 * pattern of a singleton and a factory.
 *
 * @author Eddie Leung
 */
public class PropertyRepositoryFactory {

    private static final PropertyRepository REPOSITORY_INSTANCE = createInstance();

    /**
     * Create a property repository object based on the setting
     * 'repository.implementation.use' in the XML file
     * 'repository-settings.properties'
     *
     * @return the property repository object created
     */
    private static PropertyRepository createInstance() {
        try {

            Properties repositoryProperties = new Properties();
            repositoryProperties.loadFromXML(new FileInputStream(new File("repository-settings.properties")));
            return (PropertyRepository) Class.forName(repositoryProperties.getProperty("repository.implementation.use")).newInstance();
        } catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }

    /**
     * Return the class member REPOSITORY_INSTANCE
     *
     * @return the class member REPOSITORY_INSTANCE
     */
    public static PropertyRepository getInstance() throws Exception {
        if (REPOSITORY_INSTANCE != null) {
            return REPOSITORY_INSTANCE;
        }
        throw new Exception("Failed to create repository");
    }
}
