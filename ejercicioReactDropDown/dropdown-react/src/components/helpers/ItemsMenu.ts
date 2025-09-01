import type { MenuItem } from "../types/MenuItem";

export const menuItems: MenuItem[] = [
  { label: "Data Portal" },
  { label: "Contact"},
  { label: "About"},
  { 
    label: "Home",
    dropdown: [
      "Investigator or regulator",
      "First things to know",
      "Critical inflection point",
      "Uneven Distribution",
      "Risk may filter up"
    ]
  },
];