import { HomeTwoTone, EditTwoTone, CheckCircleTwoTone, UserOutlined } from '@ant-design/icons';
import { Menu, Switch } from 'antd';
import { useState } from 'react';
import { Outlet, Link } from 'react-router-dom';



const NavBar = () => {
  const [current, setCurrent] = useState('h');
  let [isLoggedIn, setIsLoggedIn] = useState(true); // Add a state to track login status -- 
  //spoofed for now with checkbox to see both login and profile views
  const [theme, setTheme] = useState('light');

  const onClick = (e) => {
    console.log('click ', e);
    setCurrent(e.key);
  };


 


  const renderAuthLinks = () => {
    if (isLoggedIn) {
      return (
        <Menu.Item style={{ marginLeft: "auto" }} key="u" icon={<UserOutlined />}>
          <Link to="/profile">Profile</Link>
        </Menu.Item>
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
  };

  return (
    <>
      <Menu onClick={onClick} selectedKeys={[current]} mode="horizontal" theme={theme}>
        <Menu.Item key="h" icon={<HomeTwoTone />}>
          <Link to="/">Home</Link>
        </Menu.Item>
        <Switch style={{ marginLeft: "auto" }}
          checkedChildren="Logged In"
          unCheckedChildren="Logged Out"
          defaultChecked
          onChange={(checked) => {
            setIsLoggedIn(checked);
          }}
        >Spoof Login</Switch>
        <Switch style={{ marginLeft: "auto" }}
        checked={theme === 'dark'}
        onChange={(checked) => {setTheme(checked ? 'dark' : 'light');}}
        checkedChildren="Dark"
        unCheckedChildren="Light"
      />
        {renderAuthLinks()} {/* Render the appropriate links based on login status */}
      </Menu>

      <Outlet />
    </>
  );
};

export default NavBar