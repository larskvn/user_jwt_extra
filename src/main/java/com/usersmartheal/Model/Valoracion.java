package com.usersmartheal.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Valoracion {
    private int point;
    private int medicId;
    private Boolean state = true;


}
