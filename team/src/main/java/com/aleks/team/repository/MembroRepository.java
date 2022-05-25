package com.aleks.team.repository;

import com.aleks.team.model.Membro;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MembroRepository extends CrudRepository<Membro, Long> {

    public List<Membro> findAll();

    public Optional<Membro> findById(Long id);

}
