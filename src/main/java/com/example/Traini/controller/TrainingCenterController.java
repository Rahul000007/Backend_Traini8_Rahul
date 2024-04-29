package com.example.Traini.controller;

import com.example.Traini.dto.TrainingCenterDTO;
import com.example.Traini.presenter.TrainingCenterPresenter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/training-centers")
public class TrainingCenterController {

    @Autowired
    private TrainingCenterPresenter trainingCenterPresenter;

    /**
     * Endpoint to create a new training center.
     * This method accepts a POST request with a JSON payload containing details of the new training center.
     * If the request body is valid, the method delegates the creation of the training center to the presenter layer.
     * @param trainingCenterDTO The DTO representing the new training center.
     * @return ResponseEntity The ResponseEntity containing the created training center DTO and HTTP status code.
     */
    @PostMapping
    public ResponseEntity<TrainingCenterDTO> createTrainingCenter(@Valid @RequestBody TrainingCenterDTO trainingCenterDTO) {
        TrainingCenterDTO createdDTO = trainingCenterPresenter.createTrainingCenter(trainingCenterDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDTO);
    }

    /**
     * Endpoint to retrieve a list of training centers.
     * This method accepts a GET request and optionally filters the training centers based on city and state parameters.
     * If city and state parameters are provided, the method delegates the retrieval of filtered training centers
     * to the presenter layer. Otherwise, it retrieves all training centers.
     * @param city The city name for filtering the training centers (optional).
     * @param state The state name for filtering the training centers (optional).
     * @return ResponseEntity The ResponseEntity containing the list of training center DTOs and HTTP status code.
     */
    @GetMapping
    public ResponseEntity<List<TrainingCenterDTO>> getAllTrainingCenters(@RequestParam(required = false) String city,
                                                                         @RequestParam(required = false) String state) {
        List<TrainingCenterDTO> trainingCenterDTOList = trainingCenterPresenter.getAllTrainingCenters(city, state);
        return ResponseEntity.ok(trainingCenterDTOList);
    }
}

