import React from 'react';
import NavBar from '../components/NavBar'; 
import RegistrationForm from '../components/RegistrationForm'; 

const RegistrationPage = () => {
    return (
        <div>
            <div style={{ textAlign: 'center', borderRadius: '10px', position: 'fixed', top: '0', left: '0', right: '0' }}>
                <NavBar></NavBar>
            </div>
            <RegistrationForm />
        </div>
    );
}

export default RegistrationPage;
