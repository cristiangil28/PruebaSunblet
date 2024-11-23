import { Component } from '@angular/core';
import { FormsModule} from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ClienteService } from '../../service/cliente/cliente.service';
import { Router } from '@angular/router';
import { Cliente } from '../../model/cliente/cliente';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-consultar-cliente',
  imports: [FormsModule, CommonModule],
  templateUrl: './consultar-cliente.component.html',
  styleUrl: './consultar-cliente.component.css'
})
export class ConsultarClienteComponent {
  tipoDocumento : string = '';
  numeroDocumento : string = '';
  resultado : boolean = false;
  cliente: Cliente = new Cliente();
  constructor(private clienteService: ClienteService,private router: Router){

  }
  consultarCliente(){
    if(this.numeroDocumento == '' || this.tipoDocumento == ''){
      Swal.fire({
        title: 'Error!',
        text: 'Faltan Datos',
        icon: 'error',
        confirmButtonText: 'Ok'
      })
    }
    if(this.numeroDocumento != '' && this.tipoDocumento != ''){
      this.clienteService.consultarCliente(this.tipoDocumento, this.numeroDocumento).subscribe({ next: (data) =>{
        if(data != null){
          const datosJson = JSON.parse(JSON.stringify(data));
          Swal.fire({
            title: 'Correcto',
            text: 'Dato correcto',
            icon: 'success',
            confirmButtonText: 'Ok'
          })
          this.cliente.primerNombre = datosJson.primerNombre;
          this.cliente.segundoNombre = datosJson.segundoNombre;
          this.cliente.primerApellido = datosJson.primerApellido;
          this.cliente.segundoApellido = datosJson.segundoApellido;
          this.cliente.telefono = datosJson.telefono;
          this.cliente.direccion = datosJson.direccion;
          this.cliente.ciudadResidencia = datosJson.ciudadResidencia;
          this.resultado = true;
        }
      },error:(error) =>{ this.resultado = false;
      Swal.fire({
        title: 'Error!',
        text: 'Dato no existe',
        icon: 'error',
        confirmButtonText: 'Ok'
      })}});
    }
  }
}
