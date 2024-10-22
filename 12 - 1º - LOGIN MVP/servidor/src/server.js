const cors = require ("cors");
const express = require("express");
const bodyParser = require("body-parser");
const mysql = require("mysql2/promise");

const app = express();
const PORT = 3000;

app.use(cors());
app.use(bodyParser.json());

const myPool = mysql.createPool({
    host:"localhost",
    user:"root",
    database:"exd",
    password:"",
    port: 3306
});

(async () =>{
    try{
        const connection = await myPool.getConnection();
        connection.release();

    }catch (error){
        console.error("Error al conectar a la base de datos", error);
    }

});

app.listen(PORT, () =>{
    console.log(`Servidor corriendo en ${PORT}`);

});

app.post("/login", async (req,res) =>{
    const {email,password} = req.body;

    try{
        const[users] = await myPool.query("SELECT * FROM usuario WHERE email =?", [email]);

        if(users.length === 1){
            if(users[0].password == password){
                res.status(200).json({message:"Sesión iniciada correctamente", user: users[0]});
            }
        }

    }catch (error){
        console.error("Error durante el login");
    }

});