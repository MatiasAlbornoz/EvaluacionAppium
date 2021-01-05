package testSuite;

import conexion.DriverContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testClases.AgregarProductoCase;
import testClases.EliminarClienteCase;

import static conexion.DriverContext.setUp;
import static reports.Reports.finalAssert;

public class EvaluacionAppium {
    @BeforeMethod
    public void iniciarSession() {
        setUp("emulador-5554", "Android", "/Users/Security/Downloads/registroDeUsuarios.apk", "emulador-5554", true);
    }

    @AfterMethod
    public void cerrarSesion() {
        DriverContext.quitDriver();
    }

    @Test(description = "Test para agregar un producto y validar su creación posteriormente")
    public void agregarProducto(){
        AgregarProductoCase agregarProductoCase = new AgregarProductoCase();
        agregarProductoCase.flujo();
        finalAssert();
    }

    @Test(description = "Test para eliminar un cliente que ya haya sido creado")
    public void eliminarCliente(){
        EliminarClienteCase eliminarClienteCase = new EliminarClienteCase();
        eliminarClienteCase.flujo();
        finalAssert();
    }
}
