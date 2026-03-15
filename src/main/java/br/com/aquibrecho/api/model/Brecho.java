package br.com.aquibrecho.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;
import java.util.List;

@Entity
@Table(name = "brechos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Brecho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String endereco;
    private String fotoUrl;

    @Column(columnDefinition = "geometry(Point,4326)")
    private Point localizacao;

    @ManyToMany
    @JoinTable(name ="brecho_estilos",
    joinColumns = @JoinColumn(name = "brecho_id"),
    inverseJoinColumns = @JoinColumn(name = "estilo_id"))
    private List<Estilo> estilos;

}
