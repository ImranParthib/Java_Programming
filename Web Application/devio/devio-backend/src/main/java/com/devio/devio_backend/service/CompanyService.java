package com.devio.devio_backend.service;

import com.devio.devio_backend.model.Company;
import com.devio.devio_backend.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    // CREATE - Add new company
    public Company createCompany(Company company) {
        // Check if company name already exists
        if (companyRepository.existsByCompanyNameIgnoreCase(company.getCompanyName())) {
            throw new RuntimeException("Company with name '" + company.getCompanyName() + "' already exists");
        }

        return companyRepository.save(company);
    }

    // READ - Get all companies
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    // READ - Get company by ID
    public Optional<Company> getCompanyById(Long id) {
        return companyRepository.findById(id);
    }

    // UPDATE - Update existing company
    public Company updateCompany(Long id, Company companyDetails) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found with id: " + id));

        // Check if new company name conflicts with existing (excluding current company)
        if (companyDetails.getCompanyName() != null &&
                !companyDetails.getCompanyName().equalsIgnoreCase(company.getCompanyName()) &&
                companyRepository.existsByCompanyNameIgnoreCase(companyDetails.getCompanyName())) {
            throw new RuntimeException("Company with name '" + companyDetails.getCompanyName() + "' already exists");
        }

        // Update fields if provided
        if (companyDetails.getCompanyName() != null) {
            company.setCompanyName(companyDetails.getCompanyName());
        }
        if (companyDetails.getDescription() != null) {
            company.setDescription(companyDetails.getDescription());
        }
        if (companyDetails.getLocation() != null) {
            company.setLocation(companyDetails.getLocation());
        }
        if (companyDetails.getWebsite() != null) {
            company.setWebsite(companyDetails.getWebsite());
        }
        if (companyDetails.getCompanySize() != null) {
            company.setCompanySize(companyDetails.getCompanySize());
        }
        if (companyDetails.getLogoUrl() != null) {
            company.setLogoUrl(companyDetails.getLogoUrl());
        }
        if (companyDetails.getFoundedYear() != null) {
            company.setFoundedYear(companyDetails.getFoundedYear());
        }
        if (companyDetails.getTechnologiesUsed() != null) {
            company.setTechnologiesUsed(companyDetails.getTechnologiesUsed());
        }
        if (companyDetails.getServices() != null) {
            company.setServices(companyDetails.getServices());
        }
        if (companyDetails.getSocialLinks() != null) {
            company.setSocialLinks(companyDetails.getSocialLinks());
        }
        if (companyDetails.getGoogleRating() != null) {
            company.setGoogleRating(companyDetails.getGoogleRating());
        }
        if (companyDetails.getGoogleReviewsCount() != null) {
            company.setGoogleReviewsCount(companyDetails.getGoogleReviewsCount());
        }

        return companyRepository.save(company);
    }

    // DELETE - Delete company
    public boolean deleteCompany(Long id) {
        if (companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // SEARCH - Search companies by name
    public List<Company> searchCompaniesByName(String name) {
        return companyRepository.findByCompanyNameContainingIgnoreCase(name);
    }

    // FILTER - Get companies by location
    public List<Company> getCompaniesByLocation(String location) {
        return companyRepository.findByLocationContainingIgnoreCase(location);
    }

    // FILTER - Get companies by size
    public List<Company> getCompaniesBySize(String size) {
        return companyRepository.findByCompanySize(size);
    }
}
