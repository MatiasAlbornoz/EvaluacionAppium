package testClases;

import pages.CarruselPage;
import pages.RegistroPage;

public class AgregarProductoCase {
    CarruselPage carruselPage =  new CarruselPage();
    RegistroPage registroPage = new RegistroPage();

    public void flujo(){
        carruselPage.validarVistaDesplegada();
        carruselPage.recorrerCarrusel();
        carruselPage.tapBtnHecho();

        registroPage.validarVistaDesplegada();
        registroPage.tapBtnMas();
        registroPage.tapBtnCrearProducto();
    }
}
