package com.example.Traini.presenter;

import com.example.Traini.dto.TrainingCenterDTO;
import com.example.Traini.service.TrainingCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class TrainingCenterPresenter {

    @Autowired
    private TrainingCenterService trainingCenterService;

    public TrainingCenterDTO createTrainingCenter(TrainingCenterDTO trainingCenterDTO) {
        return trainingCenterService.createTrainingCenter(trainingCenterDTO);
    }

    public List<TrainingCenterDTO> getAllTrainingCenters(String city, String state) {
        return trainingCenterService.getAllTrainingCenters(city, state);
    }

}

