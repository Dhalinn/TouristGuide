package TouristGuide.repository;

import TouristGuide.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class TouristRepository {

    public ArrayList<TouristAttraction> attractions = new ArrayList<>();

    public TouristRepository() {

        attractions.add(new TouristAttraction("Little Mermied", "Denmarks most iconic statue."));
        attractions.add(new TouristAttraction("Tivoli", "Denmarks second most iconic place"));
    }

    // Create
    public void addAttraction(TouristAttraction attraction) {
        attractions.add(attraction);
    }

    // Read
    public ArrayList<TouristAttraction> getAllAttractions() {
        return attractions;
    }

    // Read
    public TouristAttraction getAttractionByName(String name) {
        for (TouristAttraction attraction : attractions) {
            if (attraction.getName().equalsIgnoreCase(name)) {
                return attraction;
            }
        }
        return null;
    }

    // Update
    public void updateAttraction(String name, String newDescription) {
        for (TouristAttraction attraction : attractions) {
            if (attraction.getName().equalsIgnoreCase(name)) {
                attraction.setDescription(newDescription);
                break;
            }
        }
    }

    // Delete
    public void deleteAttraction(String name) {
        for (int i = 0; i < attractions.size(); i++) {
            if (attractions.get(i).getName().equalsIgnoreCase(name)) {
                attractions.remove(i);
                break;
            }
        }
    }
}