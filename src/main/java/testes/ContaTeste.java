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
		contasPage.setNome("ContaTesteInserirConta");
		contasPage.clicarSalvar();
		assertEquals("Conta adicionada com sucesso!", contasPage.obterMensagemSucesso());
	}
	
	@Test
	public void testeAlterarConta () {
		menuPage.acessarTelaAlterarConta();
		contasPage.clicarAlterarConta("Conta para alterar");
		contasPage.setNome("Conta alterada");
		contasPage.clicarSalvar();
		assertEquals("Conta alterada com sucesso!", contasPage.obterMensagemSucesso());
	}
	
	@Test
	public void testeInserirContaMesmoNome () {
		menuPage.acessarTelaInserirConta();
		contasPage.setNome("Conta mesmo nome");
		contasPage.clicarSalvar();
		assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemFalha());
	}
	
	@Test
	public void testeExcluirContaComMovimentacao () {
		menuPage.acessarTelaAlterarConta();
		contasPage.clicarExcluirConta("Conta com movimentacao");
		assertEquals("Conta em uso na movimentações", contasPage.obterMensagemFalha());
	}
	
}
