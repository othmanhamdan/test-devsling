package com.devsling.testtechnique1.entity;

import com.devsling.testtechnique1.enums.Transmission;
import com.devsling.testtechnique1.enums.TypeCarburant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marque;
    private String modele;
    private LocalDate dateEnregistrement;
    private double prix;
    private TypeCarburant typeCarburant;
    private int kilometrage;
    private Transmission transmission;
    @Lob
    private byte[] image;

}
