package pages;

import org.openqa.selenium.By;

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
	
	public String obterMensagemFalha() {
		return obterTextoXPath("//div[@class='alert alert-danger']");
	}

	public void clicarAlterarConta(String conta) {
		obterCelula("Conta", conta, "Ações", "tabelaContas").findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();
		
	}

}
