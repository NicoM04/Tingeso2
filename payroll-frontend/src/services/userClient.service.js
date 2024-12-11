import httpClient from "../http-common";

// Obtener todos los clientes
const getAll = () => {
    return httpClient.get('/api/users/');
};

// Obtener un cliente por ID
const get = id => {
    return httpClient.get(`/api/users/${id}`);
};

// Crear un nuevo cliente
const create = data => {
    return httpClient.post("/api/users/", data);
};

// Actualizar un cliente existente
const update = data => {
    return httpClient.put('/api/users/', data);
};

// Eliminar un cliente por ID
const remove = id => {
    return httpClient.delete(`/api/users/${id}`);
};

// Método de autenticación para el login
const login = (email, password) => {
    return httpClient.post("/api/users/login", { mail: email, password });
};
export default {
    getAll,
    get,
    create,
    update,
    remove,
    login
};
