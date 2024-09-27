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
		assertEquals("515.25", homePage.obterSaldoConta("ContaTesteLucas2"));
	}
}
