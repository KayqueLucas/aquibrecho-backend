package br.com.aquibrecho.api.dto;

import java.util.List;

public record BrechoSimplesResponseDTO(
        String nome,
        String enereco,
        List<String> estilos
) {
}
