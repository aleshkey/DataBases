import {GetJson} from "../util/Util";
import ReactDOM from "react-dom/client";
import {BrowserRouter as Router, Link, Route, Switch} from "react-router-dom";
import React from "react";
import {getMenu} from "../util/Menu";

export default class Model{
    _helpItem;

    name='';
    createOrUpdatePage= (url) =>{}

    singlePage= ({match}) => {}

    _chooseArgsToShow = (item) => {
        if (this.name === 'HALLS' || this.name === 'OWNERS'){
            return [item.name, item.address];
        }
        if (this.name === 'EXHIBITIONS'){
            return [item.name, item.date];
        }
        if (this.name === 'IMAGES'){
            return [item.name, item.author.name];
        }
        if (this.name === 'AUTHORS'){
            return [item.name, item.placeOfBirth];
        }
    }

    homePage = (uri, helpURL) => {

        this._helpItem = GetJson(helpURL);

        let path = window.location.pathname;
        let data = GetJson("http://localhost:8080" + path);
        let root = ReactDOM.createRoot(document.getElementById('root'));
        if (typeof data.map == "function") {

            let elem = (
                <Router>
                    <div id='router'>
                        <h1 className='for-delete'>{this.name}</h1>
                        <hr/>
                        {getMenu()}
                        <ul className='all-items'>
                            {data && (
                                data.map(item => (
                                    <li key={item.id}>
                                        <Link to={`${path}/${item.id}`} onClick={() => {
                                            window.location.href = `${path}/${item.id}`
                                        }}><a className={'info'}>{this._chooseArgsToShow(item)[0]}</a><a className={'info'}>|</a><a className={'info'}>{this._chooseArgsToShow(item)[1]}</a></Link>
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