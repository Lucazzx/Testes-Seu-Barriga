package testes;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import core.BaseTeste;
import pages.ContasPage;
import pages.MenuPage;

public class ContaTeste extends BaseTeste {
	
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void testeInserirConta () {
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("ContaTesteLucas2");
		contasPage.clicarSalvar();
		assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
	}
	
}
