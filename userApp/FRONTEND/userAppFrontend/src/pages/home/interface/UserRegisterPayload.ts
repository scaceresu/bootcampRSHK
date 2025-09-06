export interface UserRegisterPayload {
  nroCedula: number;
  nombre: string;
  apellido: string;
  correo: string;
  telefono: string;
  idRol: number | null;
  idEquipo: number | null;
  idCargo: number | null;
  fechaIngreso: string | null;
  fechaNacimiento: string | null;
  diasVacaciones: number | null;
  estado: boolean;
  requiereCambioContrasena: boolean;
  contrasena: string;
}
