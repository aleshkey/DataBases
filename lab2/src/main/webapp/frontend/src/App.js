import './App.css';
import React, { useState, useEffect } from 'react';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';
import ReactDOM from "react-dom/client";
import Hall from "./model/Hall";
import Owner from "./model/Owner";
import Author from "./model/Author";
import Exhibition from "./model/Exhibition";
import Image from "./model/Image";


function App() {
    const hall = new Hall();
    const owner = new Owner();
    const author = new Author();
    const image = new Image();
    const exhibition = new Exhibition();
    return (
        <Router>
            <div id='router-root'>
                <h1 className='for-delete'>Modes</h1>
                <hr/>
                <ul className='all-items'>
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
                    <li>
                        <Link to={`/images`} onClick={() => {
                            window.location.href=`/images`
                        }}>Images</Link>
                    </li>
                    <li>
                        <Link to={`/exhibitions`} onClick={() => {
                            window.location.href=`/exhibitions`
                        }}>Exhibitions</Link>
                    </li>
                    <li>
                        <Link to={`/authors`} onClick={() => {
                            window.location.href=`/authors`
                        }}>Authors</Link>
                    </li>
                </ul>
                <Switch>
                    <Route path="/halls" component={()=>{hall.homePage('halls', 'http://localhost:8080/owners')}} />
                    <Route path="/owners" component={ ()=>{owner.homePage('owners', 'http://localhost:8080/owners')}} />
                    <Route path="/authors" component={ ()=>{author.homePage('authors', 'http://localhost:8080/owners')}} />
                    <Route path="/exhibitions" component={ ()=>{exhibition.homePage('exhibitions' , 'http://localhost:8080/images')}} />
                    <Route path="/images" component={ ()=>{image.homePage('images', 'http://localhost:8080/authors')}} />
                </Switch>
            </div>
        </Router>

  );
}

export default App;