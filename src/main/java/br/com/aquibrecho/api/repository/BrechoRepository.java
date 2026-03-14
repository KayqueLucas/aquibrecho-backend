package br.com.aquibrecho.api.repository;

import br.com.aquibrecho.api.model.Brecho;
import org.locationtech.jts.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.awt.*;

public interface BrechoRepository  extends JpaRepository<Brecho, Long> {

    @Query("SELECT b FROM Brecho b WHERE ST_DistanceSphere(b.localizacao, :pontoReferencia) <= :raioMetros")
    List<Brecho> findBrechosWithinRadius(
            @Param("pontoReferencia") Point pontoReferencia,
            @Param("raioMetros") double raioMetros
    );
}
