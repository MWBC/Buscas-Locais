package principal;

import java.util.Random;

import Buscas.TemperaSimulada;
import problemas.Problema8Rainhas;

public class Principal {

	public static void main(String[] args) {
	
		TemperaSimulada busca1 = new TemperaSimulada();
		busca1.Busca(new Problema8Rainhas());

	}
}
