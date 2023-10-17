import Model from "./Model";
import {GetJson} from "../util/Util";
import ReactDOM from "react-dom/client";
import {BrowserRouter as Router, Link, Route, Switch} from "react-router-dom";
import React from "react";
import {getMenu} from "../util/Menu";

export default class Owner extends Model{
    name = 'OWNERS'

    createOrUpdatePage= (url, data) =>{
        const router = ReactDOM.createRoot(document.getElementById('root'));
        let elem =
            (<div>
                <h1>{this.name}</h1>
                <hr/>
                {getMenu()}
                <form>
                    <p><input type="text" name='name' placeholder={'name'} defaultValue={data === undefined ? '' : data.name}></input></p>
                    <p><input type="text" name='address' placeholder={'address'} defaultValue={data === undefined ? '' : data.address}></input></p>
                    <p><input type="text" name='phoneNumber' placeholder={'phone number'} defaultValue={data === undefined ? '' : data.phoneNumber}></input></p>
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
                <hr/>
                {getMenu()}
                <p className='halls-info'>Address : {data.address}</p>
                <p className='halls-info'>Phone number : {data.phoneNumber}</p>
                <button onClick={() => {
                    window.location.href = `/owners`
                }}>BACK
                </button>
                <button onClick={() => {
                    this.createOrUpdatePage('http://localhost:8080/owners/' + id, data)
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
}