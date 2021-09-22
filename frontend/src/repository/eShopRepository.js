import axios from '../custom-axios/axios';

const EShopService = {
    fetchUpcomingEvents: () => {
        return axios.get("/events");
    },
    fetchOrganisers: () => {
        return axios.get("/organisers");
    },
    deleteEvent: (id) => {
        return axios.delete(`/events/delete/${id}`);
    },
    addEvent: (name, price, quantity, category, startTime, endTime) => {
        return axios.post("/products/add", {
            "name" : name,
            "price" : price,
            "category" : category,
            "startTime" : startTime,
            "endTime" : endTime
        });
    },
    editEvent: (id, eventName, startTime, endTime, address, type, sales, amount, currency) => {
        return axios.put(`/products/edit/${id}`, {
            "eventName" : eventName,
            "startTime" : startTime,
            "endTime" : endTime,
            "address" : address,
            "type" : type,
            "sales" : sales,
            "amount": amount,
            "currency" : currency
        });
    },
    getEvent: (id) => {
        return axios.get(`/events/${id}`);
    }
}

export default EShopService;
