import Model from "./Model";
import ReactDOM from "react-dom/client";
import {GetJson} from "../util/Util";
import React from "react";

export default class Image extends Model{
    name = 'IMAGES'

    createOrUpdatePage= (url, data) =>{
        const router = ReactDOM.createRoot(document.getElementById('root'));
        let elem =
            (<div>
                <form>
                    <p><input type="text" id='name' placeholder={'name'} defaultValue={data === undefined ? '' : data.name}></input></p>
                    <p><input type="text" id='execution' placeholder={'execution'} defaultValue={data === undefined ? '' : data.execution}></input></p>
                    <p><input type="text" id='creationDate' placeholder={'creation date'} defaultValue={data === undefined ? '' : data.creationDate}></input></p>
                    <p>
                        <label htmlFor="author-select">Choose an author: </label>
                        <select name="author" id="author-select">
                            {this._helpItem && this._helpItem.map(item =>{
                                return <option value={item.name}>  {item.name}</option>
                            })}
                        </select>
                    </p>
                    <button onClick={() => {window.location.reload()}}>BACK</button>
                    <button onClick={() => {
                        let name = document.getElementById("name");
                        let execution = document.getElementById("execution");
                        let creationDate = document.getElementById("creationDate");
                        let author = document.getElementById("author-select");
                        fetch(url, {
                            method: 'POST',
                            headers: {
                                'Accept': 'application/json',
                                'Content-Type': 'application/json',
                            },
                            body: JSON.stringify({
                                name: name.value,
                                execution: execution.value,
                                creationDate: creationDate.value,
                                author: author.value,
                            })
                        })
                        window.location.reload()
                    }
                    }>SAVE</button>
                </form>
            </div>);
        router.render(elem);
    }

    singlePage= ({match}) => {
        let root = ReactDOM.createRoot(document.getElementById('root'));
        const id = match.params.id;
        let data = GetJson('http://localhost:8080/images/' + id);
        console.log(data);
        if (data.author !== undefined) {
            let elem = (
                <div>
                    <h1>{data.name}</h1>
                    <p className='halls-info'>Execution : {data.execution}</p>
                    <p className='halls-info'>Creation date : {data.creationDate}</p>
                    <p className='halls-info'><a href={'http://localhost:3000/authors/'+data.author.id}>Author : {data.author.name}</a></p>
                    <button onClick={() => {
                        window.location.href = `/images`
                    }}>BACK
                    </button>
                    <button onClick={() => {
                        this.createOrUpdatePage('http://localhost:8080/images/' + id, data)
                    }}>UPDATE
                    </button>
                    <button onClick={() => {
                        fetch('http://localhost:8080' + window.location.pathname + '/delete', {
                            method: 'POST'
                        })
                        window.location.href = `/images`
                    }}>DELETE
                    </button>
                </div>
            );
            root.render(elem);
        }
    }

}