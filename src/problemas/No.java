package problemas;

import java.util.ArrayList;
import java.util.Random;

public class No {

	private ArrayList<Integer> posicoesRainhas = new ArrayList<Integer>();
	private int[][] tabuleiro = new int[8][8];
	private int custo;

	public No() {

		Random random = new Random();
			
		for(int i = 0; i < 8; i++) {
			
			posicoesRainhas.add((random.nextInt(8)*10) + i);
		}
		

		
	}
	
	public ArrayList<Integer> getPosicaoRainhas() {
		return posicoesRainhas;
	}
	public void setPosicaoRainhas(int i, int valor) {
		this.posicoesRainhas.set(i, valor);
	}
	public int[][] getTabuleiro() {
		return tabuleiro;
	}
	public void setTabuleiro(int[][] tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
	public int getCusto() {
		return custo;
	}
	public void setCusto(int custo) {
		this.custo = custo;
	}
	
	
	
}
