import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpClientModule } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  private endpoint = 'http://localhost:8080/api/cliente';

  constructor(private http : HttpClient) { }

  consultarCliente(tipoDocumento:String, documento : String){
    return this.http.get(`${this.endpoint}?tipoDocumento=${tipoDocumento}&documento=${documento}`);
  }
}
