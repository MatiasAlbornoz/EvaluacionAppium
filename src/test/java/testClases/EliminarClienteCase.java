package testClases;

import pages.CarruselPage;
import pages.DetalleCliente;
import pages.RegistroPage;

public class EliminarClienteCase {
    CarruselPage carruselPage =  new CarruselPage();
    RegistroPage registroPage = new RegistroPage();
    DetalleCliente detalleCliente = new DetalleCliente();

    String nombre = "rodrigo";

    public void flujo(){
        carruselPage.validarVistaDesplegada();
        carruselPage.recorrerCarrusel();
        carruselPage.tapBtnHecho();

        registroPage.validarVistaDesplegada();
        registroPage.validarCliente(nombre);

        detalleCliente.validarVistaDesplegada();
        detalleCliente.eliminarCliente();
        detalleCliente.popUpEliminarCliente();
        detalleCliente.tapConfirmarEliminarCliente();

        registroPage.validarClienteEliminado(nombre);
    }
}
