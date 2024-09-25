package pages;

import core.BasePage;

public class MenuPage extends BasePage {
	
	public void acessarHome(){
		clicarLink("Home");
	}
	
	public void acessarTelaInserirConta(){
		clicarLink("Contas");
		clicarLink("Adicionar");
	}

}
