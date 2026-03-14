package br.com.aquibrecho.api.service;

import br.com.aquibrecho.api.dto.BrechoRequestDTO;
import br.com.aquibrecho.api.dto.BrechoResponseDTO;
import br.com.aquibrecho.api.model.Brecho;
import br.com.aquibrecho.api.model.Estilo;
import br.com.aquibrecho.api.repository.BrechoRepository;
import br.com.aquibrecho.api.repository.EstiloRepository;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrechoService {

    private final BrechoRepository brechoRepository;
    private final EstiloRepository estiloRepository;
    private final GeometryFactory geometryFactory;

    public BrechoService(BrechoRepository brechoRepository, EstiloRepository estiloRepository) {
        this.brechoRepository = brechoRepository;
        this.estiloRepository = estiloRepository;
        this.geometryFactory = new GeometryFactory(new org.locationtech.jts.geom.PrecisionModel(), 4326);
    }

    @Transactional
    public BrechoResponseDTO salvar(BrechoRequestDTO dto){

        Point localizacao = geometryFactory.createPoint(new Coordinate(dto.longitude(), dto.latitude()));

        List<Estilo> estilos = estiloRepository.findAllById(dto.estiloIds());

        Brecho brecho = new Brecho();
        brecho.setNome(dto.nome());
        brecho.setEndereco(dto.endereco());
        brecho.setFotoUrl(dto.fotoUrl());
        brecho.setLocalizacao(localizacao);
        brecho.setEstilos(estilos);

        Brecho brechoSalvo = brechoRepository.save(brecho);

        return mapearParaDTO(brechoSalvo);

    }
    @Transactional(readOnly = true)
    public List<BrechoResponseDTO> buscarProximos(Double latitude, Double longitude, Double raioKm){
        Point pontoReferencia = geometryFactory.createPoint(new Coordinate(latitude, longitude));

        double raioMetros = raioKm * 1000;

        List<Brecho> brechos = brechoRepository.findBrechosWithinRadius(pontoReferencia, raioMetros);

        return brechos.stream().map(this::mapearParaDTO).collect(Collectors.toList());
    }

    private BrechoResponseDTO mapearParaDTO(Brecho brecho){
        List<String> nomesEstilos = brecho.getEstilos().stream()
                .map(Estilo::getNome)
                .toList();

        return new BrechoResponseDTO(
                brecho.getId(),
                brecho.getNome(),
                brecho.getEndereco(),
                brecho.getFotoUrl(),
                brecho.getLocalizacao().getY(),
                brecho.getLocalizacao().getX(),
                nomesEstilos
        );
    }
}
