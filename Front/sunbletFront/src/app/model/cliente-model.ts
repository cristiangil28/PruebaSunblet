export class Cliente{
    id:number;
    primerNombre: String;
    segundoNombre:String;
    primerApellido: String;
    segundoApellido: String;
    telefono: String;
    direccion: String;
    ciudadResidencia: String;

    constructor(){
        this.id = 0;
        this.primerApellido = '';
        this.segundoApellido = '';
        this.primerNombre = '';
        this.segundoNombre = '';
        this.telefono = '';
        this.direccion = '';
        this.ciudadResidencia = '';
    }
}