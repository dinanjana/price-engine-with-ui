import axios from 'axios';

const getItems = async() => {
    try {
        const response = await axios.get('http://localhost:9090/v1/items');
        return response.data;
    } catch (e) {
        console.error(e);
        throw e;
    }
};

const getPricePerUnit = async (item, units) => {
    try {
        const response = await axios.get(`http://localhost:9090/v1/items/${item}/price/${units}`);
        return response.data;
    } catch (e) {
        console.error(e);
        throw e;
    }
};

const getPriceForARange = async (item, start, end) => {
    try {
        const response = await axios.get(`http://localhost:9090/v1/items/${item}/price?start=${start}&end=${end}`);
        return response.data;
    } catch (e) {
        console.error(e);
        throw e;
    }
};

export {
    getItems,
    getPricePerUnit,
    getPriceForARange,
}