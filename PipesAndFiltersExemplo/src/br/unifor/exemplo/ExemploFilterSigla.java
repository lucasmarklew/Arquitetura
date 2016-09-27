package br.unifor.exemplo;

import java.util.StringTokenizer;

import br.unifor.filter.SimpleFilter;
import br.unifor.pipe.Pipe;

public class ExemploFilterSigla extends SimpleFilter<String, String>{
	
	public ExemploFilterSigla(Pipe<String> input, Pipe<String> output) {
		super(input,output);
	}

	@Override
	protected String transforma(String in) {
		StringTokenizer st = new StringTokenizer(in);
		String out = "";
		while (st.hasMoreTokens()){
			out += st.nextToken().charAt(0);
		}
		
		System.out.println("Filtro: transforma de " + in + " para " + out);
		return out;
	}

}
