package edu.cibertec.insertarCliente.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "tb_tipoCuenta")
public class TipoCuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipoCuenta")
    private Long id;
    @Column(name = "descr", nullable = false, length = 200)
    private String descripcion;
}
