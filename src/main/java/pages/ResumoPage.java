package pages;

import core.BasePage;

public class ResumoPage extends BasePage {
	
	public void clicarExcluirPrimeiraMovimentacao() {
		clicarPorXpath("//span[@class='glyphicon glyphicon-remove-circle']");
	}
	
}
