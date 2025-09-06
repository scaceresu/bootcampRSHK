import type { FC } from "react";
import type { MainInfoProps } from "../interfaces/MainInfo";

const MainInfo: FC<MainInfoProps> = ({ nroCedula, rolNombre, equipoNombre, cargoNombre }) => {
  return (
    <div className="info-section main-info">
      <h2>Información Principal</h2>
      <div className="info-cards">
        <div className="info-card">
          <div className="card-icon">🆔</div>
          <div className="card-content">
            <h3>{nroCedula}</h3>
            <p>Nro. Cédula</p>
          </div>
        </div>

        <div className="info-card">
          <div className="card-icon">👤</div>
          <div className="card-content">
            <h3>{rolNombre}</h3>
            <p>Rol</p>
          </div>
        </div>

        <div className="info-card">
          <div className="card-icon">👥</div>
          <div className="card-content">
            <h3>{equipoNombre}</h3>
            <p>Equipo</p>
          </div>
        </div>

        <div className="info-card">
          <div className="card-icon">💼</div>
          <div className="card-content">
            <h3>{cargoNombre}</h3>
            <p>Cargo</p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default MainInfo;
