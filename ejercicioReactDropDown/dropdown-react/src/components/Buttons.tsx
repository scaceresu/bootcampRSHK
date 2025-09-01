import type { FC } from "react";
import "./styles/Buttons.css";

const Buttons: FC = () => {
  return (
    <div className="buttons-container">
      {/* Botones normales */}
      <button className="btn primary">LABEL</button>
      <button className="btn primary">LABEL</button>
      <button className="btn primary disabled" disabled>LABEL</button>

      {/* Botones con íconos a la izquierda */}
      <button className="btn primary">+ LABEL</button>
      <button className="btn primary">+ LABEL</button>
      <button className="btn primary disabled" disabled>+ LABEL</button>

      {/* Botones con íconos a la derecha */}
      <button className="btn primary">LABEL +</button>
      <button className="btn primary">LABEL +</button>
      <button className="btn primary disabled" disabled>LABEL +</button>

      {/* Botones outlined */}
      <button className="btn outlined">LABEL</button>
      <button className="btn outlined">+ LABEL</button>
      <button className="btn outlined">LABEL +</button>

      {/* Botones tipo texto */}
      <div className="text-buttons">
        <button className="btn text">LABEL</button>
        <button className="btn text underline">LABEL</button>
        <button className="btn text">+ LABEL</button>
        <button className="btn text">LABEL +</button>
      </div>
    </div>
  );
};

export default Buttons;
