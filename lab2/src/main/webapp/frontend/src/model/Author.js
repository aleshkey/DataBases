import Model from "./Model";
import ReactDOM from "react-dom/client";
import {GetJson} from "../util/Util";
import {BrowserRouter as Router, Link, Route, Switch} from "react-router-dom";
import React from "react";
import {getMenu} from "../util/Menu";

export default class Author extends Model{
    name = 'AUTHORS'

    createOrUpdatePage= (url, data) =>{
        const router = ReactDOM.createRoot(document.getElementById('root'));
        console.log(typeof data);
        let elem =
            (<div>
                <h1>{this.name}</h1>
                <hr/>
                {getMenu()}
                <form>
                    <p><input type="text" name='name' placeholder={'name'} defaultValue={data === undefined ? '' : data.name}></input></p>
                    <p><input type="text" name='placeOfBirth' placeholder={'place of birth'} defaultValue={data === undefined ? '' : data.placeOfBirth}></input></p>
                    <p><input type="text" name='education' placeholder={'education'} defaultValue={data === undefined ? '' : data.education}></input></p>
                    <p><input type="text" name='biography' placeholder={'biography'} defaultValue={data === undefined ? '' : data.biography}></input></p>
                    <button onClick={() => {window.location.reload()}}>BACK</button>
                    <button onClick={() => {
                        let name = document.getElementsByName("name");
                        let placeOfBirth = document.getElementsByName("placeOfBirth");
                        let education = document.getElementsByName("education");
                        let biography = document.getElementsByName("biography");
                        fetch(url, {
                            method: 'POST',
                            headers: {
                                'Accept': 'application/json',
                                'Content-Type': 'application/json',
                            },
                            body: JSON.stringify({
                                name: name[0].value,
                                placeOfBirth: placeOfBirth[0].value,
                                education: education[0].value,
                                biography: biography[0].value
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
        let data = GetJson(`http://localhost:8080/authors/` + id);
        if (data.id !== undefined) {
            let elem = (
                <div>
                    <h1>{data.name}</h1>
                    <hr/>
                    {getMenu()}
                    <p className='halls-info'>Place of birth : {data.placeOfBirth}</p>
                    <p className='halls-info'>Education : {data.education}</p>
                    <p className='halls-info'>Biography : {data.biography}</p>
                    <button onClick={() => {
                        window.location.href = `/authors`
                    }}>BACK
                    </button>
                    <button onClick={() => {
                        this.createOrUpdatePage(`http://localhost:8080/authors/` + id, data)
                    }}>UPDATE
                    </button>
                    <button onClick={() => {
                        fetch('http://localhost:8080' + window.location.pathname + '/delete', {
                            method: 'POST'
                        })
                        window.location.href = '/authors';
                    }}>DELETE
                    </button>
                </div>
            );
            root.render(elem);
        }
    }
}