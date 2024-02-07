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
@Table(name = "tb_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;
    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;
    @Column(name = "apellido", nullable = false, length = 250)
    private String apellido;
    @ManyToMany
    @JoinTable(name = "tb_cliente_rol",
    joinColumns = @JoinColumn(name = "id_cliente"),
    inverseJoinColumns = @JoinColumn(name = "id_rol"))
    private List<Rol> rols;
}
