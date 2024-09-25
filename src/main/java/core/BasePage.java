package core;

import static core.DriverFactory.getDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	 public void escrever(String id, String texto) {
			getDriver().findElement(By.id(id)).clear();
	    	getDriver().findElement(By.id(id)).sendKeys(texto);
	    }
	    
	    public void escreverTag(String tag, String texto) {
	    	getDriver().findElement(By.tagName(tag)).clear();
	    	getDriver().findElement(By.tagName(tag)).sendKeys(texto);
	    }
	    
	    public String obterValorCampo (String id) {
	    	return getDriver().findElement(By.id(id)).getAttribute("value");
	    }
	    
	    public String obterTextoCampo (String id) {
	    	return getDriver().findElement(By.id(id)).getText();
	    }
	    
	    public String obterTextoTag (String tag) {
	    	return getDriver().findElement(By.tagName(tag)).getText();
	    }
	    
	    public String obterTextoXPath (String xPath) {
	    	return getDriver().findElement(By.xpath(xPath)).getText();
	    }
	    
	    public void clicar(String id) {
	    	getDriver().findElement(By.id(id)).click();
	    }
	    
	    public void clicarPorXpath(String id) {
	    	getDriver().findElement(By.xpath(id)).click();
	    }
	    
	    public void clicarLink(String textoLink) {
	    	getDriver().findElement(By.linkText(textoLink)).click();
	    }
	    
	    public Boolean estaMarcado (String id) {
	    	return getDriver().findElement(By.id(id)).isSelected();
	    }
	    
	    public void selecionarCombo(String id, String[] esportes) {
	        WebElement element = getDriver().findElement(By.id(id));
	        Select combo = new Select(element);
	         
	        List<WebElement> todasOpcoes = combo.getOptions();
	        
	        for (WebElement opcao : todasOpcoes) {
	            String textoOpcao = opcao.getText(); 
	            
	            for (String esporte : esportes) {
	                if (textoOpcao.equalsIgnoreCase(esporte)) {
	                    combo.selectByVisibleText(esporte);
	                }
	            }
	        }
	    }
	    
	    public String obterValorCombo(String id) {
	    	WebElement element = getDriver().findElement(By.id(id));
			Select combo = new Select(element);
			//combo.selectByIndex(2);
			//combo.selectByValue("2grauincomp");
			return combo.getFirstSelectedOption().getText();
	    }
	    
	    public Boolean procurarValorCombo (String id, String valorProcurado) {
	    	boolean encontrouElemento = false;
			
	    	WebElement element = getDriver().findElement(By.id(id));
			Select combo = new Select(element);
			List<WebElement> options = combo.getOptions();
			for(WebElement option : options) {
				if (option.getText().equals(valorProcurado)) {
					encontrouElemento = true;
					break;
				}
			}
	    	return encontrouElemento;
	    }
	    
	    public void trocaParaAlerta () {
	    	getDriver().switchTo().alert();
	    }
	    
	    public void trocaEAceitaAlerta () {
	    	getDriver().switchTo().alert().accept();
	    }
	    
	    public void trocaENegaAlerta () {
	    	getDriver().switchTo().alert().dismiss();
	    }
	     
	    public String obterTextoAlerta () {
	    	return getDriver().switchTo().alert().getText();
	    }
	    
	    public void escreverAlerta (String texto) {
	    	getDriver().switchTo().alert().sendKeys(texto);
	    	getDriver().switchTo().alert().accept();
	    }
	    
	    public void trocaParaFrame (String frame) {
	    	getDriver().switchTo().frame(frame);
	    }
	    
	    public void trocaParaJanela (String janela) {
	    	getDriver().switchTo().window(janela);
	    }
	    
	    public void executarJS (String comando, Object... parametros) {
	    	JavascriptExecutor js = (JavascriptExecutor) getDriver();
	    	js.executeScript(comando, parametros);
	    }
	    
	    public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela) {
	    	WebElement tabela = getDriver().findElement(By.xpath("//*[@id='"+idTabela+"']"));
	    	int idColuna = obterIndiceColuna(colunaBusca, tabela);
	    	
	    	int idLinha = obterIndiceLinhas(valor, tabela, idColuna);
	    	
	    	int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);
	    	
	    	WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaBotao+"]"));
	    	celula.findElement(By.xpath(".//input")).click();
	    }

		private int obterIndiceLinhas(String valor, WebElement tabela, int idColuna) {
			List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
	    	int idLinha = -1;
	    	for (int i=0; i<linhas.size(); i++) {
	    		if (linhas.get(i).getText().equals(valor)) {
	    			idLinha = i+1;
	    			break;
	    		}
	    	}
	    	return idLinha;
		}

		private int obterIndiceColuna(String coluna, WebElement tabela) {
			List <WebElement> colunas = tabela.findElements(By.xpath(".//th"));
	    	int idColuna = -1;
	    	for (int i=0; i<colunas.size(); i++) {
	    		if (colunas.get(i).getText().equals(coluna)) {
	    			idColuna = i+1;
	    			break;
	    		}
	    	}
	    	return idColuna;
		}
		
		public void aguardarPorId(int segundos, String id) {
			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(segundos));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
		}
		
		public void aguardarPorXpath(int segundos, String xPath) {
			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(segundos));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
		}

}
