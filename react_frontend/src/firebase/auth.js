import { auth } from './firebase';
import { createUserWithEmailAndPassword, signInWithEmailAndPassword, sendPasswordResetEmail, sendEmailVerification, updatePassword, signInWithPopup, GoogleAuthProvider, updateProfile } from 'firebase/auth';


export const doCreateUserWithEmailAndPassword = async(email, password, name) => {
    try {
        const userCredential = await createUserWithEmailAndPassword(auth, email, password);
        console.log("got user credential");
        const user = userCredential.user;
        console.log("User created in Auth:", user);
    
        await doSendEmailVerification();
    
        console.log("User sent verify email", user.uid);
        await updateProfile(user, { displayName: name });
        console.log("User updated profile", user.displayName);
        return user;
    } catch (err) {
        console.log(err);
    }
};

export const doSignInWithGoogle = async() => { // This function would be used in the Login page and registration page -- it is called when the user clicks the Google sign in button
    const provider = new GoogleAuthProvider();
    const result = await signInWithPopup(auth, provider);
    const user = result.user;
    s
    return user;
}


export const doSignInWithEmailAndPassword = (email, password) => {
    return signInWithEmailAndPassword(auth, email, password);
};

export const doPasswordReset = async(email) => {
    sendPasswordResetEmail(auth, email);
};

export const doSendEmailVerification = () => {
   return sendEmailVerification(auth.currentUser);

}

export const doPasswordUpdate = (password) => {
    updatePassword(auth.currentUser, password);
};

export const doDisplayNameChange = (name) => {
    updateProfile(auth.currentUser, { displayName: name });
}

export const doSignOut = () => {
    return auth.signOut();
};

export const getdisplayName = () => {
    return auth.currentUser.displayName;
}
