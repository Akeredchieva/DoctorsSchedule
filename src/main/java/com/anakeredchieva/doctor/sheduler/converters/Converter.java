package com.anakeredchieva.doctor.sheduler.converters;

/**
 * Created by akere on 05/12/2018.
 */
public interface Converter<Entity, Transfer> {

    Entity toEntity(Transfer transfer);

    Transfer toTransfer(Entity entity);
}
