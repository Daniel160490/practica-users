import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from '../models/usuario';
import { interval } from 'rxjs';
import { RemoteDataService } from '../service/remote-data.service';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styles: []
})
export class UsuarioComponent implements OnInit {

  public data: Observable<Array<Usuario>>;
  public cat: Observable<Usuario>;
  public response;

  constructor(public remote: RemoteDataService) { }

  ngOnInit() {

    this.data = this.remote.retornarUsuario();

    this.data.subscribe(arrayData => {

      this.response = arrayData;
      //console.log(arrayData);
    });
  }


  retornarUsuario(id:number){

    this.cat = this.remote.devolverUnUsuario(id);

    /*
    * En console.log se puede pasar tambien arrayData
    * y de ese modo imprime el objeto entero
    * Con err se manejan errores.
    */
    this.cat.subscribe(arrayData =>{
      console.log(arrayData.id);
      console.log(arrayData.nombre);
    },
    err => {
      console.log("Ha ocurrido un error."+ err)
    });
  }

}
