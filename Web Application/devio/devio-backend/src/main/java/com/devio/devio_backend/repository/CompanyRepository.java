package com.devio.devio_backend.repository;

import com.devio.devio_backend.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    // Find companies by name (case insensitive)
    List<Company> findByCompanyNameContainingIgnoreCase(String companyName);

    // Find companies by location
    List<Company> findByLocationContainingIgnoreCase(String location);

    // Find companies by company size
    List<Company> findByCompanySize(String companySize);

    // Check if company name already exists
    boolean existsByCompanyNameIgnoreCase(String companyName);
}
