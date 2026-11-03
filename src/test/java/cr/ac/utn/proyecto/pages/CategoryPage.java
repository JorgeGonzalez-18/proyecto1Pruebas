package cr.ac.utn.proyecto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.stream.Collectors;


public class CategoryPage {
    private WebDriver driver;

    //Localizadores
    @FindBy(id = "product-orderby")
    private WebElement cboOrderBy;

    @FindBy(id = "products-pagesize")
    private WebElement cboPageSize;

    @FindBy(id = "products-viewmode")
    private WebElement cboViewMode;

    @FindBy(css = ".product-title a")
    private List<WebElement> listaNombresProductos;

    @FindBy(css = ".actual-price")
    private List<WebElement> listaPreciosProductos;


    //Constructor
    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Metodos Logica
     //Ordena los productos según el texto visible
    public void ordenarPor(String opcionVisible) {
        Select select = new Select(cboOrderBy);
        select.selectByVisibleText(opcionVisible);
    }

     //Cambia la cantidad de productos por página
    public void cambiarCantidadPorPagina(String cantidad) {
        Select select = new Select(cboPageSize);
        select.selectByVisibleText(cantidad);
    }

     //Cambia la vista del catalogo
    public void cambiarVista(String vista) {
        Select select = new Select(cboViewMode);
        select.selectByVisibleText(vista);
    }

     //Devuelve la lista de nombres de los productos
    public List<String> obtenerNombresProductos() {
        return listaNombresProductos.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    //Devuelve la lista de precios convertidos a números tipo double
    // para poder verificar con aserciones si están ordenados de menor a mayor
    public List<Double> obtenerPreciosProductos() {
        return listaPreciosProductos.stream()
                .map(e -> Double.parseDouble(e.getText().replace("$", "").trim()))
                .collect(Collectors.toList());
    }
}
