package testes;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.BaseTeste;
import core.DriverFactory;
import pages.MenuPage;
import pages.ResumoPage;

public class ResumoTeste extends BaseTeste{
	
	MenuPage menuPage = new MenuPage();
	ResumoPage resumoPage = new ResumoPage();
	
	@Test
	public void testeExcluirMovimentacao() {
		menuPage.acessarTelaResumo();
		resumoPage.clicarExcluirPrimeiraMovimentacao();
		assertEquals("Movimentação removida com sucesso!", resumoPage.obterMensagemSucesso());
	}
	
	@Test
	public void testeResumoMensal() {
		menuPage.acessarTelaResumo();
		resumoPage.selecionarAno("2020");
		resumoPage.clicarBuscar();
		
		List<WebElement> elementosEncontrados = 
				DriverFactory.getDriver().findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
		assertEquals(0, elementosEncontrados.size());
	}

}
