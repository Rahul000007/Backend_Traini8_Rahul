package com.example.Traini.service;

import com.example.Traini.dto.AddressDTO;
import com.example.Traini.dto.TrainingCenterDTO;
import com.example.Traini.model.Address;
import com.example.Traini.model.TrainingCenter;
import com.example.Traini.repository.TrainingCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingCenterServiceImpl implements TrainingCenterService {

    @Autowired
    private TrainingCenterRepository trainingCenterRepository;

    public TrainingCenterDTO createTrainingCenter(TrainingCenterDTO trainingCenterDTO) {
            TrainingCenter trainingCenter = convertToEntity(trainingCenterDTO);
            TrainingCenter savedTrainingCenter = trainingCenterRepository.save(trainingCenter);
            return convertToDTO(savedTrainingCenter);
    }

    public List<TrainingCenterDTO> getAllTrainingCenters(String city, String state) {
        List<TrainingCenter> trainingCenters;

        if (city != null && state != null) {
            trainingCenters = trainingCenterRepository.findByAddressCityAndAddressState(city, state);
        } else if (city != null) {
            trainingCenters = trainingCenterRepository.findByAddressCity(city);
        } else if (state != null) {
            trainingCenters = trainingCenterRepository.findByAddressState(state);
        } else {
            trainingCenters = trainingCenterRepository.findAll();
        }

        return trainingCenters.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    private TrainingCenter convertToEntity(TrainingCenterDTO trainingCenterDTO) {
        TrainingCenter trainingCenter = new TrainingCenter();

        AddressDTO addressDTO = trainingCenterDTO.getAddress();

        Address address = new Address();
        address.setStreet(addressDTO.getStreet());
        address.setCity(addressDTO.getCity());
        address.setState(addressDTO.getState());
        address.setPincode(addressDTO.getPincode());

        trainingCenter.setId(trainingCenterDTO.getId());
        trainingCenter.setCenterName(trainingCenterDTO.getCenterName());
        trainingCenter.setCenterCode(trainingCenterDTO.getCenterCode());
        trainingCenter.setAddress(address);
        trainingCenter.setStudentCapacity(trainingCenterDTO.getStudentCapacity());
        trainingCenter.setCoursesOffered(trainingCenterDTO.getCoursesOffered());
        trainingCenter.setCreatedOn(Instant.now());
        trainingCenter.setContactEmail(trainingCenterDTO.getContactEmail());
        trainingCenter.setContactPhone(trainingCenterDTO.getContactPhone());
        return trainingCenter;
    }

    private TrainingCenterDTO convertToDTO(TrainingCenter trainingCenter) {
        TrainingCenterDTO trainingCenterDTO = new TrainingCenterDTO();
        Address address = trainingCenter.getAddress();
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setStreet(address.getStreet());
        addressDTO.setCity(address.getCity());
        addressDTO.setState(address.getState());
        addressDTO.setPincode(address.getPincode());
        trainingCenterDTO.setId(trainingCenter.getId());
        trainingCenterDTO.setCenterName(trainingCenter.getCenterName());
        trainingCenterDTO.setCenterCode(trainingCenter.getCenterCode());
        trainingCenterDTO.setAddress(addressDTO);
        trainingCenterDTO.setStudentCapacity(trainingCenter.getStudentCapacity());
        trainingCenterDTO.setCoursesOffered(trainingCenter.getCoursesOffered());
        trainingCenterDTO.setCreatedOn(trainingCenter.getCreatedOn());
        trainingCenterDTO.setContactEmail(trainingCenter.getContactEmail());
        trainingCenterDTO.setContactPhone(trainingCenter.getContactPhone());
        return trainingCenterDTO;
    }

}
