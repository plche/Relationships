package com.codingdojo.peru.ft2022.relationships.repositories;

import com.codingdojo.peru.ft2022.relationships.models.License;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {
    List<License> findAll();
}
