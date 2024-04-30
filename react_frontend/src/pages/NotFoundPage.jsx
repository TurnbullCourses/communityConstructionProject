import { React } from 'react';
import NavBar from '../components/NavBar';
import NotFoundAnimation from '../assets/404Animation.svg';
import { useRouteError } from "react-router-dom";


function NotFoundPage(){
    return (
        <div>
            <div style={{ textAlign: 'center', borderRadius: '10px', position: 'fixed', top: '0', left: '0', right: '0' }}>
                <NavBar></NavBar>
            </div>
            <img src={NotFoundAnimation} />
            <h1>404: Page Not Found</h1>
        </div>
    );
}

export default NotFoundPage;
