import ReactDOM from "react-dom/client";
import React from "react";
import {GetJson} from "../util/Util";
import Model from "./Model";
import '../styles/styles.css'
import {getMenu} from "../util/Menu";

export default class Hall extends Model{
    name = 'HALLS'

    createOrUpdatePage= (url, data, exhibitions) =>{
        const router = ReactDOM.createRoot(document.getElementById('root'));
        console.log(exhibitions)
        let elem =
            (<div>
                <h1>{this.name}</h1>
                <hr/>
                {getMenu()}
                <form>
                    <p><input type="text" name='name' placeholder={'name'} defaultValue={data !== undefined ? data.name : ''}></input></p>
                    <p><input type="text" name='address' placeholder={'address'} defaultValue={data !== undefined ? data.address : ''}></input></p>
                    <p><input type="text" name='square' placeholder={'square'} defaultValue={data !== undefined ? data.square : ''}></input></p>
                    <p>
                        <label htmlFor="owners-select">Choose an owner: </label>
                        <select name="owners" id="owners-select">
                            {this._helpItem && this._helpItem.map(item =>{
                                return <option value={item.name}>  {item.name}</option>
                            })}
                        </select>
                    </p>
                    {exhibitions !== undefined ?
                    <p>
                        <label htmlFor="exhibitions-select">Choose an exhibition: </label>
                        <select name="exhibitions" id="exhibitions-select">
                            {exhibitions && exhibitions.map(item =>{
                                return <option value={item.name}>  {item.name}</option>
                            })}
                        </select>
                    </p> : ''}

                    <button onClick={() => {window.location.reload()}}>BACK</button>
                    <button onClick={() => {
                        let name = document.getElementsByName("name");
                        let address = document.getElementsByName("address");
                        let square = document.getElementsByName("square");
                        let owner = document.getElementById("owners-select");
                        let exhibition = document.getElementById("exhibitions-select");
                        console.log(owner.value);
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
                                owner: owner.value,
                                exhibition: exhibition.value
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
        let exhibitions = GetJson('http://localhost:8080/exhibitions');
        let data = GetJson('http://localhost:8080/halls/' + id);
        console.log(data.exhibition)
        if (data.owner !== undefined) {
            let elem = (
                <div>
                    <h1>{data.name}</h1>
                    <hr/>
                    {getMenu()}
                    <p className='halls-info'>Address : {data.address}</p>
                    <p className='halls-info'>Square : {data.square}</p>
                    <p className='halls-info'><a href={'http://localhost:3000/owners/'+data.owner.id}>Owner : {data.owner.name}</a></p>
                    {data.exhibition!==null ?
                        <p className='halls-info'><a href={'http://localhost:3000/exhibitions/'+data.exhibition.id}>Exhibition : {data.exhibition.name} - {data.exhibition.date}</a></p>
                        : <p>Exhibition is not chosen</p>
                    }<button onClick={() => {
                        window.location.href = `/halls`
                    }}>BACK
                    </button>
                    <button onClick={() => {
                        this.createOrUpdatePage('http://localhost:8080/halls/' + id, data, exhibitions);
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

}