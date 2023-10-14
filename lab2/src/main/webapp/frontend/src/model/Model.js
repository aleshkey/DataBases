import {GetJson} from "../util/Util";
import ReactDOM from "react-dom/client";
import {BrowserRouter as Router, Link, Route, Switch} from "react-router-dom";
import React from "react";

export default class Model{
    createOrUpdatePage= (url) =>{}
    singlePage= ({match}) => {}
    homePage = (name, uri) => {
        let path = window.location.pathname;
        let data = GetJson("http://localhost:8080" + path);
        data.map(item => (console.log(item[1])));
        let root = ReactDOM.createRoot(document.getElementById('root'));
        if (typeof data.map == "function") {
            let elem = (
                <Router>
                    <div id='router'>
                        <h1 className='for-delete'>{name}</h1>
                        <ul className='for-delete'>
                            {data && (
                                data.map(item => (
                                    <li key={item.id}>
                                        <Link to={`${path}/${item.id}`} onClick={() => {
                                            window.location.href = `${path}/${item.id}`
                                        }}>{item.name} : {item.address}</Link>
                                    </li>
                                )))}
                        </ul>
                        <button className='for-delete' onClick={() => {
                            this.createOrUpdatePage('http://localhost:8080' + path);
                        }}>CREATE
                        </button>
                        <button className='for-delete' onClick={() => {
                            window.location.href = `/`
                        }}>BACK
                        </button>
                        <Switch>
                            <Route path={`/${uri}/:id`} component={this.singlePage}/>
                        </Switch>
                    </div>
                </Router>
            );
            root.render(elem);
        }
    }
}