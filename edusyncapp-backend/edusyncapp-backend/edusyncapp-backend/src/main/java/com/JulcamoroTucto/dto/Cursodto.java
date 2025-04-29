package com.JulcamoroTucto.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cursodto {
    private Integer idCurso;
    private String nombre;
    private String codigo;
    private String descripcion;
    private Integer creditos;
}
