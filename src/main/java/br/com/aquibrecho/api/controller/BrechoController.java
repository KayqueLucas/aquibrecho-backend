package br.com.aquibrecho.api.controller;

import br.com.aquibrecho.api.dto.BrechoRequestDTO;
import br.com.aquibrecho.api.dto.BrechoResponseDTO;
import br.com.aquibrecho.api.dto.BrechoSimplesResponseDTO;
import br.com.aquibrecho.api.service.BrechoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/brechos")
public class BrechoController {

    private final BrechoService brechoService;

    public BrechoController(BrechoService brechoService) {
        this.brechoService = brechoService;
    }

    @PostMapping
    public ResponseEntity<BrechoResponseDTO> cadastrar(@RequestBody @Valid BrechoRequestDTO dto){
        BrechoResponseDTO response = brechoService.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/buscar-proximos")
    public ResponseEntity<List<BrechoResponseDTO>> buscarProximos(
            @RequestParam Double lat,
            @RequestParam Double lng,
            @RequestParam(defaultValue = "5.0") Double raioKm
    ){
        List<BrechoResponseDTO> response = brechoService.buscarProximos(lat, lng, raioKm);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping
    public ResponseEntity<List<BrechoSimplesResponseDTO>> listarTodos(){
        List<BrechoSimplesResponseDTO> response = brechoService.listarTodosSimples();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
