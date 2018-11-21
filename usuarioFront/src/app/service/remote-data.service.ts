import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Usuario } from '../models/usuario';
import { Observable } from 'rxjs';




@Injectable({
  providedIn: 'root'
})
export class RemoteDataService {

  constructor(public httpClient: HttpClient) { }

  /*
  * Retorna un Observable con un array de Categoria.
  */
  retornarUsuario(){
    return this.httpClient.get<Array<Usuario>>('http://localhost:8081/usuario');
  }

  devolverUnUsuario(id: number){
    return this.httpClient.get<Usuario>('http://localhost:8081/usuario/'+ id);
  }

  addUsuario(usuario: Usuario): Observable<any>{

    //Establecemos cabeceras
    let headers = new HttpHeaders().set('Content-Type','application/json');

    return this.httpClient.post(' http://localhost:8081/usuario/ ', usuario);
  }

}
