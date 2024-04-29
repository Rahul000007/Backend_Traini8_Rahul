package com.example.Traini.service;

import com.example.Traini.dto.TrainingCenterDTO;

import java.util.List;

public interface TrainingCenterService {

    TrainingCenterDTO createTrainingCenter(TrainingCenterDTO trainingCenterDTO);

    List<TrainingCenterDTO> getAllTrainingCenters(String city, String state);
}

