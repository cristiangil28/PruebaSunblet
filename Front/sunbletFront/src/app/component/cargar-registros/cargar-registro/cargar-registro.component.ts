import { NgFor } from '@angular/common';
import { Component } from '@angular/core';
import { DatosService } from '../../../service/datos/datos.service';

@Component({
  selector: 'app-cargar-registro',
  imports: [NgFor],
  templateUrl: './cargar-registro.component.html',
  styleUrl: './cargar-registro.component.css'
})


export class CargarRegistroComponent {

  data: any[] = [];

  constructor(private dataService: DatosService){

  }
  cargarRegistro(event : Event){
    console.log('valor->'+(event.target as HTMLInputElement).value);
    if((event.target as HTMLInputElement).value != ''){
      const filteredData = this.data.filter(item => 
        Object.values(item).some(value =>
          String(value).toLowerCase().includes((event.target as HTMLInputElement).value.toLowerCase())
        )
      );
      this.data = filteredData;
    }else{
      this.ngOnInit();
    }
    
  }
  ngOnInit(): void {
    this.dataService.getData().subscribe(registros => {
      this.data = registros;
    });
  }
}
