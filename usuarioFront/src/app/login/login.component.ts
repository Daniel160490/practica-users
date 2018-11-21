import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Usuario } from '../models/usuario';
import { RemoteDataService } from '../service/remote-data.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styles: []
})
export class LoginComponent implements OnInit {

  //Variable disponible para el HTML
  public user: Usuario;
  public enviado = false;


  constructor(public remote: RemoteDataService) {
    this.user = new Usuario();
  }

  ngOnInit() {
  }


  onSubmit(f: NgForm) {
    this.enviado = true;
    this.remote.addUsuario(this.user).subscribe(
      result => {
        console.log('Respuesta: ' + result);
      },
      error => {
          console.log(<any>error);
      }
  );
    //console.log(this.cat);
  }

}
