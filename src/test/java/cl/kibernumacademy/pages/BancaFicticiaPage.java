package cl.kibernumacademy.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BancaFicticiaPage {

    private WebDriver driver;

    //Inicio sesión
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginMessage = By.id("login-message");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By welcomeMessage = By.cssSelector("#menu-section h2");
    private By transferenciaBancariaButton = By.id("btn-transfer");
    
    //Transferencia bancaria
    private By cuentaDestinoField = By.id("destino");
    private By montoField = By.id("monto");
    private By motivoField = By.id("motivo");
    private By transferButton = By.cssSelector("#transfer-form button[type='submit']");
    private By cancelButton = By.id("cancel-transfer");
    private By transferMessage =  By.id("transfer-message");

    //Consulta Saldo
    private By balanceBtn = By.id("btn-balance");
    private By balanceMessage = By.id("balance-info");
    private By backMenuBtn = By.id("back-menu");

    //Cerrar Sesión
    private By meensajeIniciarSesion = By.cssSelector("#login-section h2");
    private By logoutBtn = By.id("btn-logout");


    public BancaFicticiaPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public String getWelcomeMessage() {
        return driver.findElement(welcomeMessage).getText();
    }
    
    public String getMessageLogin() {
        return driver.findElement(meensajeIniciarSesion).getText();
    }

    public String getLoginMessage() {
        WebElement message = driver.findElement(loginMessage);
        return message.getText();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public void logout() {
        driver.findElement(logoutBtn).click();
    }

    /**
     * Consulta de Saldo
     */

    public void clickConsultaSaldoButton() {
        driver.findElement(balanceBtn).click();
    }

    public String getSaldoMessage() {
        return driver.findElement(balanceMessage).getText();
    }
    public void clickVolverMenuButton() {
        driver.findElement(backMenuBtn).click();
    }

    
    // Transferir saldo
    public void clickTransferenciaBancariaButton(){
        driver.findElement(transferenciaBancariaButton).click();
    }
    public void enterCuentaDestino(String cuentaDestino){
        driver.findElement(cuentaDestinoField).sendKeys(cuentaDestino);
    }
    public void enterMonto(String monto){
        driver.findElement(montoField).sendKeys(monto);
    }public void enterMotivo(String motivo){
        driver.findElement(motivoField).sendKeys(motivo);
    }
    public void clickTransferButton() {
        driver.findElement(transferButton).click();
    }
    public String getTransferMessage(){
        return driver.findElement(transferMessage).getText();
    }

    public void transferirSaldo(String cuentaDestino, String monto, String motivo){
        clickTransferenciaBancariaButton();
        enterCuentaDestino(cuentaDestino);
        enterMonto(monto);
        enterMotivo(motivo);
        clickTransferButton();
    }
    


}
