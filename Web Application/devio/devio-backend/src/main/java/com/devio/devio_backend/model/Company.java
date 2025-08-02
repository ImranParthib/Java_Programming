package com.devio.devio_backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Company name is required")
    @Size(min = 2, max = 100, message = "Company name must be between 2 and 100 characters")
    @Column(name = "company_name")
    private String companyName;

    @NotBlank(message = "Description is required")
    @Size(max = 1000, message = "Description cannot exceed 1000 characters")
    private String description;

    @Size(max = 100, message = "Location cannot exceed 100 characters")
    private String location;

    @Size(max = 200, message = "Website URL cannot exceed 200 characters")
    private String website;

    @Column(name = "founded_year")
    private Integer foundedYear;

    @Size(max = 50, message = "Company size cannot exceed 50 characters")
    @Column(name = "company_size")
    private String companySize;

    @Column(name = "logo_url")
    private String logoUrl;

    @ElementCollection
    @CollectionTable(name = "company_technologies", joinColumns = @JoinColumn(name = "company_id"))
    @Column(name = "technology")
    private List<String> technologiesUsed;

    @ElementCollection
    @CollectionTable(name = "company_services", joinColumns = @JoinColumn(name = "company_id"))
    @Column(name = "service")
    private List<String> services;

    // Social Links as embedded object
    @Embedded
    private SocialLinks socialLinks;

    @DecimalMin(value = "0.0", message = "Google rating must be at least 0.0")
    @DecimalMax(value = "5.0", message = "Google rating cannot exceed 5.0")
    @Column(name = "google_rating")
    private Double googleRating;

    @Column(name = "google_reviews_count")
    private Integer googleReviewsCount;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Automatically set timestamps
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // Default constructor
    public Company() {
    }

    // Constructor with required fields
    public Company(String companyName, String description) {
        this.companyName = companyName;
        this.description = description;
    }

    // Constructor with common fields
    public Company(String companyName, String description, String location,
            String website, Integer foundedYear, String companySize) {
        this.companyName = companyName;
        this.description = description;
        this.location = location;
        this.website = website;
        this.foundedYear = foundedYear;
        this.companySize = companySize;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCompanySize() {
        return companySize;
    }

    public void setCompanySize(String companySize) {
        this.companySize = companySize;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public Integer getFoundedYear() {
        return foundedYear;
    }

    public void setFoundedYear(Integer foundedYear) {
        this.foundedYear = foundedYear;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<String> getTechnologiesUsed() {
        return technologiesUsed;
    }

    public void setTechnologiesUsed(List<String> technologiesUsed) {
        this.technologiesUsed = technologiesUsed;
    }

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }

    public SocialLinks getSocialLinks() {
        return socialLinks;
    }

    public void setSocialLinks(SocialLinks socialLinks) {
        this.socialLinks = socialLinks;
    }

    public Double getGoogleRating() {
        return googleRating;
    }

    public void setGoogleRating(Double googleRating) {
        this.googleRating = googleRating;
    }

    public Integer getGoogleReviewsCount() {
        return googleReviewsCount;
    }

    public void setGoogleReviewsCount(Integer googleReviewsCount) {
        this.googleReviewsCount = googleReviewsCount;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", location='" + location + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
