package com.usersmartheal.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Resultados {

    private String nameMedic;
    private String nameSpecialty;
    private String diagnosis;
    private String treatment;
    private String recommendations;
    private Boolean state = true;
    private int idUser;
}
