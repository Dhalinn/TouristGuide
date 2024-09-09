package TouristGuide.controller;

import TouristGuide.model.TouristAttraction;
import TouristGuide.service.TouristService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("attractions")
public class TouristController {

    public TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    // GET
    @GetMapping
    public ResponseEntity<ArrayList<TouristAttraction>> getAllAttractions() {
        ArrayList<TouristAttraction> attractions = new ArrayList<>(touristService.getAllAttractions());
        return ResponseEntity.ok(attractions);
    }

    // GET
    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getAttractionByName(@PathVariable String name) {
        TouristAttraction attraction = touristService.getAttractionByName(name);
        if (attraction != null) {
            return ResponseEntity.ok(attraction);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST
    @PostMapping("/add")
    public ResponseEntity<Void> addAttraction(@RequestBody TouristAttraction attraction) {
        touristService.addAttraction(attraction);
        return ResponseEntity.status(201).build(); // 201 Created
    }

    // POST
    @PostMapping("/update")
    public ResponseEntity<Void> updateAttraction(@RequestParam String name, @RequestParam String description) {
        touristService.updateAttraction(name, description);
        return ResponseEntity.ok().build();
    }

    // Delete
    @PostMapping("/delete/{name}")
    public ResponseEntity<Void> deleteAttraction(@PathVariable String name) {
        touristService.deleteAttraction(name);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}