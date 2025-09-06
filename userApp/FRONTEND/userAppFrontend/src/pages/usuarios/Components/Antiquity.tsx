import type { FC } from "react";
import type { AntiquityProps } from "../interfaces/Antiquity";



const Antiquity: FC<AntiquityProps> = ({ antiguedad }) => {
  return (
    <div className="info-section antiquity">
      <h2>Antigüedad en la empresa</h2>
      <div className="antiquity-display">
        <div className="time-segment">
          <span className="time-value">{antiguedad || 0}</span>
        </div>
      </div>
    </div>
  );
};

export default Antiquity;
