import { React } from 'react';
import NavBar from '../components/NavBar';
import LoginForm from '../components/LoginForm';


function LoginPage(){
    return (
        <div>
            <div style={{ textAlign: 'center', borderRadius: '10px', position: 'fixed', top: '0', left: '0', right: '0' }}>
                <NavBar></NavBar>
            </div>
            <LoginForm />
            
        </div>
    );
}

export default LoginPage;