
export interface User {
  id: number;
  nombre: string;
  apellido: string;
  nroCedula: number;
  correo: string;
  idRol: number;
  fechaIngreso: string;
  diasVacaciones: number;
  estado: boolean;
  contrasena: string;
  telefono: string;
  idEquipo: number;
  idCargo: number;
  fechaNacimiento: string;
  requiereCambioContrasena: boolean;
}