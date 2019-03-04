const mysql = require("./connection.js");

const Sequelize = require("sequelize");

const sequelize = new Sequelize(mysql.database,mysql.username,mysql.password,{


host:mysql.host,
dialect : mysql.dialect
});

const db= {};

db.Sequelize = Sequelize;
db.sequelize = sequelize;

//model table

db.customers = require("./model.js")(Sequelize,sequelize);

module.exports = db;

