import { useState } from "react";
import type {FC} from "react"
import "./styles/ExpandableList.css";

interface Item {
  title: string;
  content: string;
}

const items: Item[] = [
  { title: "Holdback", content: "Contenido de Holdback" },
  { title: "Financial Assurance", content: "Contenido de Financial Assurance" },
  { title: "Liability Ringfencing", content: "Contenido de Liability Ringfencing" },
  { title: "ARO Creditor Rights", content: "Contenido de ARO Creditor Rights" },
  { title: "Joint and Several Liability", content: "Contenido de Joint Liability" },
  { title: "Colorado", content: "Contenido de Colorado" },
  { title: "ARO Moral Hazard", content: "Contenido de ARO Moral Hazard" }
];

const ExpandableList: FC = () => {
  const [active, setActive] = useState<number | null>(null);

  const toggleItem = (index: number) => {
    setActive(active === index ? null : index);
  };

  return (
    <div className="expandable-list">
      {items.map((item, i) => (
        <div key={i} className="list-item">
          <button className="list-button" onClick={() => toggleItem(i)}>
            {item.title}
            <span className={`arrow ${active === i ? "open" : ""}`}>›</span>
          </button>
          {active === i && <div className="list-content">{item.content}</div>}
        </div>
      ))}
    </div>
  );
};

export default ExpandableList;
