package edu.cibertec.insertarCliente.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
@Entity
@Table(name = "tb_rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Long id;
    @Column(name = "descr", nullable = false, length = 100, unique = true)
    private String descripcion;
}
