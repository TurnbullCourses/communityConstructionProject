import {react, useState } from 'react';
import './RegistrationForm.css'; 
import { FaUser, FaEnvelope, FaLock } from 'react-icons/fa';
import { Link, useNavigate } from 'react-router-dom';
import { createUserWithEmailAndPassword } from 'firebase/auth';
import { getAuth } from 'firebase/auth';
import { createUserExtraInfo } from '../db';
import { useAuth } from '../contexts/authContext';
import { doCreateUserWithEmailAndPassword, getdisplayName } from '../firebase/auth';

const RegistrationForm = () => {
    const [fullName, setFullName] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [confirmPassword, setConfirmPassword] = useState('');
    const [isRegistering, setIsRegistering] = useState(false);
    const [errorMessage, setErrorMessage] = useState('');


    const {userLoggedIn} = useAuth();
    const auth = getAuth();

    const navigate = useNavigate();

    const handleRegister = async (e) => {
        e.preventDefault();

        if (password !== confirmPassword) {
            alert("Passwords do not match");
            return;
        }
        if (password.length < 6) {
            alert("Password must be at least 6 characters long");
            return;
        }

        try {
            const user = await doCreateUserWithEmailAndPassword(email, password, fullName);
            console.log("user in RegistrationForm: ", user);
            if (user) {
                console.log("User created in Auth:", user.uid);
                createUserExtraInfo(user.uid, 'user', [],user.email); // Create user in Users collection that stores their projects and role that can be changed in firebase console
                //role is set to user by default -- this can be changed by an admin in Firebase console or in the app in the future
                // i had to add the email to the user collection because I could not search by email in firebase auth without cloud function
                console.log("User created in Users collection", user.uid);
                // Redirect to home page
                navigate('/');
                // Alert the user
                alert('You have successfully registered and are now signed in.');
            } else {
                console.error("User creation failed: user is undefined");
            }
        } catch (error) {
            const errorCode = error.code;
            const errorMessage = error.message;
            console.error("Error creating user:", errorCode, errorMessage);
        }
    };

    if (userLoggedIn) {
        navigate('/');
      }

    return (
        <div className="registration-form">
            <h2>Register</h2>
            <form onSubmit={handleRegister}>
                <div className="input-group">
                    <FaUser className="icon" />
                    <input type="text" placeholder="Full Name" required value={fullName} onChange={(e) => setFullName(e.target.value)} />
                </div>
                <div className="input-group">
                    <FaEnvelope className="icon" />
                    <input type="email" placeholder="Email" required value={email} onChange={(e) => setEmail(e.target.value)} />
                </div>
                <div className="input-group">
                    <FaLock className="icon" />
                    <input type="password" placeholder="Password" required value={password} onChange={(e) => setPassword(e.target.value)} />
                </div>
                <div className="input-group">
                    <FaLock className="icon" />
                    <input type="password" placeholder="Confirm Password" required value={confirmPassword} onChange={(e) => setConfirmPassword(e.target.value)} />
                </div>
                <button type="submit">Register</button>
            </form>
            <p>Already have an account? <Link to="/login">Login here</Link></p>
        </div>
    );
}

export default RegistrationForm;
