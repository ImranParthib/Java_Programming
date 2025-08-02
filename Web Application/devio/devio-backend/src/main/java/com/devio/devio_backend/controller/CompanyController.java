package com.devio.devio_backend.controller;

import com.devio.devio_backend.model.Company;
import com.devio.devio_backend.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/api/companies")
@CrossOrigin(origins = "http://localhost:5173")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    // CREATE - POST /api/companies
    @PostMapping
    public ResponseEntity<Map<String, Object>> createCompany(@Valid @RequestBody Company company) {
        try {
            Company createdCompany = companyService.createCompany(company);

            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "Company created successfully");
            response.put("data", createdCompany);

            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (RuntimeException e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("success", false);
            errorResponse.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);

        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("success", false);
            errorResponse.put("error", "Internal server error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    // READ - GET /api/companies (Get all companies)
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllCompanies() {
        try {
            List<Company> companies = companyService.getAllCompanies();

            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("data", companies);
            response.put("count", companies.size());

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("success", false);
            errorResponse.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    // READ - GET /api/companies/{id} (Get company by ID)
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getCompanyById(@PathVariable Long id) {
        try {
            Optional<Company> company = companyService.getCompanyById(id);

            Map<String, Object> response = new HashMap<>();

            if (company.isPresent()) {
                response.put("success", true);
                response.put("data", company.get());
                return ResponseEntity.ok(response);
            } else {
                response.put("success", false);
                response.put("error", "Company not found with id: " + id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }

        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("success", false);
            errorResponse.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    // UPDATE - PUT /api/companies/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateCompany(@PathVariable Long id,
            @Valid @RequestBody Company companyDetails) {
        try {
            Company updatedCompany = companyService.updateCompany(id, companyDetails);

            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "Company updated successfully");
            response.put("data", updatedCompany);

            return ResponseEntity.ok(response);

        } catch (RuntimeException e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("success", false);
            errorResponse.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);

        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("success", false);
            errorResponse.put("error", "Internal server error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    // DELETE - DELETE /api/companies/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteCompany(@PathVariable Long id) {
        try {
            boolean deleted = companyService.deleteCompany(id);

            Map<String, Object> response = new HashMap<>();

            if (deleted) {
                response.put("success", true);
                response.put("message", "Company deleted successfully");
                return ResponseEntity.ok(response);
            } else {
                response.put("success", false);
                response.put("error", "Company not found with id: " + id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }

        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("success", false);
            errorResponse.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    // SEARCH - GET /api/companies/search?name=keyword
    @GetMapping("/search")
    public ResponseEntity<Map<String, Object>> searchCompanies(@RequestParam String name) {
        try {
            List<Company> companies = companyService.searchCompaniesByName(name);

            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("data", companies);
            response.put("count", companies.size());
            response.put("searchTerm", name);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("success", false);
            errorResponse.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}
