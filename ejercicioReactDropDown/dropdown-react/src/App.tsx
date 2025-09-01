// import './App.css'
import Accordion from './components/Acordeon'
import Buttons from './components/Buttons'
import Card from './components/Card'
import ExpandableList from './components/ExpandableList'
import Footer from './components/Footer'
import { accordionItems } from './components/helpers/AccordeonItems'
import MenuHamburguesa from './components/MenuHamburguesa'
import Navbar from './components/NavBar'

function App() {

  return (
    <>
    <h1>Header</h1>
      <Navbar/>
      <h1>Dropdown</h1>
      <MenuHamburguesa/> 
      <h1>Buttons</h1>
      <Buttons/>
      <h1>Expandable</h1>
      <ExpandableList/>
      <h1>Acordeon</h1>
      <Accordion items={accordionItems}/>

      <h1>Card</h1>
      <Card
        title="It's Closing Time: The Huge Bill to Abandon Oilfields Comes Early"
        subtitle="It's Closing Time"
        description="Billion Dollar Orphans estimate that plugging 2.6 million documented onshore wells in the U.S. alone will cost $280 billion. This estimate excludes costs to plug an additional estimated 1.2 million undocumented onshore wells."
        state="4. ago 2022"
        cost=""
        orphan=""
        date=""
      />
      <h1>Footer</h1>
      <Footer/>
    </> 
  )
}

export default App
