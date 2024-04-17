import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import ProfilePage from './pages/ProfilePage.jsx'
import LoginPage from './pages/LoginPage.jsx'
import NavBar from './components/NavBar.jsx'
import RegistrationPage from './pages/RegistrationPage.jsx'
import './index.css'
import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";

const router = createBrowserRouter([
  {
    path: "/",
    element: <div><App/></div>,
  },
  {
    path: "/profile",
    element: <div><ProfilePage/></div>,
  },
  {
    path: "/register",
    element: <div><RegistrationPage/></div>,
  },
  {
    path: "/login",
    element: <div><LoginPage/></div>,
  },
  {
    path: "/forgot_password",
    element: <div><div style={{ textAlign: 'center', borderRadius: '10px', position: 'fixed', top: '0', left: '0', right: '0' }}>
    <NavBar></NavBar>
</div>No Forgot Password Page yet</div>,
  }
]);



ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>,
)
