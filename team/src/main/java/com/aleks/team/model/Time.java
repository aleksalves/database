package com.aleks.team.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Time {

    @Id
    private long codigo;

    private String nome;
    private String proposito;

}
