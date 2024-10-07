package testes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import core.BaseTeste;
import pages.HomePage;
import pages.MenuPage;

public class SaldoTeste extends BaseTeste {
	MenuPage menuPage = new MenuPage();
	HomePage homePage = new HomePage();
	
	@Test
	public void testeSaldoConta() {
		menuPage.acessarHome();
		assertEquals("534.00", homePage.obterSaldoConta("Conta para saldo"));
	}
}
