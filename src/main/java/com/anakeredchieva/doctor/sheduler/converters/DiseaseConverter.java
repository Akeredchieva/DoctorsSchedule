package com.anakeredchieva.doctor.sheduler.converters;

import com.anakeredchieva.doctor.sheduler.entities.Diseases;
import com.anakeredchieva.doctor.sheduler.entities.PatientsDiseases;
import com.anakeredchieva.doctor.sheduler.model.DiseasesTO;

/**
 * Created by akere on 05/14/2018.
 */
public enum DiseaseConverter implements Converter <Diseases, DiseasesTO> {

    F;

    @Override
    public Diseases toEntity(DiseasesTO diseasesTO) {

        return Diseases.builder().diseaseName(diseasesTO.getName())
                .description(diseasesTO.getDescription())
                .build();
    }

    @Override
    public DiseasesTO toTransfer(Diseases diseases) {
        return new DiseasesTO().name(diseases.getDiseaseName());
    }
}
