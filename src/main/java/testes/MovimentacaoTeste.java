package testes;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import core.BaseTeste;
import pages.MenuPage;
import pages.MovimentacaoPage;

@RunWith(Parameterized.class)
public class MovimentacaoTeste extends BaseTeste {
	
	MenuPage menuPage = new MenuPage();
	MovimentacaoPage movimentacaoPage = new MovimentacaoPage();
	
	@Parameter
	public String [] tipo;
	@Parameter(value=1)
	public String dataMovimentacao;
	@Parameter(value=2)
	public String dataPagamento;
	@Parameter(value=3)
	public String descricao;
	@Parameter(value=4)
	public String interessado;
	@Parameter(value=5)
	public String valor;
	@Parameter(value=6)
	public String [] conta;
	@Parameter(value=7)
	public String [] situacao;
	@Parameter(value=8)
	public String mensagem;
	
    @Parameters
    public static Collection<Object[]> getCollection(){
    	return Arrays.asList(new Object[][]{
    		{new String [] {""}, "", "", "", "", "", new String [] {""}, new String [] {""},
    			"Data da Movimenta��o � obrigat�rio"},
    		{new String [] {""}, "DataInvalida", "", "", "", "", new String [] {""}, new String [] {""},
			"Data da Movimenta��o inv�lida (DD/MM/YYYY)"},
    		{new String [] {""}, "20/09/2099", "", "", "", "", new String [] {""}, new String [] {""},
			"Data da Movimenta��o deve ser menor ou igual � data atual"},
    		{new String [] {""}, "20/09/2024", "", "", "", "", new String [] {""}, new String [] {""},
			"Data do pagamento � obrigat�rio"},
    		{new String [] {""}, "20/09/2024", "DataInvalida", "", "", "", new String [] {""}, new String [] {""},
			"Data do pagamento inv�lida (DD/MM/YYYY)"},
    		{new String [] {""}, "20/09/2024", "20/09/2024", "", "", "", new String [] {""}, new String [] {""},
			"Descri��o � obrigat�rio"},
    		{new String [] {""}, "20/09/2024", "20/09/2024", "Descri��oExemplo", "", "", new String [] {""}, new String [] {""},
			"Interessado � obrigat�rio"},
    		{new String [] {""}, "20/09/2024", "20/09/2024", "Descri��oExemplo", "InteressadoExemplo", "", new String [] {""}, new String [] {""},
			"Valor � obrigat�rio"},
    		{new String [] {""}, "20/09/2024", "20/09/2024", "Descri��oExemplo", "InteressadoExemplo", "TesteValor", new String [] {""}, new String [] {""},
			"Valor deve ser um n�mero"},
    		{new String [] {""}, "20/09/2024", "20/09/2024", "Descri��oExemplo", "InteressadoExemplo", "500.25", new String [] {""}, new String [] {""},
			"Movimenta��o adicionada com sucesso!"},
    		{new String [] {"Despesa"}, "20/09/2024", "20/09/2024", "Descri��oExemplo", "InteressadoExemplo", "500.25", new String [] {""}, new String [] {""},
			"Movimenta��o adicionada com sucesso!"},
    		{new String [] {"Despesa"}, "20/09/2024", "20/09/2024", "Descri��oExemplo", "InteressadoExemplo", "500.25", new String [] {"ContaTesteLucas2-Alterada"}, new String [] {""},
			"Movimenta��o adicionada com sucesso!"},
    		{new String [] {"Despesa"}, "20/09/2024", "20/09/2024", "Descri��oExemplo", "InteressadoExemplo", "500.25", new String [] {"ContaTesteLucas2-Alterada"}, new String [] {"Pago"},
			"Movimenta��o adicionada com sucesso!"}, 
    	});
    }
	
	@Test
	public void testeInserirMovimentacao () {
		menuPage.acessarTelaCriarMovimentacao();
		
		if (tipo[0].equals("Receita")) movimentacaoPage.setTipoMovimentacaoReceita();
		if (tipo[0].equals("Despesa")) movimentacaoPage.setTipoMovimentacaoDespesa();
		movimentacaoPage.setDataMovimentacao(dataMovimentacao);
		movimentacaoPage.setDataPagamento(dataPagamento);
		movimentacaoPage.setDescricao(descricao);
		movimentacaoPage.setInteressado(interessado);
		movimentacaoPage.setValor(valor);
		if (conta[0].equals("ContaTesteLucas2")) movimentacaoPage.setConta("ContaTesteLucas2");
		if (conta[0].equals("ContaTesteLucas2-Alterada")) movimentacaoPage.setConta("ContaTesteLucas2-Alterada");
		if (situacao[0].equals("Pago")) movimentacaoPage.setSituacaoPago();
		if (situacao[0].equals("Pendente")) movimentacaoPage.setSituacaoPendente();
		movimentacaoPage.clicarSalvar();	
		assertEquals(mensagem, movimentacaoPage.obterTextoXPathComFallback());
	}
	

}
