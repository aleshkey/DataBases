import Model from "./Model";
import ReactDOM from "react-dom/client";
import {GetJson} from "../util/Util";
import React from "react";
import {getMenu} from "../util/Menu";

export default class Exhibition extends Model{
    name = 'EXHIBITIONS'

    createOrUpdatePage= (url, data) =>{
        const router = ReactDOM.createRoot(document.getElementById('root'));
        let elem =
            (

                <div>
                <h1>{this.name}</h1>
                <hr/>
                {getMenu()}
                <form className={'form-inline'}>
                    <p><label htmlFor={'name'}>Name: </label>
                    <input type="text" id='name' placeholder={'name'} defaultValue={data === undefined ? '' : data.name}></input></p>
                    <p><label htmlFor={'name'}>Type: </label>
                    <input type="text" id='type' placeholder={'type'} defaultValue={data === undefined ? '' : data.type}></input></p>
                    <p><label htmlFor={'name'}>Date: </label>
                    <input type="date" id='date' placeholder={'date'} defaultValue={data === undefined ? '' : data.date}></input></p>
                    <p>
                        <label htmlFor="author-select">Choose an image: </label>
                        <select name="image" id="image-select" multiple>
                            {this._helpItem && this._helpItem.map(item =>{
                                return <option value={item.name}>Image : {item.name}, author :{item.author.name}</option>
                            })}
                        </select>
                    </p>
                    <button onClick={() => {window.location.reload()}}>BACK</button>
                    <button onClick={() => {
                        let name = document.getElementById("name");
                        let type = document.getElementById("type");
                        let date = document.getElementById("date");
                        const selectElement = document.querySelector('select');
                        const selectedOptions = Array.from(selectElement.selectedOptions).map(option => option.value);
                        console.log(selectedOptions);
                        fetch(url, {
                            method: 'POST',
                            headers: {
                                'Accept': 'application/json',
                                'Content-Type': 'application/json',
                            },
                            body: JSON.stringify({
                                name: name.value,
                                type: type.value,
                                date: date.value,
                                images: selectedOptions
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
        let data = GetJson(`http://localhost:8080/exhibitions/` + id);
        console.log(data);
        if (data.id !== undefined) {
            let elem = (
                <div>
                    <h1>{data.name}</h1>
                    <hr/>
                    {getMenu()}
                    <p className='halls-info'>Type : {data.type}</p>
                    <p className='halls-info'>Date : {data.date}</p>
                    <label htmlFor={'images'}>Images: </label>
                        <ul className='all-items' id={'images'}>
                        {data.images && data.images.map(item => (
                            <li><a href={'http://localhost:3000/images/' + item.id}>{item.name} - {item.author.name}</a></li>
                        ))}
                        </ul>

                    <button onClick={() => {
                        window.location.href = `/exhibitions`
                    }}>BACK
                    </button>
                    <button onClick={() => {
                        this.createOrUpdatePage(`http://localhost:8080/exhibitions/` + id, data)
                    }}>UPDATE
                    </button>
                    <button onClick={() => {
                        fetch('http://localhost:8080' + window.location.pathname + '/delete', {
                            method: 'POST'
                        })
                        window.location.href = '/exhibitions';
                    }}>DELETE
                    </button>
                </div>
            );
            root.render(elem);
        }
    }

}