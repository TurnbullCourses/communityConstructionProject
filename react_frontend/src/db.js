import { getFirestore, collection, getDocs, setDoc } from 'firebase/firestore/lite';
import { app } from './firebase/firebase';
import { doc, getDoc } from 'firebase/firestore/lite';
import { query, where, updateDoc } from 'firebase/firestore/lite';
import { Timestamp } from 'firebase/firestore';



// Initialize Firestore DB using app from Firebase
const db = getFirestore(app);



export async function getProjects() {
    const collectionRef = collection(db, 'Projects');
    const snapshot = await getDocs(collectionRef);
    let projects = [];
    snapshot.forEach((doc) => {
      projects.push({ id: doc.id, ...doc.data() });
    });
    console.log(projects);
    return projects;
  }

export async function getProjectById(id) {
    const docRef = doc(db, 'Projects', id);
    const docSnap = await getDoc(docRef);
    console.log(docSnap);
  
    if (docSnap.exists()) {
        console.log('Document data:', docSnap.data());
      return docSnap.data();
    } else {
      console.log('No such Project!');
      return null;
    }
}


export async function getUserByID(id) {
    const docRef = doc(db, 'Users', id);
    const docSnap = await getDoc(docRef);
  
    if (docSnap.exists()) {
      return docSnap.data();
    } else {
      console.log('No such User!');
      return null;
    }
}

export async function createUserExtraInfo(user_id, role, projects, email) { 
    //creates a new document in the Users collection with the user's role, projects, and full name -- this cant be stored in firebase Auth
    const docRef = doc(db, 'Users', user_id); 
    await setDoc(docRef, {
      id: user_id,
      role: role,
      projects: projects,
      email: email
    });
}

export async function inviteUsersToProject(emails, projectId) {
    const projectRef = doc(db, 'Projects', projectId);
    const projectSnap = await getDoc(projectRef);

    if (!projectSnap.exists()) {
        console.log('No such project!');
        return;
    }

    let projectData = projectSnap.data();
    let clientIds = projectData.clients || [];

    for (let email of emails) {
        const userSnap = await getDocs(query(collection(db, 'Users'), where('email', '==', email)));

        userSnap.forEach(doc => {
            clientIds.push(doc.id);
        });
    }

    await updateDoc(projectRef, {
        clients: clientIds
    });
    console.log('Users invited to project');
}

export async function getProjectCreatorId(project_id) {
    // returns the user_id of the creator of the project
    const docRef = doc(db, 'Projects', project_id);
    const docSnap = await getDoc(docRef);
  
    if (docSnap.exists()) {
      return docSnap.data().creator_id;
    } else {
      console.log('No such Document!');
      return null;
    }
}

export function authorize_user(user_id, project_id) {
    //used to determine if a user has access to a project
    // returns true if user has access, false otherwise

    // Get user role
    var user_role = get_user_role(user_id);

    // Check if user is Admin
    if (user_role === "Admin") {
        return true;
    }

    // Get project creator ID
    var project_creator_id = getProjectCreatorId(project_id);

    // Check if user is project creator
    if (user_id === project_creator_id) {
        return true;
    }

    // Check if user is assigned as a client on the project
    var is_client = is_user_project_client(user_id, project_id);


    // Grant or deny access based on checks
    if (is_client){
        return true;
    }
    else{
        return false;
    }
}

export async function create_project(name, creator_id, clients_email, address, completion_date, operating_hours_start, operating_hours_end, price) {
    //creates a new project in the Projects collection
    const docRef = doc(collection(db, 'Projects'));
    await setDoc(docRef, {
      name: name,
      creator_id: creator_id,
      clients: [],
      address: address,
      completion_date: completion_date,
      operating_hours_start: operating_hours_start,
      operating_hours_end: operating_hours_end,
      price: price,
      id: docRef.id
    });
    inviteUsersToProject(clients_email, docRef.id);
} 

async function get_user_role(user_id) {
    //returns the role of the user -- either "Admin" or "Member"
    const collectionRef = collection(db, 'Users', user_id);
    const snapshot = await getDocs(collectionRef);
    const user_role = snapshot.data().role;
    return user_role;
}


async function is_user_project_client(user_id, project_id) {
    //returns true if user is a client on the project, false otherwise
    const collectionRef = collection(db, 'Projects', project_id)
    const snapshot = await getDocs(collectionRef);
    const project = snapshot.data();
    const clients = project.clients;
    return clients.includes(user_id);
}

