package br.com.aquibrecho.api.dto;

import java.util.List;

public record BrechoResponseDTO(
        Long id,
        String nome,
        String endereco,
        String fotoUrl,
        Double latitude,
        Double longitude,
        List <String> estilo
) {}
