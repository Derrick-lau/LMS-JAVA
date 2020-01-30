import React from 'react';
import { Link } from 'react-router-dom';
import { ReactComponent as Logo } from '../../assets/logo.svg';
import './index.scss';
import { Button } from 'react-bootstrap';
import { ISetSignedInProp  } from '../../model/model';


const Header:React.SFC<ISetSignedInProp> = ({setIsSignedIn}) => (
    <header>
        <Logo className='logo'/>
        <nav>
            <Link className='route' to='/'>
                <Button variant="light">
                    Home
                </Button>
            </Link>
            <Link className='route' to='/' onClick = { ()=>{setIsSignedIn(false); window.sessionStorage.clear();} }>
                <Button variant="light">
                    Sign out
                </Button>
            </Link>
        </nav>
    </header>
);
export default Header;
