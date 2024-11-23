import { Component } from '@angular/core';
import { FormsModule} from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ClienteService } from '../../service/cliente/cliente.service';

@Component({
  selector: 'app-consultar-cliente',
  imports: [FormsModule, CommonModule],
  templateUrl: './consultar-cliente.component.html',
  styleUrl: './consultar-cliente.component.css'
})
export class ConsultarClienteComponent {
  tipoDocumento : string = '';
  numeroDocumento : string = '';
  constructor(private clienteService: ClienteService){

  }
  consultarCliente(){
    if(this.numeroDocumento != '' && this.tipoDocumento != ''){
      this.clienteService.consultarCliente(this.tipoDocumento, this.numeroDocumento).subscribe(data =>{
        if(data != null){
          console.log(data);
        }
      });
    }
  }
}
