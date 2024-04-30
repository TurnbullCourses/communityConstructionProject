import React, { useState } from 'react';
import { DatePicker } from 'antd';
import NavBar from '../components/NavBar';
import { create_project, inviteUsersToProject } from '../db';
import { useAuth } from '../contexts/authContext';
import { Timestamp } from 'firebase/firestore';



const CreateProjectPage = () => {
    const { currentUser } = useAuth();
    const [name, setName] = useState('');
    const [address, setAddress] = useState('');
    const [price, setPrice] = useState('');

    
    const [client_emails, setClientEmails] = useState([]);
    const [email, setEmail] = useState('');
    const [selectedRange, setSelectedRange] = useState(null);

    const [completion_timestamp, setCompletionTimestamp] = useState(null);
    const [completion_date, setCompletionDate] = useState(null);
    
    const [operating_hours_start, setOperatingHoursStart] = useState(null);
    const [operating_hours_end, setOperatingHoursEnd] = useState(null);


    const { RangePicker } = DatePicker;

    const [value, setValue] = useState(null);
    const disabledDate = (current, { from }) => {
        if (from) {
            return Math.abs(current.diff(from, 'days')) >= 7;
        }
        return false;
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        console.log('Creating project');
        console.log(client_emails);


        console.log("completion date: " ,completion_date);
        console.log("operating hours start: " ,operating_hours_start);
        console.log("operating hours end: " ,operating_hours_end);

        const completion_timestamp = Timestamp.fromDate(completion_date.toDate());
        const operating_hours_start_timestamp = Timestamp.fromDate(operating_hours_start.toDate());
        const operating_hours_end_timestamp = Timestamp.fromDate(operating_hours_end.toDate());
        const project = {
            name: name,
            address: address,
            price: price,
            creator_id: currentUser.uid,
            clients: [],
            completion_date: completion_timestamp,
            operating_hours_start: operating_hours_start_timestamp,
            operating_hours_end: operating_hours_end_timestamp,
            creation_date: Timestamp.now()
        };

        create_project(project);
        inviteUsersToProject(client_emails, project.id);
        console.log(project);
        // Add code to create the project in the database

    }

    const addClient = (e) => {
        e.preventDefault();
        setClientEmails([...client_emails, email]);
        setEmail('');
    }






    return (
        <>
        <div>
            <div style={{ textAlign: 'center', borderRadius: '10px', position: 'fixed', top: '0', left: '0', right: '0' }}>
                <NavBar></NavBar>
            </div>
        <h1>Create Project</h1>
        <p>Fill out the form below to create a new project</p>
        <p>Select clients from the dropdown list</p>
        <p>Make sure to select a completion date</p>
        <p>Make sure to select operating hours: the day of week and time you pick to start/end will determine work days and hours</p>
        <form onSubmit={handleSubmit}>
            <input type="text" value={name} onChange={e => setName(e.target.value)} placeholder="Name" required />
            <input type="text" value={address} onChange={e => setAddress(e.target.value)} placeholder="Address" required />
            <input type="number" value={price} onChange={e => setPrice(e.target.value)} placeholder="Price" required />
            <div>
                <input type="text" value={email} onChange={e => setEmail(e.target.value)} placeholder="Client Email"  />
                <button type="submit" onClick={addClient}>Add Client</button>
            </div>
            <div></div>
            <RangePicker showTime value={value} disabledDate={disabledDate} onChange={setValue} required/>;
            <DatePicker value={completion_date} onChange={setCompletionDate} required/>
            <button type="submit">Create Project</button>
        </form>
        </div>
        </>
    );
}

export default CreateProjectPage;
