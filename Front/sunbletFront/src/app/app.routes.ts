import { Routes } from '@angular/router';
import { ConsultarClienteComponent } from './component/consultar-cliente/consultar-cliente.component';
import { CargarRegistroComponent } from './component/cargar-registros/cargar-registro/cargar-registro.component';

export const routes: Routes = [
    {path: '', component: ConsultarClienteComponent},
    {path : 'cargarRegistros', component: CargarRegistroComponent}
];
