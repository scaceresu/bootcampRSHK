import { useState, type FC } from "react";
import "./styles/MenuHamburguesa.css";
import { menuItems } from "./helpers/ItemsMenu";

const MenuHamburguesa: FC = () => {
  const [activeDropdown, setActiveDropdown] = useState<string | null>(null);
  const [selectedItem, setSelectedItem] = useState<string | null>(null);
  const [selectedSubItem, setSelectedSubItem] = useState<string | null>(null);

  // Función para mostrar/ocultar dropdown
  const toggleDropdown = (item: string) => {
    setActiveDropdown(prev => (prev === item ? null : item));
    setSelectedItem(item);
  };

  // Función para seleccionar un item sin dropdown
  const selectItem = (item: string) => {
    setSelectedItem(item);
    setActiveDropdown(null); 
  };

  const selectSubItem = (subItem: string) => {
    setSelectedSubItem(subItem);
  };


  // 
  return (
    <div className="menu-container">
      <div className="menu">
        {menuItems.map(item => (
          <div
            key={item.label}
            className={`menu-item ${selectedItem === item.label ? "selected" : ""} ${item.dropdown ? "dropdown-toggle" : ""}`}
            onClick={() => item.dropdown ?  toggleDropdown(item.label) : selectItem(item.label)}
          >
            {item.label}
            {item.dropdown && activeDropdown === item.label && (
              <ul className="dropdown">
                {item.dropdown.map(subItem => (
                  <li key={subItem}
                    onClick={ e =>{
                      e.stopPropagation();
                      selectSubItem(subItem);
                    }}
                    className={selectedSubItem === subItem ? "selected" : ""}
                  >{subItem}</li>
                ))}
              </ul>
            )}
          </div>
        ))}
      </div>
    </div>
  );
};

export default MenuHamburguesa;
