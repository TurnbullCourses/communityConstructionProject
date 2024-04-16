import React from 'react';
import './LoginForm.css';
import { FaUser } from "react-icons/fa";
import { RiLockPasswordFill } from "react-icons/ri";
import { Link } from 'react-router-dom';

const  LoginForm = () => {
    return (
        <div className = 'wrap'>
            <form action="">
                <h1>Login</h1>
                <div className="input-group">
                    <input type="text" placeholder='Username' required />
                    <FaUser className='icon'/>
                </div>
                <div className="input-group">
                    <input type="password" placeholder='Password' required />
                    <RiLockPasswordFill className='icon'/>
                </div>
                <div className="remember-forget">
                    <label>
                        <input type="checkbox"/> Remember Me
                    </label>
                    <Link to="/forgot_password">Forgot Password?</Link>
                </div>
                <button type="submit">Login</button>
                <div className="sign-up">
                    <p> Don't have an account? <Link to="/register">Sign Up</Link></p>
                </div>
            </form>
        </div>
    )
}
export default LoginForm;