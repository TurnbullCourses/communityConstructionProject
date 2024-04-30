import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import ProfilePage from './pages/ProfilePage.jsx'
import LoginPage from './pages/LoginPage.jsx'
import NavBar from './components/NavBar.jsx'
import RegistrationPage from './pages/RegistrationPage.jsx'
import NotFoundPage from './pages/NotFoundPage.jsx'
import ProjectPage from './pages/ProjectPage.jsx'
import CreateProjectPage from './pages/CreateProjectPage.jsx'
import './index.css'
import {
  BrowserRouter,
  createBrowserRouter,
  RouterProvider,
  useRoutes
} from "react-router-dom";
import { initializeApp } from 'firebase/app';
import { getFirestore, collection, getDocs } from 'firebase/firestore/lite';
import { AuthProvider } from './contexts/authContext/index.jsx'



// Your web app's Firebase configuration
const firebaseConfig = {
  apiKey: "AIzaSyDvpP2ASp7wu-X4ILVsSEJyKzPSBRMqoMU",
  authDomain: "constructiontest-4dadf.firebaseapp.com",
  projectId: "constructiontest-4dadf",
  storageBucket: "constructiontest-4dadf.appspot.com",
  messagingSenderId: "497269685832",
  appId: "1:497269685832:web:e5032912fd030a6761e27d"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const db = getFirestore(app);



function MainComponent() {
const router = createBrowserRouter([
  {
    path: "/",
    element: <div><App/></div>,
    errorElement: <div><NotFoundPage/></div>,
  },
  {
    path: "/profile",
    element: <div><ProfilePage/></div>,
    errorElement: <div><NotFoundPage/></div>,
  },
  {
    path: "/register",
    element: <div><RegistrationPage/></div>,
    errorElement: <div><NotFoundPage/></div>,
  },
  {
    path: "/login",
    element: <div><LoginPage/></div>,
    errorElement: <div><NotFoundPage/></div>,
  },
  {
    path: "/forgot_password",
    element: <div><div style={{ textAlign: 'center', borderRadius: '10px', position: 'fixed', top: '0', left: '0', right: '0' }}>
    <NavBar></NavBar>
</div>No Forgot Password Page yet</div>,
    errorElement: <div><NotFoundPage/></div>,
  },
  {
    path: "/project/:id",
    element: <div><ProjectPage/></div>,
    errorElement: <div><NotFoundPage/></div>,
  },
  {
    path: "/create_project",
    element: <div><CreateProjectPage/></div>,
    errorElement: <div><NotFoundPage/></div>,
    
  },
  {
    path: "*",
    element: <div><NotFoundPage/></div>,
  },
]);

return (
  <AuthProvider>
  <React.StrictMode>
      <RouterProvider router={router}>
        <BrowserRouter>
          {router}
        </BrowserRouter>
      </RouterProvider>
  </React.StrictMode>
    </AuthProvider>

);
}



ReactDOM.createRoot(document.getElementById('root')).render(<MainComponent />);


