import React from 'react';
import './styles/Card.css';

// Interfaces para TypeScript
interface CardProps {
  title: string;
  subtitle: string;
  description: string;
  state: string;
  cost: string;
  orphan: string;
  date: string;
}

const Card: React.FC<CardProps> = ({
  title,
  subtitle,
  description,
  state,
  cost,
  orphan,
  date
}) => {
  return (
    <div className="card">
      <div className="card-image">
        {/* Imagen de ejemplo - reemplazar con imagen real */}
        <div className="image-placeholder">Imagen del artículo</div>
      </div>
      
      <div className="card-content">
        <div className="card-header">
          <h3 className="card-subtitle">{subtitle}</h3>
          <h2 className="card-title">{title}</h2>
          <div className="divider"></div>
        </div>
        
        <p className="card-description">{description}</p>
        
        <div className="card-stats">
          <div className="stat-row">
            <div className="stat-header">STATE</div>
            <div className="stat-header">COST</div>
            <div className="stat-header">ORPHAN</div>
          </div>
          <div className="stat-row">
            <div className="stat-value">{state}</div>
            <div className="stat-value">{cost}</div>
            <div className="stat-value">{orphan}</div>
          </div>
          <div className="card-date">{date}</div>
        </div>
        
        <div className="card-links">
          <a href="#" className="card-link">READ REPORT &gt;&gt;</a>
          <a href="#" className="card-link">DOWNLOAD REPORT &gt;&gt;</a>
        </div>
      </div>
    </div>
  );
};

export default Card;