package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

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

}
