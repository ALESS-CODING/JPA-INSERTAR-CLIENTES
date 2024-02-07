package edu.cibertec.insertarCliente.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@ToString
@Entity
@Table(name = "tb_cuenta")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cuenta")
    private Long id;
    @Column(name = "descr", nullable = false)
    private String descripcion;
    @Column(name = "saldo", nullable = false)
    private BigDecimal saldo;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "id_tipoCuenta", nullable = false)
    private TipoCuenta tipoCuenta;
    @OneToMany(mappedBy = "cuenta" ,cascade = CascadeType.PERSIST)
    private List<Movimiento> movimiento;


}
