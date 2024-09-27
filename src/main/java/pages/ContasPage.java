package pages;

import org.openqa.selenium.By;

import core.BasePage;

public class ContasPage extends BasePage {
	
	public void setNome(String nome) {
		escrever("nome", nome);
	}
	
	public void clicarAlterarConta(String conta) {
		obterCelula("Conta", conta, "A��es", "tabelaContas").findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();
		
	}

}
