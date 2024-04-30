import { React } from 'react';
import NavBar from '../components/NavBar';
import { getUserByID } from '../db';
import { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { onAuthStateChanged } from 'firebase/auth';
import { useNavigate } from 'react-router-dom';
import { auth } from '../firebase/firebase';
import { useAuth } from '../contexts/authContext';
import { getdisplayName, doPasswordUpdate, doDisplayNameChange } from '../firebase/auth';
import { FaLock, FaUser } from "react-icons/fa";

function ProfilePage() {
    const { currentUser } = useAuth();

    const [newPassword, setNewPassword] = useState('');
    const [confirmPassword, setConfirmPassword] = useState('');
    const [newName, setNewName] = useState('');

    console.log("this is the current user: ", currentUser);
    if (!currentUser) {
        console.log('No user is signed in');
        navigate('/login');
    }

    const handlePasswordChange = async (e) => {
        e.preventDefault();
        console.log('Changing password');
        if (newPassword !== confirmPassword) {
            alert("Passwords do not match");
            return;
        }
        if (newPassword.length < 6) {
            alert("Password must be at least 6 characters long");
            return;
        }
        doPasswordUpdate(newPassword);
    }

    const handleNameChange = async (e) => {
        e.preventDefault();
        console.log('Changing name');
        doDisplayNameChange(newName);
    }

    
    const navigate = useNavigate();
    if (currentUser) {
        return (
            <div>
                <div style={{ textAlign: 'center', borderRadius: '10px', position: 'fixed', top: '0', left: '0', right: '0' }}>
                    <NavBar></NavBar>
                </div>
                <h1>Profile Page</h1>
                <p>Name: {getdisplayName()}</p>
                <p>Email: {currentUser.email}</p>
                <form onSubmit={handlePasswordChange}>
                    <h2>Change Password</h2>
                <div className="input-group">
                    <FaLock className="icon" />
                    <input type="password" placeholder="Password" required value={newPassword} onChange={(e) => setNewPassword(e.target.value)} />
                </div>
                <div className="input-group">
                    <FaLock className="icon" />
                    <input type="password" placeholder="Confirm Password" required value={confirmPassword} onChange={(e) => setConfirmPassword(e.target.value)} />
                </div>
                    <button type="submit">Change Password</button>
                </form>

                <form onSubmit={handleNameChange}>
                    <h2>Change Name</h2>
                    <div className="input-group">
                    <FaUser className="icon" />
                    <input type="text" placeholder="Full Name" required value={newName} onChange={(e) => setNewName(e.target.value)} />
                </div>
                    <button type="submit">Change Name</button>
                </form>
            </div>
        );
    } else {
        console.log('No user is signed in');
        navigate('/login');
    }

    
}

export default ProfilePage;