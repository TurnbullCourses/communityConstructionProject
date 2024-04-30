import React from 'react';
import NavBar from '../components/NavBar';
import { getProjects, getProjectById } from '../db';
import { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';




const ProjectPage = () => {
    const { id } = useParams();
    const [project, setProject] = useState(null);    
    // Just a dummy project object -- this would be replaced with a real project object
    const dummy_project = {
        name: 'Example Project Name',
        id: 0,
        price: 100000,
        creation_date: new Date(), //Date
        completion_date: new Date("2024-08-10"), //Date
        operatingHoursStart: "8:00", //LocalTime
        operatingHoursEnd: "17:00" //LocalTime
    };

    useEffect(() => {
        const fetchProject = async () => {
          const projectData = await getProjectById(id);
          setProject(projectData);
        };
    
        fetchProject();
      }, [id]);
    
      if (!project) {
        return <div>Loading...</div>;
      }

 //if given the project as JSON with no methods
    return (
        <div>
            <div style={{ textAlign: 'center', borderRadius: '10px', position: 'fixed', top: '0', left: '0', right: '0' }}>
                <NavBar></NavBar>
            </div>
            <h1>{project.name}</h1>
            <p>Price: {project.price}</p>
            <p>Creation Date: {project.creation_date ? project.creation_date.toDate().toLocaleDateString() : 'N/A'}</p>
            <p>Completion Date: {project.completion_date ? project.completion_date.toDate().toLocaleDateString() : 'N/A'}</p>
            <p>Operating Hours: {project.operatingHoursStart ? project.operatingHoursStart.toDate().toLocaleDateString() : 'N/A'} -- {project.operatingHoursEnd ? project.operatingHoursEnd.toDate().toLocaleDateString() : 'N/A'}</p>
    </div>
    );
};


export default ProjectPage;
