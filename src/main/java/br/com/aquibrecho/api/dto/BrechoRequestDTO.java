package br.com.aquibrecho.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;


public record BrechoRequestDTO(

        @NotBlank(message = "O nome do brechó é obrigatorio!")
        String nome,
        String endereco,
        String fotoUrl,
        @NotNull(message = "A latitude é obrigatória")
        Double latitude,
        @NotNull(message = "A longitude é obrigatória")
        Double longitude,

        List<Long> estiloIds
)

{}
