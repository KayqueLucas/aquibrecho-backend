package br.com.aquibrecho.api.repository;

import br.com.aquibrecho.api.model.Brecho;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.awt.*;

public interface BrechoRepository  extends JpaRepository<Brecho, Long> {

    @Query(value = "SELECT * FROM brecho b WHERE ST_DistanceSphere(b.localizacao, :ponto) < :distanciaMetros", nativeQuery = true)
    List<Brecho> findByProximidade(@Param("ponto")Point ponto, @Param("distanciaMetros") double distanciaMetros);
}
