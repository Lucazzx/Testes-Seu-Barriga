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
    	MovimentacaoPage movimentacaoPage = new MovimentacaoPage();
    	String dataAtual = movimentacaoPage.getDataAtualFormatada();
        return Arrays.asList(new Object[][]{
            {new String[]{""}, "", "", "", "", "", new String[]{""}, new String[]{""},
            "Data da Movimentação é obrigatório"},
            {new String[]{""}, "DataInvalida", "", "", "", "", new String[]{""}, new String[]{""},
            "Data da Movimentação inválida (DD/MM/YYYY)"},
            {new String[]{""}, "20/09/2099", "", "", "", "", new String[]{""}, new String[]{""},
            "Data da Movimentação deve ser menor ou igual à data atual"},
            {new String[]{""}, dataAtual, "", "", "", "", new String[]{""}, new String[]{""},
            "Data do pagamento é obrigatório"},
            {new String[]{""}, dataAtual, "DataInvalida", "", "", "", new String[]{""}, new String[]{""},
            "Data do pagamento inválida (DD/MM/YYYY)"},
            {new String[]{""}, dataAtual, dataAtual, "", "", "", new String[]{""}, new String[]{""},
            "Descrição é obrigatório"},
            {new String[]{""}, dataAtual, dataAtual, "DescriçãoExemplo", "", "", new String[]{""}, new String[]{""},
            "Interessado é obrigatório"},
            {new String[]{""}, dataAtual, dataAtual, "DescriçãoExemplo", "InteressadoExemplo", "", new String[]{""}, new String[]{""},
            "Valor é obrigatório"},
            {new String[]{""}, dataAtual, dataAtual, "DescriçãoExemplo", "InteressadoExemplo", "TesteValor", new String[]{""}, new String[]{""},
            "Valor deve ser um número"},
            {new String[]{""}, dataAtual, dataAtual, "DescriçãoExemplo", "InteressadoExemplo", "500.25", new String[]{""}, new String[]{""},
            "Movimentação adicionada com sucesso!"},
            {new String[]{"Despesa"}, dataAtual, dataAtual, "DescriçãoExemplo", "InteressadoExemplo", "500.25", new String[]{""}, new String[]{""},
            "Movimentação adicionada com sucesso!"},
            {new String[]{"Despesa"}, dataAtual, dataAtual, "DescriçãoExemplo", "InteressadoExemplo", "500.25", new String[]{"ContaTesteLucas2-Alterada"}, new String[]{""},
            "Movimentação adicionada com sucesso!"},
            {new String[]{"Despesa"}, dataAtual, dataAtual, "DescriçãoExemplo", "InteressadoExemplo", "500.25", new String[]{"ContaTesteLucas2-Alterada"}, new String[]{"Pago"},
            "Movimentação adicionada com sucesso!"}
        });

    }
	
	@Test
	public void testeInserirMovimentacao () {
		MovimentacaoPage movimentacaoPage = new MovimentacaoPage();
		menuPage.acessarTelaCriarMovimentacao();
		
		if (tipo[0].equals("Receita")) movimentacaoPage.setTipoMovimentacaoReceita();
		if (tipo[0].equals("Despesa")) movimentacaoPage.setTipoMovimentacaoDespesa();
		movimentacaoPage.setDataMovimentacao(dataMovimentacao);
		movimentacaoPage.setDataPagamento(dataPagamento);
		movimentacaoPage.setDescricao(descricao);
		movimentacaoPage.setInteressado(interessado);
		movimentacaoPage.setValor(valor);
		if (conta[0].equals("ContaTesteLucas2")) movimentacaoPage.setConta("Conta para movimentacoes");
		if (conta[0].equals("ContaTesteLucas2-Alterada")) movimentacaoPage.setConta("Conta para movimentacoes");
		if (situacao[0].equals("Pago")) movimentacaoPage.setSituacaoPago();
		if (situacao[0].equals("Pendente")) movimentacaoPage.setSituacaoPendente();
		movimentacaoPage.clicarSalvar();	
		assertEquals(mensagem, movimentacaoPage.obterTextoXPathComFallback());	
	}
	

}
