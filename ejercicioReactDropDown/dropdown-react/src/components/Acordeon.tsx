import React, { useState } from 'react';
import './styles/Accordion.css';

// Interface para TypeScript
interface AccordionItem {
  id: number;
  title: string;
  content: string;
  isBold?: boolean;
}

interface AccordionProps {
  items: AccordionItem[];
}

const Accordion: React.FC<AccordionProps> = ({ items }) => {
  const [openItems, setOpenItems] = useState<number[]>([]);

  const toggleItem = (id: number) => {
    setOpenItems(prev => 
      prev.includes(id) 
        ? prev.filter(itemId => itemId !== id) 
        : [...prev, id]
    );
  };

  return (
    <div className="accordion">
      {items.map((item) => (
        <div key={item.id} className="accordion-item">
          <div 
            className={`accordion-header ${openItems.includes(item.id) ? 'active' : ''}`}
            onClick={() => toggleItem(item.id)}
          >
            {item.isBold ? (
              <strong>{item.title}</strong>
            ) : (
              <h3>{item.title}</h3>
            )}
            <span className="accordion-icon">
              {openItems.includes(item.id) ? '−' : '+'}
            </span>
          </div>
          
          <div 
            className={`accordion-content ${openItems.includes(item.id) ? 'open' : ''}`}
          >
            <p>{item.content}</p>
          </div>
        </div>
      ))}
    </div>
  );
};

export default Accordion;