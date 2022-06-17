import { config } from './constants'

let colleges: JSON;

export const setColleges = (collegeList: JSON) => {
    colleges = collegeList;
}

export const getColleges = () => {
    return colleges;
}

export const collegeExists = (collegeName: string) => {
    return Object(colleges)[collegeName];
}

export const fetchCollegesOnRender = async () => {
    const requestOptions = {
        method: 'GET',
    };
    await fetch(`${config.url.API_URL}/get-colleges`, requestOptions)
        .then(async response => {
            const data = await response.json();
            setColleges(data);
        })
        .catch((error) => {
            // If this API fails, there is something wrong with our backend and
            // we should notify the user with an error message that prevents them
            // from using our website!!
            console.log('There was an error: ', error);
        });
}