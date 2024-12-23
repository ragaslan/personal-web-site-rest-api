package com.ragaslan.rest.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "general_settings")
public class GeneralSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "whoami",length = 2000)
    public String whoami;

    @Column(name = "email")
    public String email;

    @Column(name = "github")
    public String github;

    @Column(name = "linkedin")
    public String linkedin;

    @Column(name = "youtube")
    public String youtube;
}
