import {React,  useState } from 'react';
import './LoginForm.css';
import { FaUser } from "react-icons/fa";
import { RiLockPasswordFill } from "react-icons/ri";
import { Link, useNavigate } from 'react-router-dom';
import { signInWithEmailAndPassword } from 'firebase/auth';
import { useAuth } from '../contexts/authContext';
import { doSendEmailVerification, doSignInWithEmailAndPassword, doSignInWithGoogle } from '../firebase/auth';
import { auth } from '../firebase/firebase';


const LoginForm = () => {
    const { userLoggedIn } = useAuth();

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();


    const [isSigningIn, setIsSigningIn] = useState(false); // This state variable is used to disable the sign in button while the user is being signed in
    const [errorMessage , setErrorMessage] = useState(''); // This state variable is used to display an error message if the user enters an incorrect email or password


    const onSubmit = async (e) => {
        e.preventDefault();
        if (!isSigningIn) {
            setIsSigningIn(true);
            await doSignInWithEmailAndPassword(email, password).catch((error) => {
                setErrorMessage(error.message);
                setIsSigningIn(false);
            });
            if (auth.currentUser) {
                alert('You have successfully signed in.');
                navigate('/');
            }
           
        }}

    const onGoogleSignIn = (e) => {
        e.preventDefault();
        if (!isSigningIn) {
            setIsSigningIn(true);
            doSignInWithGoogle().catch((error) => {
                setErrorMessage(error.message);
                setIsSigningIn(false);
            });
        }}


    
      
    return (
        <>
        {userLoggedIn && (<navigate to='/' replace={true}/>)}
        <div className='wrap'>
            <form onSubmit={onSubmit}>
                <h1>Login</h1>
                <div className="input-group">
                    <input type="text" placeholder='Email' required value={email} onChange={(e) => setEmail(e.target.value)} />
                    <FaUser className='icon' />
                </div>
                <div className="input-group">
                    <input type="password" placeholder='Password' required value={password} onChange={(e) => setPassword(e.target.value)} />
                    <RiLockPasswordFill className='icon' />
                </div>  
                <p className='error-message' style={{ color: 'red' }}>{errorMessage}</p>
                <button type="submit">Login</button>
                <div className="sign-up">
                    <p> Don't have an account? <Link to="/register">Sign Up</Link></p>
                </div>
            </form>
        </div>
        </>
    );
            
        }
            




export default LoginForm;