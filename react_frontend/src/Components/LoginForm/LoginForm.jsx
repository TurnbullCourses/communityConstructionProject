import React from 'react';
import './LoginForm.css';
import { FaUser } from "react-icons/fa";
import { RiLockPasswordFill } from "react-icons/ri";

const  LoginForm = () => {
    return (
        <div className = 'wrap'>
            <form acion="">
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
                    <a href="#">Forget Password?</a>
                </div>
                <button type="submit">Login</button>
                <div className="sign-up">
                    <p> Don't have an account? <a href="#">Sign Up</a></p>
                </div>
            </form>
        </div>
    )
}
export default LoginForm;