import React from 'react';
import './RegistrationForm.css'; 
import { FaUser, FaEnvelope, FaLock } from 'react-icons/fa';
import { Link } from 'react-router-dom';

const RegistrationForm = () => {
    return (
        <div className="registration-form">
            <h2>Register</h2>
            <form>
                <div className="input-group">
                    <FaUser className="icon" />
                    <input type="username" placeholder="Username" required />
                </div>
                <div className="input-group">
                    <FaEnvelope className="icon" />
                    <input type="email" placeholder="Email" required />
                </div>
                <div className="input-group">
                    <FaLock className="icon" />
                    <input type="password" placeholder="Password" required />
                </div>
                <div className="input-group">
                    <FaLock className="icon" />
                    <input type="password" placeholder="Confirm Password" required />
                </div>
                <button type="submit">Register</button>
            </form>
            <p>Already have an account? <Link to="/login">Login here</Link></p>
        </div>
    );
}

export default RegistrationForm;
