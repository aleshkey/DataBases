import ReactDOM from "react-dom/client";
import {BrowserRouter as Router, Link, Route, Switch} from "react-router-dom";
import React from "react";
import {GetJson} from "../util/Util";
import Model from "./Model";

export default class Hall extends Model{

    createOrUpdatePage= (url) =>{
        const router = ReactDOM.createRoot(document.getElementById('root'));
        let elem =
            (<div>
                <form>
                    <p><input type="text" name='name' placeholder={'name'}></input></p>
                    <p><input type="text" name='address' placeholder={'address'}></input></p>
                    <p><input type="text" name='square' placeholder={'square'}></input></p>
                    <p><input type="text" name='owner' placeholder={'owner'}></input></p>
                    <button onClick={() => {window.location.reload()}}>BACK</button>
                    <button onClick={() => {
                        let name = document.getElementsByName("name");
                        let address = document.getElementsByName("address");
                        let square = document.getElementsByName("square");
                        let owner = document.getElementsByName("owner");
                        fetch(url, {
                            method: 'POST',
                            headers: {
                                'Accept': 'application/json',
                                'Content-Type': 'application/json',
                            },
                            body: JSON.stringify({
                                name: name[0].value,
                                address: address[0].value,
                                square: square[0].value,
                                owner: owner[0].value
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
        let data = GetJson('http://localhost:8080/halls/' + id);
        if (data.owner !== undefined) {
            console.log(data.owner.name);
            let elem = (
                <div>
                    <h1>HALL {id}</h1>
                    <p className='halls-info'>Name : {data.name}</p>
                    <p className='halls-info'>Address : {data.address}</p>
                    <p className='halls-info'>Square : {data.square}</p>
                    <p className='halls-info'><a href={'http://localhost:3000/owners/'+data.owner.id}>Owner : {data.owner.name}</a></p>
                    <button onClick={() => {
                        window.location.href = `/halls`
                    }}>BACK
                    </button>
                    <button onClick={() => {
                        this.createOrUpdatePage('http://localhost:8080/halls/' + id)
                    }}>UPDATE
                    </button>
                    <button onClick={() => {
                        fetch('http://localhost:8080' + window.location.pathname + '/delete', {
                            method: 'POST'
                        })
                        window.location.href = `/halls`
                    }}>DELETE
                    </button>
                </div>
            );
            root.render(elem);
        }
    }

    /*homePage = () =>{
        let data = GetJson("http://localhost:8080/halls");
        let root = ReactDOM.createRoot(document.getElementById('root'));
        let elem = (
            <Router>
                <div id='router'>
                    <h1 className='for-delete'>HALLS</h1>
                    <ul className='for-delete'>
                        {data && (
                            data.map(item => (
                                <li key={item.id}>
                                    <Link to={`/halls/${item.id}`} onClick={() => {
                                        window.location.href = `/halls/${item.id}`
                                    }}>{item.name} : {item.address}</Link>
                                </li>
                            )))}
                    </ul>
                    <button className='for-delete' onClick={() => {
                        this.createOrUpdatePage('http://localhost:8080/halls')
                    }}>CREATE
                    </button>
                    <button className='for-delete' onClick={() => {
                        window.location.href=`/`
                    }}>BACK
                    </button>
                    <Switch>
                        <Route path="/halls/:id" component={this.singlePage}/>
                    </Switch>
                </div>
            </Router>
        );
        root.render(elem);
    }*/
}