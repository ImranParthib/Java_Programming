package com.devio.devio_backend.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Column;

@Embeddable
public class SocialLinks {

    @Column(name = "linkedin_url")
    private String linkedin;

    @Column(name = "twitter_url")
    private String twitter;

    // Default constructor
    public SocialLinks() {
    }

    // Constructor with parameters
    public SocialLinks(String linkedin, String twitter) {
        this.linkedin = linkedin;
        this.twitter = twitter;
    }

    // Getters and Setters
    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    @Override
    public String toString() {
        return "SocialLinks{" +
                "linkedin='" + linkedin + '\'' +
                ", twitter='" + twitter + '\'' +
                '}';
    }
}
