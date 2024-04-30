import { HomeTwoTone, EditTwoTone, CheckCircleTwoTone, UserOutlined, SearchOutlined, LogoutOutlined } from '@ant-design/icons';
import { Menu, Switch, AutoComplete, Button } from 'antd';
import { useState, useEffect } from 'react';
import { Outlet, Link, useNavigate } from 'react-router-dom';
import { getProjects } from '../db';
import { useAuth } from '../contexts/authContext';
import { doSignOut } from '../firebase/auth';
import { auth } from '../firebase/firebase';
import { onAuthStateChanged } from 'firebase/auth';




const NavBar = () => {
  const { userLoggedIn } = useAuth();
  const [options, setOptions] = useState([]); // Add a state to store search options (autocomplete)
  const [current, setCurrent] = useState('h'); // Add a state to track current menu item
  const [theme, setTheme] = useState('light'); // Add a state to track theme -- will need to stored as user preference in future
  
  const navigate = useNavigate();
  

  const renderAuthLinks = () => {
      if (userLoggedIn) {
        return (
          <>
          <Menu.Item style={{ marginLeft: "auto" }} key="create_project" icon={<EditTwoTone /> } onClick={() => navigate("/create_project")}>
        Create Project
      </Menu.Item>
            <Menu.Item style={{ marginLeft: "0" }} key="u" icon={<UserOutlined />}>
              <Link to="/profile">Profile</Link>
            </Menu.Item>
            <Menu.Item 
        style={{ marginLeft: "0" }} 
        key="logout" 
        icon={<LogoutOutlined />}
        onClick={() => { 
          doSignOut().then(() => { 
            navigate('/');
          });
        }}
      >
        Logout
      </Menu.Item>
      
          </>
        );
      } else {
        return (
          <>
            <Menu.Item style={{ marginLeft: "auto" }} key="register" icon={<EditTwoTone />}>
              <Link to="/register">Register</Link>
            </Menu.Item>
            <Menu.Item style={{ marginLeft: "0" }} key="login" icon={<CheckCircleTwoTone />}>
              <Link to="/login">Login</Link>
            </Menu.Item>
          </>
        );  
      }
    
  }



  const onClick = (e) => {
    console.log('click ', e);
    setCurrent(e.key);
    console.log('onClick called');

  };


  const fetchProjects = () => {
    // Make API call to fetch projects
    console.log('fetchProjects called');

    getProjects()
      .then((data) => {
        // Process the data and set the projects state
        const projects = data.map((project) => ({
          id: project.id,
          value: project.name,
        }));
        setOptions(projects);
      })
      .catch((error) => {
        // Handle error
        console.error('Error fetching projects:', error);
      });
  };
 // quota exceeded because I was stupid and made this a UseEffect
 // 100k reads in 2 days lol




 


  
  return (
    <>
      <Menu onClick={onClick} selectedKeys={[current]} mode="horizontal" theme={theme}>
        <Menu.Item key="h" icon={<HomeTwoTone />}>
          <Link to="/">Home</Link>
        </Menu.Item>

        <Switch 
        checked={theme === 'dark'}
        onChange={(checked) => {setTheme(checked ? 'dark' : 'light');}}
        checkedChildren="Dark"
        unCheckedChildren="Light"
      />
      <AutoComplete onClick={fetchProjects} style={{ width: 200, margin:"auto", justifyContent:"center"}}
      options={options}
      onSelect={(value, option) => navigate(`/project/${option.id}`)}
      placeholder=<div style={{textAlign:"left"}}> <SearchOutlined /> Search for Construction </div>
      />
        {renderAuthLinks()} {/* Render the appropriate links based on login status */}
      </Menu>

      <Outlet />
    </>
  );
};

export default NavBar