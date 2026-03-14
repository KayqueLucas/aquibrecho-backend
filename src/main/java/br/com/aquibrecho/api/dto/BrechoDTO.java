package br.com.aquibrecho.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class BrechoDTO {

    private String nome;
    private String endereco;
    private String fotoUrl;
    private Double latitude;
    private Double longitude;
    private List<Long> estiloIds;
}
