package com.JulcamoroTucto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estudiantedto {
    private Integer idEstud;
    private String nombre;
    private String apellido;
    private String email;
    private String carrera;
}
