import './App.css';
import React, { useState, useEffect } from 'react';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';
import ReactDOM from "react-dom/client";
import Hall from "./model/Hall";
import Owner from "./model/Owner";


function App() {
    const hall = new Hall();
    const owner = new Owner();
    return (
        <Router>
            <div id='router-root'>
                <h1 className='for-delete'>Modes</h1>
                <ul className='for-delete'>
                    <li>
                        <Link to={`/halls`} onClick={() => {
                           window.location.href=`/halls`
                        }}>Halls</Link>
                    </li>
                    <li>
                        <Link to={`/owners`} onClick={() => {
                            window.location.href=`/owners`
                        }}>Owners</Link>
                    </li>
                </ul>
                <Switch>
                    <Route path="/halls" component={()=>{hall.homePage('HALLS', 'halls')}} />
                    <Route path="/owners" component={ ()=>{owner.homePage('OWNERS', 'owners')}} />
                </Switch>
            </div>
        </Router>

  );
}

export default App;