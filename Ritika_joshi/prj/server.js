var express = require("express");

var app = express();

var bodyParser = require("body-parser");

app.use(bodyParser.json())

const db = require('./config.js');

db.sequelize.sync({force:false}).then(()=>

{

console.log('drop and Resynch with {force:true}');

});

require('./route.js')(app);

var server  = app.listen(3001,function(){
var host = server.address().address
var port  = server.address().port

console.log("App listening at http : //%s://%s",host,port)

})
