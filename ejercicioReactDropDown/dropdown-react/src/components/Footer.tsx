import React from 'react';
import './styles/Footer.css';

const Footer: React.FC = () => {
  return (
    <footer className="footer">
      <div className="footer-content">
        <div className="footer-column">
          <h4>Products</h4>
          <ul>
            <li>ICM</li>
            <li>DME</li>
            <li>CRM</li>
          </ul>
        </div>
        
        <div className="footer-column">
          <h4>Resources</h4>
          <ul>
            <li>Cain Shalen</li>
            <li>MAD</li>
            <li>Mountain</li>
            <li>Buenos Aires</li>
            <li>Cameroon Caldo</li>
          </ul>
        </div>
        
        <div className="footer-column">
          <h4>Company</h4>
          <ul>
            <li>Aloar</li>
            <li>Ou Espera</li>
            <li>Tierra & Constituir</li>
            <li>Salvador a Datos</li>
            <li>Amaro Meloy</li>
          </ul>
        </div>
        
        <div className="footer-column">
          <h4>Contact Us</h4>
        </div>
      </div>
      
      <div className="footer-bottom">
        <p>© 2024. All Rights Reserved.</p>
      </div>
    </footer>
  );
};

export default Footer;