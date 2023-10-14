import {useEffect, useState} from "react";

export function GetJson(url){
    const [data, setData] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch(url);
                const jsonData = await response.json();
                setData(jsonData);
            } catch (error) {
                console.error('Error:', error);
            }
        };

        fetchData();
    }, [url]);

    return data;
}