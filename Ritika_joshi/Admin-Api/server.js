var express = require("express");
var app = express();
var bodyparser = require("body-parser");




app.use(bodyparser.json());

const db = require("./config.js");

db.sequelize.sync({force:false}).then(() => {

console.log("drop and resynch with force false");

});


require('./route.js')(app);


var server = app.listen(3002,function(){

var host = server.address().address
var port = server.address().port

console.log("app listening at http : //%s //%s",host,port);

})
