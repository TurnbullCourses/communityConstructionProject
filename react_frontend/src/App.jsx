import { useState } from 'react'
import './App.css'
import LandingPage from './landing_page'
import NavBar from './components/NavBar'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <div style={{ textAlign: 'center', borderRadius: '10px', position: 'fixed', top: '0', left: '0', right: '0' }}>
        <NavBar></NavBar>
      </div>
      <LandingPage />

    </>
  )
}

export default App
