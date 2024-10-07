package suites;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import core.DriverFactory;
import pages.LoginPage;
import testes.ContaTeste;
import testes.MovimentacaoTeste;
import testes.ResumoTeste;
import testes.SaldoTeste;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTeste.class,
	MovimentacaoTeste.class,
	ResumoTeste.class,
	SaldoTeste.class,
})
public class SuiteGeral {
	private static LoginPage page = new LoginPage();
	
	@BeforeClass
	public void reset () {
	page.acessarTelaInicial();
	page.logar("lucassousa@email.com", "123");
	page.clickReset();
	
	DriverFactory.killDriver();
	}
}
