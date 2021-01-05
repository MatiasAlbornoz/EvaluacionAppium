package testClases;

import pages.CarruselPage;
import pages.CrearProductoPage;
import pages.RegistroPage;

public class AgregarProductoCase {
    CarruselPage carruselPage =  new CarruselPage();
    RegistroPage registroPage = new RegistroPage();
    CrearProductoPage crearProductoPage = new CrearProductoPage();

    String nombre = "Audifonos";
    String precio = "2500";

    public void flujo(){
        carruselPage.validarVistaDesplegada();
        carruselPage.recorrerCarrusel();
        carruselPage.tapBtnHecho();

        registroPage.validarVistaDesplegada();
        registroPage.tapBtnMas();
        registroPage.tapBtnCrearProducto();

        crearProductoPage.validarVistaDesplegada();
        crearProductoPage.completarFormularioProducto(nombre, precio);
        crearProductoPage.tapConfirmar();

        registroPage.tapMenuProductos();
        registroPage.validarProducto(nombre, precio);

    }
}
