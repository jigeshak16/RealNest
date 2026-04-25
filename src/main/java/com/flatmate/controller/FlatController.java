package com.flatmate.controller;

import com.flatmate.entity.Flat;
import com.flatmate.entity.User;
import com.flatmate.repository.FlatRepository;
import com.flatmate.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.*;
import java.io.IOException;
import java.util.*;
import java.util.UUID;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api/flats")
@CrossOrigin(origins = "*")
public class FlatController {

    @Autowired
    private FlatRepository flatRepository;

    @Autowired
    private UserRepository userRepository;

    // ✅ VIEW ALL FLATS (WITH OWNER + IMAGES)
    @GetMapping
    public List<Map<String, Object>> getAllFlats() {

        List<Flat> flats = flatRepository.findAll();
        List<Map<String, Object>> result = new ArrayList<>();

        for (Flat flat : flats) {

            Map<String, Object> map = new HashMap<>();

            map.put("id", flat.getId());
            map.put("title", flat.getTitle());
            map.put("description", flat.getDescription());
            map.put("address", flat.getAddress());
            map.put("city", flat.getCity());
            map.put("rentAmount", flat.getRentAmount());
            map.put("flatType", flat.getFlatType());
            map.put("ownerId", flat.getOwnerId());

            // ✅ send images
            map.put("images", flat.getImages());

            User owner = userRepository
                    .findById(flat.getOwnerId())
                    .orElse(null);

            if (owner != null) {
                map.put("ownerName", owner.getFullName());
                map.put("ownerPhone", owner.getPhone());
                map.put("ownerEmail", owner.getEmail());
            }

            result.add(map);
        }

        return result;
    }

    // ✅ NORMAL ADD (WITHOUT IMAGE)
    @PostMapping("/add")
    public String addFlat(@RequestBody Flat flat) {
        flatRepository.save(flat);
        return "Flat added successfully";
    }

    // 🔥 FINAL FIXED API (WITH IMAGES + FULL DATA)
    @PostMapping("/add-with-images")
    public String addFlatWithImages(
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam String address,
            @RequestParam String city,
            @RequestParam String rentAmount,
            @RequestParam String flatType,
            @RequestParam String furnishing,
            @RequestParam String availableBeds,
            @RequestParam Long ownerId,
            @RequestParam("files") MultipartFile[] files
    ) throws IOException {

        String uploadDir = "src/main/resources/static/images/";

        // ✅ ensure folder exists
        Files.createDirectories(Paths.get(uploadDir));

        StringBuilder imagePaths = new StringBuilder();

        for (MultipartFile file : files) {

            if (file.isEmpty()) continue;

            String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

            Path path = Paths.get(uploadDir + fileName);

            Files.write(path, file.getBytes());

            // ✅ FIX: use comma instead of ||
            imagePaths.append("/images/")
                    .append(fileName)
                    .append(",");
        }

        Flat flat = new Flat();

        // ✅ ALL DATA
        flat.setTitle(title);
        flat.setDescription(description);
        flat.setAddress(address);
        flat.setCity(city);
        flat.setRentAmount(new BigDecimal(rentAmount));
        flat.setFlatType(flatType);
        flat.setFurnishing(furnishing);
        flat.setAvailableBeds(Integer.parseInt(availableBeds));
        flat.setOwnerId(ownerId);

        // ✅ SAVE IMAGES
        flat.setImages(imagePaths.toString());

        flatRepository.save(flat);

        return "Flat added with images!";
    }
}