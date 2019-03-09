const mysql = require("./connection.js");

const Sequelize = require("sequelize");

const sequelize = new Sequelize(mysql.database,mysql.username,mysql.password,{

  host     : mysql.host,
  dialect  : mysql.dialect

});

const db = {};

db.Sequelize = Sequelize ;
db.sequelize = sequelize;

db.inventory = require("./model")(sequelize,Sequelize);

module.exports = db;
