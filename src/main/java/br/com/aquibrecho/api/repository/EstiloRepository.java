package br.com.aquibrecho.api.repository;

import br.com.aquibrecho.api.model.Estilo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstiloRepository extends JpaRepository<Estilo, Long> {

}
