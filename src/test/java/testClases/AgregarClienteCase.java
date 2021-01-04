package testClases;

import pages.CarruselPage;

public class AgregarClienteCase {
    CarruselPage carruselPage =  new CarruselPage();

    public void flujo(){
        carruselPage.validarVistaDesplegada();
        carruselPage.recorrerCarrusel();
        carruselPage.tapBtnHecho();
    }
}
