package com.codingdojo.peru.ft2022.relationships.services;

import com.codingdojo.peru.ft2022.relationships.models.License;
import com.codingdojo.peru.ft2022.relationships.repositories.LicenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LicenseService {
    private final LicenseRepository licenseRepository;

    public LicenseService(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }

    public List<License> allLicenses() {
        return licenseRepository.findAll();
    }

    public License createLicense(License license) {
        return licenseRepository.save(license);
    }
}
