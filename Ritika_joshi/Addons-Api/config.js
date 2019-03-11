const mysql = require("./connection.js");

const Sequelize = require("sequelize");

const sequelize = new Sequelize(mysql.database,mysql.username,mysql.password,{

  host:mysql.host,
  dialect : mysql.dialect

});

const db = {};

db.Sequelize = Sequelize;
db.sequelize = sequelize;

//require model table

db.addon = require("./model")(sequelize,Sequelize);
db.inventory = require("./model2.js")(sequelize,Sequelize);

module.exports = db;

 db.addon.belongsTo(db.inventory, {foreignKey: 'Inventory_Id'});
db.inventory.hasOne(db.addon, {foreignKey: 'Inventory_Id'});
