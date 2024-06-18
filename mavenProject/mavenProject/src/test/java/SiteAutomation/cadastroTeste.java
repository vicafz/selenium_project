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
public class cadastroTeste {
	private objectPage paginaDeCadastro;
	
	@BeforeEach
    public void beforeEach() {
        this.paginaDeCadastro = new objectPage();
    }
	
	@AfterEach
    public void afterEach(){
    	this.paginaDeCadastro.fechar();
    }
	
	//Cadastro inicial com erro
	@Test
	public void CadastroInicialErro_1() {
		this.paginaDeCadastro.cadastroComErro();
		Assert.assertFalse(paginaDeCadastro.paginaLogin());
	}

	//Cadastro inicial válido
	@Test
	public void CadastroInicial_2() {
		this.paginaDeCadastro.cadastroValido();
		Assert.assertEquals("ENTER ACCOUNT INFORMATION", paginaDeCadastro.TextoPaginaCadastro());
	}
	
	//Cadastro final com erro nos campos obrigatórios
	@Test
	public void CadastroFinalErro_3() {
		this.paginaDeCadastro.cadastroValido();
		this.paginaDeCadastro.cadFinalInvalido();
		Assert.assertEquals("ENTER ACCOUNT INFORMATION", paginaDeCadastro.TextoPaginaCadastro());
		Assert.assertFalse(paginaDeCadastro.paginaCadastro());
	}
	
	//Cadastro final com informações válidas
	@Test
	public void CadastroFinalValido_4() {
		this.paginaDeCadastro.cadastroValido();
		this.paginaDeCadastro.cadFinalCerto();
		Assert.assertEquals("ACCOUNT CREATED!", paginaDeCadastro.TextoPaginaCadastroFinal());
		
	}
	
}

