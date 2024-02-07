package edu.cibertec.insertarCliente;

import edu.cibertec.insertarCliente.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Commit;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteTest {

    @Autowired
    private TestEntityManager test;


    @Test
    @Commit
    void guardarRols(){
        Rol rol = new Rol();
        rol.setDescripcion("Benifeciario"); //Titular
        test.persist(rol);
    }

    @Test
    @Commit
    void guardarClienteTest(){
        //buscar rols
        Rol rol = test.find(Rol.class, 1);
        Rol rol1 = test.find(Rol.class, 2);

        Cliente cliente = new Cliente();
        cliente.setNombre("alex");
        cliente.setApellido("sedano");

        //Asignar roles
        cliente.setRols(Arrays.asList(rol, rol1));
        test.persist(cliente);
    }

    @Test
    @Commit
    void guardarTipoCuenta (){
        TipoCuenta tipoCuenta = new TipoCuenta();
        tipoCuenta.setDescripcion("Soles"); //Dolares
        test.persist(tipoCuenta);
    }

    @Test
    @Commit
    void crearCuenta (){
        //buscar tipoCuenta
        TipoCuenta tipoCuenta = test.find(TipoCuenta.class, 1);
        assertThat(tipoCuenta).isNotNull();
        //buscar cliente
        Cliente cliente = test.find(Cliente.class,1);
        assertThat(cliente).isNotNull();
        //crear cuenta
        Cuenta cuenta = new Cuenta();
        cuenta.setDescripcion("cuenta personal");
        cuenta.setSaldo(BigDecimal.valueOf(1000));
        cuenta.setCliente(cliente);
        cuenta.setTipoCuenta(tipoCuenta);
        Cuenta cuentaGuardada = test.persist(cuenta);
        assertThat(cuentaGuardada).isNotNull();
    }

    @Test
    @Commit
    void movimientoTest (){

        //buscar cuenta
        Cuenta cuenta = test.find(Cuenta.class, 1);

        Movimiento movimiento = new Movimiento();
        movimiento.setMonto(BigDecimal.valueOf(100));
        movimiento.setCuenta(cuenta);
        test.persist(movimiento);

        //actualizo cuenta
        cuenta.setSaldo( cuenta.getSaldo().subtract(movimiento.getMonto()));

        test.merge(cuenta);
    }

}
