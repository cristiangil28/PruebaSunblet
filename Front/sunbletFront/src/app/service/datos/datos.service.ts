import { Injectable } from '@angular/core';
import { Observable,of } from 'rxjs';
import { DATA } from '../../model/datosJson/datos';

@Injectable({
  providedIn: 'root'
})
export class DatosService {

  constructor() { }

  getData():Observable<any[]>{
    return of(DATA);
  }
}
