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

public class CrearProductoPage {
    private AppiumDriver driver;

    public CrearProductoPage() {
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView")
    private MobileElement tituloVistaCrearProducto;

    @AndroidFindBy(id = "com.rodrigo.registro:id/nombre_producto")
    private MobileElement inputNombre;

    @AndroidFindBy(id = "com.rodrigo.registro:id/precio")
    private MobileElement inputPrecioLista;

    @AndroidFindBy(id = "com.rodrigo.registro:id/confirmar")
    private MobileElement btnConfirmar;

    public void validarVistaDesplegada(){
        if (esperarObjeto(tituloVistaCrearProducto, 2)){
            addStep("Validar Crear Producto Desplegada", true, Status.PASSED, false);
        }
        else {
            addStep("Error en Vista Crear Producto", true, Status.FAILED , true);
        }

    }

    public void completarFormularioProducto(String nombre, String  precio){
        System.out.println("[CrearProducto Page] Completar formulario de creación de producto ");
        inputNombre.setValue(nombre);
        this.driver.hideKeyboard();
        inputPrecioLista.click();
        inputPrecioLista.setValue(precio);
        this.driver.hideKeyboard();
        addStep("Formulario de Creación de Producto completado ", true, Status.PASSED, false);
    }

    public void tapConfirmar(){
        btnConfirmar.click();
        addStep("Tap en botón confirmar para crear producto ", true, Status.PASSED, false);
    }
}
