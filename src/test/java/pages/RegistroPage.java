package pages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.PageFactory;

import static reports.Reports.addStep;
import static utils.Utils.esperarObjeto;

public class RegistroPage {
    private AppiumDriver driver;

    public RegistroPage() {
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[contains(@text,\"Registro\")]")
    private MobileElement tituloVistaRegistro;

    @AndroidFindBy(id = "com.rodrigo.registro:id/fab_expand_menu_button")
    private MobileElement btnMas;

    @AndroidFindBy(id = "com.rodrigo.registro:id/action_cliente")
    private MobileElement btnCrearCliente;

    @AndroidFindBy(id = "com.rodrigo.registro:id/action_producto")
    private MobileElement btnCrearProducto;

    public void validarVistaDesplegada(){
        if (esperarObjeto(tituloVistaRegistro, 2)){
            addStep("Validar Registro Desplegada", true, Status.PASSED, false);
        }
        else {
            addStep("Error  Validar vista 1 de carrusel", true, Status.FAILED , true);
        }

    }

    public void tapBtnMas(){
        if (esperarObjeto(btnMas, 2))
        {
            addStep("Tap al botón '+ '", false, Status.PASSED, false);
            btnMas.click();
        }
        else {
            addStep("Error, no se encuentra al botón '+ '", true, Status.FAILED, true );
        }

    }

    public void tapBtnCrearProducto(){
        if (esperarObjeto(btnCrearProducto, 2))
        {
            addStep("Tap al botón Crear Producto", false, Status.PASSED, false);
            btnCrearProducto.click();
        }
        else {
            addStep("Error, no se encontró e l botón Crear Producto", true, Status.FAILED, true);
        }
    }
}
