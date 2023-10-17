import React from "react";

export function getMenu(){
    return (
    <nav>
        <ul>
            <li>
                <a href={"#"} ><img className={'menu'} src={"https://catherineasquithgallery.com/uploads/posts/2021-02/1614519413_154-p-serdechko-na-belom-fone-187.png"}></img></a>
                <ul className="dropdown">
                    <li><a href="http://localhost:3000/halls">HALLS</a></li>
                    <li><a href="http://localhost:3000/owners">OWNERS</a></li>
                    <li><a href="http://localhost:3000/authors">AUTHORS</a></li>
                    <li><a href="http://localhost:3000/exhibitions">EXHIBITIONS</a></li>
                    <li><a href="http://localhost:3000/images">IMAGES</a></li>
                </ul>
            </li>
        </ul>
    </nav>)
}