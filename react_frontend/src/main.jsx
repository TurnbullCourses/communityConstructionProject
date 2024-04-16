import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import ProfilePage from './pages/ProfilePage.jsx'
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
    element: <div>No Register Page yet</div>,
  },
  {
    path: "/login",
    element: <div>No Login Page Yet</div>,
  },
]);



ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>,
)
