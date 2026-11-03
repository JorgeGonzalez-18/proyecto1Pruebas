package cr.ac.utn.proyecto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    protected WebDriver driver;

    // Localizadores
    @FindBy(linkText = "Register")
    private WebElement lnkRegister;

    @FindBy(linkText = "Log in")
    private WebElement lnkLogin;

    @FindBy(linkText = "Log out")
    private WebElement lnkLogout;

    @FindBy(className = "account")
    private WebElement lnkAccount;

    @FindBy(id = "small-searchterms")
    private WebElement txtSearch;

    @FindBy(css = "input.search-box-button")
    private WebElement btnSearch;

    @FindBy(css = "#topcartlink .cart-label")
    private WebElement lnkCart;

    @FindBy(css = "#topcartlink .cart-qty")
    private WebElement lblCartQty;

    //Contructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Metodos Logica
    public RegisterPage  irRegistro() {
        lnkRegister.click();
        return new RegisterPage(driver);
    }

    public LoginPage irLogin() {
        lnkLogin.click();
        return new LoginPage(driver);
    }

    public HomePage cerrarSesion() {
        lnkLogout.click();
        return this;
    }

    public String obtenerTextoCuenta() {
        return lnkAccount.getText();
    }

    public void buscar(String texto) {
        txtSearch.clear();
        txtSearch.sendKeys(texto);
        btnSearch.click();
    }


}
