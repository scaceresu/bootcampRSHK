export interface UserRegister {
nroCedula:number;
  nombre: string;
  apellido: string;
  correo: string;
  telefono: string;
  idRol: number | "";
  idEquipo: number | "";
  idCargo: number | "";
  fechaIngreso: string;
  fechaNacimiento: string;
  diasVacaciones: number;
  estado: boolean;
  requiereCambioContrasena: boolean;
  contrasena: string;
}

