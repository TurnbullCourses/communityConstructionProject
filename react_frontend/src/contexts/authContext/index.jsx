import React, { useContext, createContext, useState, useEffect } from 'react';
import { auth } from '../../firebase/firebase';
import { onAuthStateChanged } from 'firebase/auth'; 


const AuthContext = createContext();

export function useAuth() {
    const context = useContext(AuthContext);
    if (context === undefined) {
        throw new Error('useAuth must be used within an AuthProvider');
      }
    return context;
}

export function AuthProvider({ children }) {
    const [currentUser, setCurrentUser] = useState(null);
    const [userLoggedIn, setUserLoggedIn] = useState(false);
    const [isEmailUser, setIsEmailUser] = useState(false);
    const [isGoogleUser, setIsGoogleUser] = useState(false);
    const [loading, setLoading] = useState(true);


    useEffect(() => {
        const unsubscribe = onAuthStateChanged(auth, initializeUser);
        return unsubscribe;
    }, []);

    async function initializeUser(user) {
        if (user) {
            setCurrentUser({ ...user });
            const isEmail = user.providerData.some(
                (provider) => provider.providerId === 'password'
            );  
            setIsEmailUser(isEmail);
            const isGoogle = user.providerData.some(
                (provider) => provider.providerId === 'google.com'
            );
            setIsGoogleUser(isGoogle);
            setUserLoggedIn(true);
            console.log("User is signed in", user.uid);
        }
        else {
            setCurrentUser(null);
            setUserLoggedIn(false);
            console.log("No user is signed in - in Context");
        }

        setLoading(false);
    }

    const value = {
        userLoggedIn,
        currentUser,
        isEmailUser,
        isGoogleUser,
        setCurrentUser
    };

    console.log("CurrentUser variable in AuthContext: ", currentUser);

    return (
        <AuthContext.Provider value={value}>
            {!loading && children}
        </AuthContext.Provider>
    );
}