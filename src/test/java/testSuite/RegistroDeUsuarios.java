package testSuite;

import conexion.DriverContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reports.Reports;
import testClases.AgregarClienteCase;
import testClases.AgregarProductoCase;

import static conexion.DriverContext.setUp;

public class RegistroDeUsuarios {
    @BeforeMethod
    public void iniciarSession() {
        setUp("emulador-5554", "Android", "/Users/Security/Downloads/registroDeUsuarios.apk", "emulador-5554", true);
    }

    @AfterMethod
    public void cerrarSesion() {
        DriverContext.quitDriver();
    }

    @Test
    public void agregarCliente(){
        AgregarClienteCase agregarClienteCase = new AgregarClienteCase();
        agregarClienteCase.flujo();
    }

}
