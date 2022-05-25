package com.aleks.team.repository;

import com.aleks.team.model.Time;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TimeRespository extends CrudRepository<Time, Long> {

    public Optional<Time> findById(Long id);

}