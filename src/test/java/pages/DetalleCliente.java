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
import static utils.Utils.swipeAbajo;

public class DetalleCliente {
    private AppiumDriver driver;

    public DetalleCliente() {
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.rodrigo.registro:id/title")
    private MobileElement tituloDetalleCliente;

    @AndroidFindBy(id = "com.rodrigo.registro:id/eliminar_cliente")
    private MobileElement btnEliminarCliente;

    @AndroidFindBy(id = "com.rodrigo.registro:id/editTextDialogUserInput")
    private MobileElement inputPopupConfirmacionBorrar;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement btnOkBorrar;

    public void validarVistaDesplegada(){
        if (esperarObjeto(tituloDetalleCliente, 2)){
            addStep("Validar Detalle Cliente Desplegada", true, Status.PASSED, false);
        }
        else {
            addStep("Error en Vista Detalle Cliente", true, Status.FAILED , true);
        }

    }

    public void eliminarCliente(){
        swipeAbajo();
        btnEliminarCliente.click();
        addStep("Tap botón Eliminar Cliente", true, Status.PASSED, false);
    }

    public void popUpEliminarCliente(){
        addStep("PopUp Eliminación de Cliente", true, Status.PASSED, false);
        inputPopupConfirmacionBorrar.click();
        inputPopupConfirmacionBorrar.setValue("BORRAR");
        this.driver.hideKeyboard();
    }

    public void tapConfirmarEliminarCliente(){
        btnOkBorrar.click();
        addStep("Tap botón OK para borrar Cliente", true, Status.PASSED, false);
    }
}
