package br.unifor.exemplo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.unifor.datasource.DataSource;
import br.unifor.pipe.Pipe;

public class ExemploDataSource extends DataSource<String> {
	
	private List<String> listaEntradas = new ArrayList<String>(Arrays.asList("Single Page Application","Java Persistence API","Enterprise Java Beans"));
	
    public ExemploDataSource(Pipe<String> output) {
        super(output);
    }

    @Override
    public void gerarDados(Pipe<String> pipe) {
        for (String string : listaEntradas) {	
            pipe.insere(string);
            System.out.println("DataSource gerou: " + string);            
            delayForDebug(200);
        }
        pipe.fecha();
        System.out.println("Datasource finalizado");
    }
}