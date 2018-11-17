package problemas;

import java.util.ArrayList;

public class Problema8Rainhas extends Problema{

	public Problema8Rainhas() {
		
		super.no = new No();
		montaNo(no);
		
	}
	
	public void montaNo(No no) {
		
		int[][] tabuleiroAux = new int[8][8];
		preencheComZeros(tabuleiroAux);
		setRainha(no.getPosicaoRainhas(), tabuleiroAux);
		no.setTabuleiro(calculaAtaques(no.getPosicaoRainhas(), tabuleiroAux));
		no.setCusto(calculaCustoAtual(no.getPosicaoRainhas(), no.getTabuleiro()));
	}
	
	@Override
	public int calculaCustoAtual(ArrayList<Integer> posicoesRainhas, int[][] tabuleiro) {
		
		int index = posicoesRainhas.get(0);
		int i = index/10;
		int j = index%10;
		
		return tabuleiro[i][j];
	}
	public int[][] calculaAtaques(ArrayList<Integer> posicoesRainhas, int[][] tabuleiroAux){
		
		int[][] tabuleiro = new int[8][8];
		preencheComZeros(tabuleiro);
		ArrayList<Integer> posicoesRainhaAux = new ArrayList<Integer>();
		int[][] tabuleiroAuxCopy = new int[8][8];
		
		for(int i = 0; i < 8; i++) {
			
			for(int j = 0; j < 8; j++) {
				
				int novaRainha = (i*10) + j;
				
				for(int c = 0; c < posicoesRainhas.size(); c++) {
					
					if((posicoesRainhas.get(c))%10 != j ) {
						
						posicoesRainhaAux.add(posicoesRainhas.get(c));
					}
				}
				
				posicoesRainhaAux.add(novaRainha);
				setRainha(posicoesRainhaAux, tabuleiroAuxCopy);
				ataquesLinha(tabuleiro, posicoesRainhaAux, tabuleiroAuxCopy, i, j);
				ataquesDiagonais(tabuleiro, posicoesRainhaAux, tabuleiroAuxCopy, i, j);
				
				for(int k = 0; k < 8; k++) {
					
					posicoesRainhaAux.remove(0);
				}
			}
			
		}
		
		return tabuleiro;
	}
	
	public void ataquesDiagonais(int[][] tabuleiro, ArrayList<Integer> posicoesRainhas, int[][] tabuleiroAux, int linha, int coluna) {
		
		int atkAux = tabuleiro[linha][coluna];
		int atk = 0;
		
		for(int i = 0; i < 8; i++) {
			
			int indexi = (posicoesRainhas.get(i))/10;
			int indexj = (posicoesRainhas.get(i))%10;
			
			int copyIndexi = indexi;
			int copyIndexj = indexj;
			
			//diagonal principal pra baixo
			while(copyIndexi < 8 && copyIndexj < 8) {
				
				if(copyIndexj != indexj) {
					
					if(tabuleiroAux[copyIndexi][copyIndexj] == 1) {
						
						atk++;
					}
					
				}
				
				copyIndexi++;
				copyIndexj++;
			}
			copyIndexi = indexi;
			copyIndexj = indexj;
			
			//diagonal principal pra cima
			while(copyIndexi >= 0 && copyIndexj >= 0) {
				
				if(copyIndexj != indexj) {
					
					if(tabuleiroAux[copyIndexi][copyIndexj] == 1) {
						
						atk++;
					}
					
				}
				
				copyIndexi--;
				copyIndexj--;
			}
			copyIndexi = indexi;
			copyIndexj = indexj;
			
			//diagonal secundaria pra baixo
			while(copyIndexi < 8 && copyIndexj >= 0) {
				
				if(copyIndexj != indexj) {
					
					if(tabuleiroAux[copyIndexi][copyIndexj] == 1) {
						
						atk++;
					}
					
				}
				
				copyIndexi++;
				copyIndexj--;
			}
			copyIndexi = indexi;
			copyIndexj = indexj;
			
			//diagonal secundaria pra cima
			while(copyIndexi >= 0 && copyIndexj < 8) {
				
				if(copyIndexj != indexj) {
					
					if(tabuleiroAux[copyIndexi][copyIndexj] == 1) {
						
						atk++;
					}
					
				}
				
				copyIndexi--;
				copyIndexj++;
			}
			
		}
		atk = atk/2;
		tabuleiro[linha][coluna] = atk + atkAux;	
	}
	
	public void ataquesLinha(int[][] tabuleiro, ArrayList<Integer> posicoesRainhas, int[][] tabuleiroAux, int linha, int coluna) {
		
		int atk = 0;
		
		for(int i = 0; i < 8; i++) {
		
			int indexi = (posicoesRainhas.get(i))/10;
			int indexj = (posicoesRainhas.get(i))%10;
			
			int copyIndexi = indexi;
			int copyIndexj = indexj;
			
			//elementos a direita da rainha
			while(copyIndexj < 8) {
				
				if(copyIndexj != indexj) {
					
					if(tabuleiroAux[indexi][copyIndexj] == 1) {
						
						atk++;
					}
					
				}
				
				copyIndexj++;
			}
			
			copyIndexj = indexj;
			
			//elementos a esquerda da rainha
			while(copyIndexj >= 0) {
				
				if(copyIndexj != indexj) {
					
					if(tabuleiroAux[indexi][copyIndexj] == 1) {
						
						atk++;
					}
					
				}
				
				copyIndexj--;
			}
		}
		
		atk = atk/2;
		tabuleiro[linha][coluna] = atk;
	}
	
	public void setRainha(ArrayList<Integer> posicoesRainhas, int[][] tabuleiro) {
		preencheComZeros(tabuleiro);
		int i, j;
		
		for(int x = 0; x < posicoesRainhas.size(); x ++) {
			
			i = (posicoesRainhas.get(x))/10;
			j = (posicoesRainhas.get(x))%10;
			tabuleiro[i][j] = 1;
		}
	}
	
	public void preencheComZeros(int[][] tabuleiro) {
		
		for(int i = 0; i < 8; i++) {
			
			for(int j = 0; j < 8; j++) {
				
				tabuleiro[i][j] = 0;
			}
			
		}
	}
	
	public No copiaArray(ArrayList<Integer> posicaoRainhas) {
		
		No no = new No();
		
		for(int i = 0; i < posicaoRainhas.size(); i++) {
			
			no.getPosicaoRainhas().set(i, posicaoRainhas.get(i));
		}
		
		return no;
	}

public void imprimeTabuleiro(No no) {
	

	System.out.println("------------------------------------------------------------");
	
	for (int i = 0; i < 8; i++) {
		
		for (int j = 0; j < 8; j++) {
			if (no.getPosicaoRainhas().contains((i*10) + j)) {
				
				System.out.print("[R]\t");
			
			}else {
				
				System.out.print( 0 + "\t");
			}
				
		}
		System.out.println("\n");
		
	}
	
	System.out.println("Custo: " + no.getCusto());
	System.out.println("------------------------------------------------------------");
}
	
}
