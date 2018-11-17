package Buscas;

import java.util.ArrayList;
import java.util.Random;

import problemas.No;
import problemas.Problema8Rainhas;

public class TemperaSimulada {

	long tempoInicio = System.currentTimeMillis();
	
	public void Busca(Problema8Rainhas problema) {
		
		Random rand = new Random();
		double temperatura;
		No noAtual = problema.getNo();
		No vizinho = new No();
		System.out.println("--------------------TABULEIRO INICIAL-----------------------");
		problema.imprimeTabuleiro(noAtual);
		
		for(double tempo = 0; tempo < 10000; tempo+= 0.03) {
			
			if(problema.calculaCustoAtual(noAtual.getPosicaoRainhas(), noAtual.getTabuleiro()) == 0) {
				
				System.out.println("--------------------TABULEIRO FINAL-------------------------");
				problema.imprimeTabuleiro(noAtual);
				
				System.out.println("Tempo total da Têmpera Simulada " + (System.currentTimeMillis() - tempoInicio) + "ms");
				System.out.println();
				
				return;
				
			}
			//teste
			temperatura = 1/x;
			vizinho = problema.copiaArray(noAtual.getPosicaoRainhas());
			int coluna = rand.nextInt(8);
			vizinho.setPosicaoRainhas(coluna, (rand.nextInt(8)*10) + coluna);
			problema.montaNo(vizinho);
			
			delta = problema.calculaCustoAtual(vizinho.getPosicaoRainhas(), vizinho.getTabuleiro()) - problema.calculaCustoAtual(noAtual.getPosicaoRainhas(), noAtual.getTabuleiro());

			
			if(delta <= 0) {
				
				noAtual = vizinho;
				
			}else if(rand.nextDouble() < 1/Math.exp(delta / temperatura)){
				
				noAtual = vizinho;
			}
		}
	
		System.out.println("Tempo total da Têmpera Simulada " + (System.currentTimeMillis() - tempoInicio) + "ms");
		System.out.println();
	}
	
}
