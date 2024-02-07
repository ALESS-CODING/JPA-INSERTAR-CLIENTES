package edu.cibertec.insertarCliente.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
@Entity
@Table(name = "tb_movimiento")
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimiento")
    private Long id;
    @Column(name = "monto")
    private BigDecimal Monto;
    @ManyToOne
    @JoinColumn(name = "id_cuenta", nullable = false)
    private Cuenta cuenta;
}
