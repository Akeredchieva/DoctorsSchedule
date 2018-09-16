package com.anakeredchieva.doctor.sheduler.repositories;

import com.anakeredchieva.doctor.sheduler.entities.Diseases;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by akere on 05/14/2018.
 */
public interface DiseaseRepository extends CrudRepository<Diseases, Integer > {
    Diseases findByDiseaseName(String diseaseName);

    @Override
    List<Diseases> findAll();
}
