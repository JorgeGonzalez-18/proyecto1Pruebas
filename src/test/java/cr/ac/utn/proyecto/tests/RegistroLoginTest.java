package cr.ac.utn.proyecto.tests;

import cr.ac.utn.proyecto.base.BaseTest;
import cr.ac.utn.proyecto.pages.HomePage;
import cr.ac.utn.proyecto.pages.RegisterPage;
import cr.ac.utn.proyecto.pages.RegisterResultPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistroLoginTest extends  BaseTest{
    @Test 
    @DisplayName ("CP-001 Registro exitoso")
    void registroExitoso(){
        //arange
        driver.get(URL_BASE);
        HomePage inicio = new HomePage(driver);
        RegisterPage registro = inicio.irRegistro();

        String email = "qa" + System.currentTimeMillis() + "@example.com";
        String password = "Prueba123!";

        //act
        RegisterResultPage resultado = registro.registrarUsuarioValido("Ana", "Prueba", email, password, password);

        //assert
        String mensaje = resultado.obtenerMensajeResultado();
        assertTrue(mensaje.contains("Your registration completed"), "mensaje real:"+mensaje);
    }
}
