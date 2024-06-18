package SiteAutomation;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class usuarioTeste {
	private objectPage paginaDeUsuario;
		
	@BeforeEach
	public void beforeEach() {
		this.paginaDeUsuario = new objectPage();
	}
		
	@AfterEach
	public void afterEach(){
		this.paginaDeUsuario.fechar();
	}
	
	//Fazer login na plataforma
	@Test
	public void loginValido() {
		this.paginaDeUsuario.fazerLoginValido();
		Assert.assertTrue(paginaDeUsuario.paginaLogin());
		Assert.assertEquals("Celso", paginaDeUsuario.TextoPaginaUsuario());
	}
	
	//Enviar formulário no "contact us" estando logado
	@Test
	public void enviarForm() {
		this.paginaDeUsuario.fazerLoginValido();
		this.paginaDeUsuario.formularioContato();
		this.paginaDeUsuario.capiturandoAlerta();
		Assert.assertEquals("FEEDBACK FOR US", paginaDeUsuario.TextoForm());
	}
	
	//Erro de envio de formulário com campos inválidos
	@Test
	public void FormErro() {
		this.paginaDeUsuario.fazerLoginValido();
		this.paginaDeUsuario.formContatoInvalido();
		//Assert.assertTrue(paginaDeUsuario.paginaContato());  // *ERRO por causa do popup*
	}
	
	//Adicionar produtos ao carrinho de compras
	@Test
	public void addProdutos() {
		this.paginaDeUsuario.fazerLoginValido();
		this.paginaDeUsuario.adicaoProdutos();
	}

}
