import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { FormsModule} from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-consultar-cliente',
  imports: [FormsModule, CommonModule],
  templateUrl: './consultar-cliente.component.html',
  styleUrl: './consultar-cliente.component.css'
})
export class ConsultarClienteComponent {
  tipoDocumento : string = '';
  numeroDocumento : string = '';
  constructor(){

  }
  consultarCliente(){
    alert('entro');
  }
}
