package testSuite;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ejerciciosTestNG {
    private static SoftAssert softAssert = new SoftAssert();


    @BeforeSuite
    public void metodo1(){
        System.out.println("Inicio de Suite");
    }

    @AfterSuite
    public void metodo2(){
        System.out.println("Termino de Suite");

    }

    @Test(priority= 1, description = "Prueba 1")
    public void metodo3(){
        System.out.println("Suite 1");
        softAssert.fail();
        System.out.println("Suite 1");
    }

    @Test(priority = 2, description = "Prueba 2")
    public void metodo4(){
        System.out.println("Suite 2");
        Assert.assertTrue(true);
        Assert.fail("Fail");
    }

    @AfterMethod
    public void metodo5(){
        System.out.println("Termino Test");

    }

}
