"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require('@angular/core');
var http_1 = require('@angular/http');
require('rxjs/Rx');
var DepartamentoService = (function () {
    function DepartamentoService(http) {
        this.http = http;
        this.urlServico = "http://localhost:8080/ExemploRest/rest/departamento";
    }
    DepartamentoService.prototype.listar = function () {
        return this.http.get(this.urlServico).map(function (res) { return res.json(); });
    };
    DepartamentoService.prototype.cadastrar = function (departamento) {
        var headers = new http_1.Headers({ 'Content-Type': 'application/json' });
        var options = new http_1.RequestOptions({ headers: headers });
        var body = JSON.stringify(departamento);
        return this.http.post(this.urlServico, body, options).map(function (res) { return res.text(); });
    };
    DepartamentoService.prototype.atualizar = function (departamento) {
        var headers = new http_1.Headers({ 'Content-Type': 'application/json' });
        var options = new http_1.RequestOptions({ headers: headers });
        var body = JSON.stringify(departamento);
        return this.http.put(this.urlServico, body, options).map(function (res) { return res.text(); });
    };
    DepartamentoService.prototype.excluir = function (id) {
        var url = this.urlServico + '/' + id;
        return this.http.delete(url).map(function (res) { return res.text(); });
    };
    DepartamentoService.prototype.buscarPorId = function (id) {
        return this.http.get(this.urlServico + '/' + id).map(function (res) { return res.json(); });
    };
    DepartamentoService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [http_1.Http])
    ], DepartamentoService);
    return DepartamentoService;
}());
exports.DepartamentoService = DepartamentoService;
//# sourceMappingURL=departamento-service.js.map