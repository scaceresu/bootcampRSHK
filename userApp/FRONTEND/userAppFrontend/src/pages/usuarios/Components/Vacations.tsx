import type { FC } from "react";
import type { VacationsProps } from "../interfaces/Vacations";


const Vacations: FC<VacationsProps> = ({ diasTotales, diasRestantes }) => {
  return (
    <div className="info-section vacations">
      <h2>Vacaciones</h2>
      <div className="vacation-stats">
        <div className="vacation-card total">
          <h3>{diasTotales}</h3>
          <p>Días totales</p>
        </div>
        <div className="vacation-card remaining">
          <h3>{diasRestantes}</h3>
          <p>Días restantes</p>
        </div>
      </div>
    </div>
  );
};

export default Vacations;
