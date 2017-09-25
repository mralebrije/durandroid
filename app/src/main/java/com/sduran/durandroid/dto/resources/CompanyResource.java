package com.sduran.durandroid.dto.resources;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by sduranware on 24/09/2017.
 */
@NoArgsConstructor
@Data
public class CompanyResource {
    String name;
    String description;
    String reference;
    String location;
    String position;
    String projects;
    String technologies;
    String logoLink;

    public CompanyResource(String name, String description, String reference, String location, String position, String projects, String technologies, String logoLink) {
        this.name = name;
        this.description = description;
        this.reference = reference;
        this.location = location;
        this.position = position;
        this.projects = projects;
        this.technologies = technologies;
        this.logoLink = logoLink;
    }
}
