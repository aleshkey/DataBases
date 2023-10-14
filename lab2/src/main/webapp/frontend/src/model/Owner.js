import Model from "./Model";
import {GetJson} from "../util/Util";
import ReactDOM from "react-dom/client";
import {BrowserRouter as Router, Link, Route, Switch} from "react-router-dom";
import React from "react";

export default class Owner extends Model{

    createOrUpdatePage= (url) =>{
        const router = ReactDOM.createRoot(document.getElementById('root'));
        let elem =
            (<div>
                <form>
                    <p><input type="text" name='name' placeholder={'name'}></input></p>
                    <p><input type="text" name='address' placeholder={'address'}></input></p>
                    <p><input type="text" name='phoneNumber' placeholder={'phone number'}></input></p>
                    <button onClick={() => {window.location.reload()}}>BACK</button>
                    <button onClick={() => {
                        let name = document.getElementsByName("name");
                        let address = document.getElementsByName("address");
                        let phoneNumber = document.getElementsByName("phoneNumber");
                        fetch(url, {
                            method: 'POST',
                            headers: {
                                'Accept': 'application/json',
                                'Content-Type': 'application/json',
                            },
                            body: JSON.stringify({
                                name: name[0].value,
                                address: address[0].value,
                                phoneNumber: phoneNumber[0].value
                            })
                        })
                        window.location.reload()}
                    }>SAVE</button>
                </form>
            </div>);
        router.render(elem);
    }

    singlePage= ({match}) => {
        let root = ReactDOM.createRoot(document.getElementById('root'));
        const id = match.params.id;
        let data = GetJson('http://localhost:8080/owners/' + id);
        let elem = (
            <div>
                <h1>{data.name}</h1>
                <p className='halls-info'>Address : {data.address}</p>
                <p className='halls-info'>Phone number : {data.phoneNumber}</p>
                <button onClick={() => {
                    window.location.href = `/owners`
                }}>BACK
                </button>
                <button onClick={() => {
                    this.createOrUpdatePage('http://localhost:8080/owners/' + id)
                }}>UPDATE
                </button>
                <button onClick={() => {
                    fetch('http://localhost:8080' + window.location.pathname + '/delete', {
                        method: 'POST'
                    })
                    window.location.href = `/owners`
                }}>DELETE
                </button>
            </div>
        );
        root.render(elem);
    }

    homePage = () => {
        let data = GetJson("http://localhost:8080/owners");
        let root = ReactDOM.createRoot(document.getElementById('root'));
        let elem = (
            <Router>
                <div id='router'>
                    <h1 className='for-delete'>OWNERS</h1>
                    <ul className='for-delete'>
                        {data && (
                            data.map(item => (
                                <li key={item.id}>
                                    <Link to={`/owners/${item.id}`} onClick={() => {
                                        window.location.href = `/owners/${item.id}`
                                    }}>{item.name} : {item.address}</Link>
                                </li>
                            )))}
                    </ul>
                    <button className='for-delete' onClick={() => {
                        this.createOrUpdatePage('http://localhost:8080/owners')
                    }}>CREATE
                    </button>
                    <button className='for-delete' onClick={() => {
                        window.location.href=`/`
                    }}>BACK
                    </button>
                    <Switch>
                        <Route path="/owners/:id" component={this.singlePage}/>
                    </Switch>
                </div>
            </Router>
        );
        root.render(elem);
    }
}