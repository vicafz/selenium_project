package SiteAutomation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class objectPage {
	
	private static final String URL_INICIO = "https://automationexercise.com/";
	private static final String URL_CONTATO = "https://automationexercise.com/contact_us";
	private static final String URL_SINGUP = "https://automationexercise.com/singup";

	private WebDriver browser;
	private String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	
	private Random aleatorio = new Random();
	private Integer numeroAleatorio = aleatorio.nextInt(9999);
	String email = "celsoasb" +numeroAleatorio.toString() + "@gmail.com";
	
	
	
	public objectPage() {
		
		 System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	        this.browser = new ChromeDriver();
	        this.browser.navigate().to(URL_INICIO);
		
	}
	
	
	public void capiturandoAlerta() {
		  // Aguardar o alerta aparecer (pode ser necessário ajustar o tempo dependendo da aplicação)
      try {
          Thread.sleep(2000);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }

      // Lidar com o alerta
      Alert alert = browser.switchTo().alert();
      System.out.println("Press OK to proceed!: " + alert.getText());

      // Aceitar o alerta (clicar em "OK")
      alert.accept();
	}
	
	public void esperarTime() {
		try {
	          Thread.sleep(7000);
	      } catch (InterruptedException e) {
	          e.printStackTrace();
	      }
	}
	
	public void fechar() {
		this.browser.quit();
		
	}


	//Preenchimento de informações de cadastro inicial inválidas (sem o @gmail.com)
	public void cadastroComErro() {		
		browser.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();
		browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")).sendKeys("Celso Asb");
		browser.findElement(By.xpath("/html/body/section/div/div/div[3]/div/form/input[3]")).sendKeys("Celsoasb");
		browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button")).click();

	}
	
	//Preenchimento de informações de cadastro inicial válidas
	public void cadastroValido() {		
		browser.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();
		browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")).sendKeys("Celso Asb");
		browser.findElement(By.xpath("/html/body/section/div/div/div[3]/div/form/input[3]")).sendKeys(email);
		browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button")).click();

	}
	
	//Preenchimento dos campos de cadastro final de forma inválida 
	public void cadFinalInvalido() {
		browser.findElement(By.xpath("//*[@id=\"id_gender2\"]")).click();
		browser.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("12345678");
		browser.findElement(By.xpath("//*[@id=\"days\"]")).sendKeys(hoje);
		browser.findElement(By.xpath("//*[@id=\"months\"]")).sendKeys(hoje);
		browser.findElement(By.xpath("//*[@id=\"years\"]")).sendKeys(hoje);
		browser.findElement(By.xpath("//*[@id=\"first_name\"]")).sendKeys("Sucelssius");
		browser.findElement(By.xpath("//*[@id=\"address1\"]")).sendKeys("Rua dezoite, 777");
		browser.findElement(By.xpath("//*[@id=\"country\"]")).sendKeys("Canada");
		browser.findElement(By.xpath("//*[@id=\"zipcode\"]")).sendKeys("nao possue 0000-0000");
		browser.findElement(By.xpath("//*[@id=\"mobile_number\"]")).sendKeys("(99)99999-9999");
		browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button")).click();
	}
	
	//preencher campos de castro final válidos
	public void cadFinalCerto() {
		
		browser.findElement(By.xpath("//*[@id=\"id_gender2\"]")).click();
		browser.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("12345678");
		browser.findElement(By.xpath("//*[@id=\"days\"]")).sendKeys(hoje);
		browser.findElement(By.xpath("//*[@id=\"months\"]")).sendKeys(hoje);
		browser.findElement(By.xpath("//*[@id=\"years\"]")).sendKeys(hoje);
		browser.findElement(By.xpath("//*[@id=\"first_name\"]")).sendKeys("Sucelssius");
		browser.findElement(By.xpath("//*[@id=\"last_name\"]")).sendKeys("Valença");
		browser.findElement(By.xpath("//*[@id=\"address1\"]")).sendKeys("Rua dezoite, 777");
		browser.findElement(By.xpath("//*[@id=\"country\"]")).sendKeys("Canada");
		browser.findElement(By.xpath("//*[@id=\"state\"]")).sendKeys("Pernambuco");
		browser.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("Petrolina");
		browser.findElement(By.xpath("//*[@id=\"zipcode\"]")).sendKeys("nao possue 0000-0000");
		browser.findElement(By.xpath("//*[@id=\"mobile_number\"]")).sendKeys("(99)99999-9999");
		browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button")).click();
		
	}
	
	//Preencher campos de login na plataforma com campos válidos
	public void fazerLoginValido() {
		browser.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();
		browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")).sendKeys("Celso@gmail.com");
		browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")).sendKeys("12345");
		browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button")).submit();
	}
	
	//Preencher formulário de "contact us" com campos válidos 
	public void formularioContato() {
		browser.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[9]/a")).click();
		browser.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[1]/input")).sendKeys("Celso Barros");
		browser.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[2]/input")).sendKeys("Celso@gmail.com");
		browser.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[3]/input")).sendKeys("Agradecimento ao site incrível");
		browser.findElement(By.xpath("//*[@id=\"message\"]")).sendKeys("Quero agradecer aos desenvolvedores desse incrível site pelo conteúdo massa que disponibilizado!!");
		browser.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[6]/input")).submit();


	}
	
	//Preencher formulário de "contact us" com campos inválidos
	public void formContatoInvalido() {
		browser.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[9]/a")).click();
		browser.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[1]/input")).sendKeys("Celso Barros");
		browser.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[2]/input")).sendKeys("porfacoreaad");
		browser.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[3]/input")).sendKeys("Felicitações ao site incrível");
		browser.findElement(By.xpath("//*[@id=\"message\"]")).sendKeys("Quero agradecer aos desenvolvedores desse incrível site pelo conteúdo massa que disponibilizado!!");
		browser.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[6]/input")).submit();
	}
	
	//Adicionar produto no carrinho
	public void adicaoProdutos() {
		Actions pagAction = new Actions(browser);
		
		WebElement produto = browser.findElement(By.cssSelector("[data-product-id='3']"));
		pagAction.pause(1).moveToElement(produto).click(produto).perform();

	}
	
	
	
	
	
	
	
	
	
	
	
	// ---------------------------------- ASSERTs -------------------------------------------------//
	
	public boolean paginaLogin() {
		return this.browser.getCurrentUrl().equals(URL_INICIO);
	}
	
	public String TextoPaginaCadastro() {
		return this.browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/h2/b")).getText();
	}
	
	public boolean paginaCadastro() {
		return this.browser.getCurrentUrl().equals(URL_SINGUP);
	}
	
	public String TextoPaginaCadastroFinal() {
		return this.browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b")).getText();
	}
	
	public String TextoPaginaUsuario() {
		return this.browser.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/b")).getText();
	}
	
	public String TextoForm() {
		return this.browser.findElement(By.xpath("//*[@id=\"contact-page\"]/div[2]/div[2]/div/h2")).getText();
	}
	
	public boolean paginaContato() {
		return this.browser.getCurrentUrl().equals(URL_CONTATO);
	}

}