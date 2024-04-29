package com.example.Traini.repository;

import com.example.Traini.model.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long> {

    List<TrainingCenter> findByAddressCityAndAddressState(String city, String state);

    List<TrainingCenter> findByAddressCity(String city);

    List<TrainingCenter> findByAddressState(String state);
}
