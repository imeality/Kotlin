var express  = require("express");

var bodyparser = require("body-parser");

var app = express();

app.use(bodyparser.json())

const db = require("./config.js");

db.sequelize.sync({force:false}).then(() =>     //false for not create new table
{

console.log("drop and Resynch with ");

})

require('./route.js')(app);

var server = app.listen(3001,function(){

  var host = server.address().address
  var port = server.address().port

  console.log("App listening at http : //%s : //%s",host,port)
})
 
