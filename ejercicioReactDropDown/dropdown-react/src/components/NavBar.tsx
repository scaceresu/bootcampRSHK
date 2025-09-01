import {useState } from "react";
import type{ FC} from "react";
import "./styles/NavBar.css";

interface NavItem {
  label: string;
  link: string;
}

const navItems: NavItem[] = [
  { label: "Inicio", link: "/" },
  { label: "Acerca", link: "/about" },
  { label: "Servicios", link: "/services" },
  { label: "Contacto", link: "/contact" },
];

const Navbar: FC = () => {
  const [active, setActive] = useState<string>("/");

  const handleClick = (link: string) => {
    setActive(link);
  };

  return (
    <nav className="navbar">
      <div className="navbar-logo">MiMarca</div>
      <ul className="navbar-links">
        {navItems.map((item) => (
          <li
            key={item.link}
            className={active === item.link ? "active" : ""}
            onClick={() => handleClick(item.link)}
          >
            <a href={item.link}>{item.label}</a>
          </li>
        ))}
      </ul>
    </nav>
  );
};

export default Navbar;
