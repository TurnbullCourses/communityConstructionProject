import { initializeApp } from "firebase/app";
import { getAuth } from "firebase/auth";

const firebaseConfig = {
    apiKey: "AIzaSyDvpP2ASp7wu-X4ILVsSEJyKzPSBRMqoMU",
    authDomain: "constructiontest-4dadf.firebaseapp.com",
    projectId: "constructiontest-4dadf",
    storageBucket: "constructiontest-4dadf.appspot.com",
    messagingSenderId: "497269685832",
    appId: "1:497269685832:web:e5032912fd030a6761e27d"
    };

const app = initializeApp(firebaseConfig);
const auth = getAuth(app);

export { app };
export { auth };