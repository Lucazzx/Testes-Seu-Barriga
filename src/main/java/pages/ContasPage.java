package pages;

import core.BasePage;

public class ContasPage extends BasePage {
	
	public void setNome(String nome) {
		escrever("nome", nome);
	}
	
	public void clicarSalvar() {
		clicarPorXpath("//button[.='Salvar']");
	}
	
	public String obterMensagemSucesso() {
		return obterTextoXPath("//div[@class='alert alert-success']");
	}

}
