package pages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    @AndroidFindBy(xpath = "//*[contains(@text,\"PRODUCTOS\")]")
    private MobileElement menuProductos;

    @AndroidFindBy(id = "com.rodrigo.registro:id/nombre_producto")
    private List<MobileElement> labelsProductos;

    @AndroidFindBy(id = "com.rodrigo.registro:id/precio_producto")
    private List<MobileElement> labelsProductosPrecio;

    @AndroidFindBy(id = "com.rodrigo.registro:id/nombre_cliente")
    private List<MobileElement> labelsClientes;

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
            addStep("Error, no se encontró el botón Crear Producto", true, Status.FAILED, true);
        }
    }

    public void tapMenuProductos(){
        if (esperarObjeto(menuProductos, 2))
        {
            addStep("Tap al menú de Productos", false, Status.PASSED, false);
            menuProductos.click();
        }
        else {
            addStep("Error, no se encontró el menú Productos", true, Status.FAILED, true);
        }
    }

    public void validarProducto(String nombre, String precio){
        System.out.println("[Registro Page] Validar Producto");
        boolean productoEncontrado = false;
        precio = precio+".00";

        for (int i =0;i<=labelsProductos.size();i++){
            String nombreProductoActual = labelsProductos.get(i).getText();
            String precioProductoActual = labelsProductosPrecio.get(i).getText();
            if (nombreProductoActual.equals(nombre) && precioProductoActual.equals(precio)){
                productoEncontrado = true;
                break;
            }
        }

        if (productoEncontrado){
            addStep("Producto: "+nombre+" creado exitosamente", true, Status.PASSED, false);
        }
        else {
            addStep("Producto: "+nombre+" no encontrado", true, Status.FAILED, true);
        }

    }

    public void validarCliente(String nombre){
        System.out.println("[Registro Page] Validar Cliente");
        boolean clienteEncontrado = false;


        for (int i =0;i<=labelsClientes.size();i++){
            String nombreClienteActual = labelsClientes.get(i).getText();
            if (nombreClienteActual.equals(nombre)){
                labelsClientes.get(i).click();
                clienteEncontrado = true;
                break;
            }
        }

        if (clienteEncontrado){
            addStep("Cliente: "+nombre+" se encuentra en listado", true, Status.PASSED, false);
        }
        else {
            addStep("Cliente: "+nombre+" no se encuentra en listado", true, Status.FAILED, true);
        }

    }

    public void validarClienteEliminado(String nombre){
        System.out.println("[Registro Page] Validar Cliente Eliminado");
        boolean clienteEncontrado = false;


        for (int i =0;i<=labelsClientes.size();i++){
            String nombreClienteActual = labelsClientes.get(i).getText();
            if (!nombreClienteActual.equals(nombre)){
                clienteEncontrado = true;
                break;
            }
        }

        if (clienteEncontrado){
            addStep("Cliente: "+nombre+" eliminado exitosamente", true, Status.PASSED, false);
        }
        else {
            addStep("Cliente: "+nombre+" no se eliminó", true, Status.FAILED, true);
        }

    }
}
