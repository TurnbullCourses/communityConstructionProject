import { React } from 'react';
import NavBar from '../components/NavBar';

function ProfilePage(){
    return (
        <div>
            <div style={{ textAlign: 'center', borderRadius: '10px', position: 'fixed', top: '0', left: '0', right: '0' }}>
                <NavBar></NavBar>
            </div>
            <h1>Profile Page</h1>
        </div>
    );
}

export default ProfilePage;