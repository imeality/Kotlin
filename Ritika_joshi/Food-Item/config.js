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

db.item = require("./model")(sequelize,Sequelize);
db.category = require("./model2.js")(sequelize,Sequelize);

module.exports = db;

 db.item.belongsTo(db.category, {foreignKey: 'Category_Id'});
db.category.hasOne(db.item, {foreignKey: 'Category_Id'});
