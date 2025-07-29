package cl.kibernumacademy.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cl.kibernumacademy.pages.BancaFicticiaPage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BancaFicticiaTest{

    private WebDriver driver;
    private BancaFicticiaPage bancaFicticiaPage;
    private String URL = "https://bco-selenium.netlify.app/";

    private String usuario = "sofia";
    private String usuarioIncorrecto = "juan";
    private String password = "academy";
    private String mensajeBienvenida= "Bienvenido(a), ";
    private String mensajeIniciarSesion= "Iniciar Sesión";
    private String mensajeCredencialesIncorrectas= "Credenciales incorrectas";
    private String mensajeSaldoInsuficiente = "Saldo insuficiente";
    
    
    @BeforeEach
    void setupTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        bancaFicticiaPage = new BancaFicticiaPage(driver);
    }

    @AfterEach
    void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    // Login exitoso con usuario válido.
    void testLoginUsuario(){
        bancaFicticiaPage.login(this.usuario, this.password);
        assertEquals(this.mensajeBienvenida+usuario, bancaFicticiaPage.getWelcomeMessage());
    }

    @Test
    // Login fallido con credenciales incorrectas.
    void testLoginUsuarioIncorrecto(){
        bancaFicticiaPage.login(this.usuarioIncorrecto, this.password);
        assertEquals(this.mensajeCredencialesIncorrectas, bancaFicticiaPage.getLoginMessage());
    }

    @Test
    // Consulta de saldo tras iniciar sesión.
    void testConsultaDeSaldo(){
        bancaFicticiaPage.login(this.usuario, this.password);
        bancaFicticiaPage.clickConsultaSaldoButton();
        assertNotNull(bancaFicticiaPage.getSaldoMessage()); // Verificar que encuentre el campoo y tiene texto
    }
    
    @Test
    // Transferencia bancaria exitosa.
    void testTransferenciaExitosa(){
        bancaFicticiaPage.login(this.usuario, this.password);
        bancaFicticiaPage.transferirSaldo("552266-8", "1000", "Motivo X");
        String mensajeTransferenciaExitosa = bancaFicticiaPage.getTransferMessage();
        assertTrue(mensajeTransferenciaExitosa.contains("552266-8"));
        assertTrue(mensajeTransferenciaExitosa.contains("1000"));
    }

    @Test
    // Transferencia con saldo insuficiente
    void testTransferenciaInsuficiente(){
        bancaFicticiaPage.login(this.usuario, this.password);
        bancaFicticiaPage.transferirSaldo("552266-8", "100000", "Motivo X");
        String mensajeTransferenciaExitosa = bancaFicticiaPage.getTransferMessage();
        assertTrue(mensajeTransferenciaExitosa.contains("Saldo insuficiente"));
    }

    @Test
    // Logout y retorno al formulario de login.
    void testLogout(){
        bancaFicticiaPage.login(this.usuario, this.password);
        assertEquals(this.mensajeBienvenida+usuario, bancaFicticiaPage.getWelcomeMessage()); // Comprobamos que hizo login
        bancaFicticiaPage.logout();
        assertEquals(mensajeIniciarSesion, bancaFicticiaPage.getMessageLogin());// Comprobamos que estamos afuera

        
    }

}
     