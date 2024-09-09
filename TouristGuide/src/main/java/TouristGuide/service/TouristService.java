package TouristGuide.service;

import TouristGuide.model.TouristAttraction;
import TouristGuide.repository.TouristRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TouristService {

    private TouristRepository repository;

    // Create
    public void addAttraction(TouristAttraction attraction) {
        repository.addAttraction(attraction);
    }

    // Read
    public ArrayList<TouristAttraction> getAllAttractions() {
        return repository.getAllAttractions();
    }

    // Read
    public TouristAttraction getAttractionByName(String name) {
        return repository.getAttractionByName(name);
    }

    // Update
    public void updateAttraction(String name, String newDescription) {
        repository.updateAttraction(name, newDescription);
    }

    // Delete
    public void deleteAttraction(String name) {
        repository.deleteAttraction(name);
    }
}