const express = require('express');
const app = express();
const bodyParser = require('body-parser');
const mysql = require('mysql');
var session = require("express-session");
var morgan = require("morgan");
var cookieParser = require("cookie-parser");

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({
    extended: true
}));


app.use(morgan('dev'));


app.use(cookieParser());




app.use(session({

key:'adminkey',
secret : 'someramdomstuffs',
resave:false,
saveUnitialized : false,

cookie : {
  expires : 1000
}

}));



app.use((req,res,next) => {

if(req.cookies.adminkey  && !req.session.Admin){
  res.clearCookie('adminkey');
}

next();

});



var sessionChecker = (req,res,next) => {

  if(req.session.Admin && req.cookies.adminkey)
  {
    res.send("your session is out");
  }
  else {
         next();
  }

};



const connection = mysql.createConnection({
    host: 'localhost',
    user: 'phpmyadminuser',
    password: 'password',
    database: 'foododrsys'
});


connection.connect();
app.route("/api/login").get(sessionChecker, (req, res) => {res.send("ds")}).post((req,res) =>

{

var Phone_No = req.body.Phone_No;
var Password = req.body.Password;

connection.query("SELECT * FROM ADMIN WHERE Phone_No = ?",[Phone_No],function(error,results,fields){

if(error)
{
  //console.log("error occured",error);
  res.send({
    "code":400,
    "failed":"error occured",error
  })
}
else
  {
    //console.log("the result is " results);

    if(results.length>0)
    {
      if(results[0].Password == Password)
      {
      res.send({
        "code":200,
        "success":"login successfully"
      });
    }
    else {
      res.send({
        "code":204,
        "success":"user name and password not match"
      });
    }
  }

  else{
    res.send({
      "code":204,
      "success":"username not exits"
    });
  }
  }

});

});




app.get('/api/logout', function(req, res){
   req.session.destroy(function(){
      console.log("admin logged out.")
      res.send("admin logout")
   });
//   res.redirect('/login');
});


app.listen(3003,function(){

console.log("3003");
});
