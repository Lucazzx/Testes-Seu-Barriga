package testes;

import static core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import core.BaseTeste;
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
		assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
	}

}
