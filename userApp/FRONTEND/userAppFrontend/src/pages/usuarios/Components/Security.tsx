import type { FC } from "react";
import type { SecurityProps } from "../interfaces/Security";


const Security: FC<SecurityProps> = ({ requiereCambioContrasena, onChangePassword }) => {
  return (
    <div className="info-section security">
      <h2>Seguridad</h2>
      <div className={`security-status ${requiereCambioContrasena ? 'warning' : 'secure'}`}>
        <div className="status-icon">
          {requiereCambioContrasena ? '⚠️' : '✅'}
        </div>
        <div className="status-content">
          <h3>{requiereCambioContrasena ? "Sí" : "No"}</h3>
          <p>Requiere cambio de contraseña</p>
        </div>
        {requiereCambioContrasena && (
          <button className="change-password-btn" onClick={onChangePassword}>
            Cambiar ahora
          </button>
        )}
      </div>
    </div>
  );
};

export default Security;
