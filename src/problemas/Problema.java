package problemas;

import java.util.ArrayList;

public abstract class Problema {

	No no;
	
	public abstract int calculaCustoAtual(ArrayList<Integer> posicoesRainhas, int[][] tabuleiro);
	
	public No getNo(){
		
		return no;
	}


}
