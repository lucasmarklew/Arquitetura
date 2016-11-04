import { Injectable } from '@angular/core';
import { Estacionamento } from '../models/estacionamento';
import {Http, Headers, RequestOptions } from '@angular/http';
import 'rxjs/Rx';

@Injectable()
export class EstacionamentoService {

	urlServico: string = "http://localhost:8080/ExemploRest/rest/estacionamento";

    constructor(private http: Http) {

    }

	listar() {
		return this.http.get(this.urlServico).map(res => res.json());     
    }

	cadastrar(estacionamento: Estacionamento) {
	    let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        let body = JSON.stringify(estacionamento);
        return this.http.post(this.urlServico, body, options).map(res => res.text());    
    }

	atualizar(estacionamento: Estacionamento) {
	    let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        let body = JSON.stringify(estacionamento);
        return this.http.put(this.urlServico, body, options).map(res => res.text());    
    }


	excluir(id: number) {
		let url = this.urlServico + '/' + id;
        return this.http.delete(url).map(res => res.text());
	}


	buscarPorId(id: number) {
		return this.http.get(this.urlServico + '/' + id).map(res => res.json());
	}
}