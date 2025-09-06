import type { Cargo } from "../../usuarios/interfaces/Cargo";
import type { Equipo } from "../../usuarios/interfaces/Equipo";
import type { Rol } from "../../usuarios/interfaces/Rol";
import type { UserRegister } from "./UserRegister";

export interface RegisterProps {
  roles: Rol[];
  equipos: Equipo[];
  cargos: Cargo[];
  onSubmit: (user: UserRegister) => Promise<void>;
}