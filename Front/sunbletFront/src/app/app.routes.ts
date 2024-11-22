import { NgModule } from '@angular/core';
import {MatInputModule} from '@angular/material/input';
import { Routes } from '@angular/router';
import { ConsultarClienteComponent } from './component/consultar-cliente/consultar-cliente.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppComponent } from './app.component';

export const routes: Routes = [
    {path: '', component: ConsultarClienteComponent}
];
