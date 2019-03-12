var  express = require("express");

var bodyparser = require("body-parser");

var cookieParser = require('cookie-parser');

var session = require('express-session');

var morgan = require('morgan');

// const db = require("./config.js");
const db  = require("./config.js");
const Admin = db.admin;


var app = express();

app.use(bodyparser.json());



 db.sequelize.sync({force:false}).then(() => {

console.log("drop and resynch with force false");

 });

 app.use(morgan('dev'));


app.use(cookieParser());



app.use(session({
    key: 'admin_sid',
    secret: 'somerandonstuffs',
    resave: false,
    saveUninitialized: false,
    cookie: {
        expires: 6000
    }
}));

app.use((req, res, next) => {
    if (req.cookies.user_sid && !req.session.user) {
        res.clearCookie('admin_sid');
    }
    next();
});



var sessionChecker = (req, res, next) => {
    if (req.session.user && req.cookies.user_sid) {
        res.send("session out");
    } else {
        next();
    }
};




app.route('/login')
    .get(sessionChecker, (req, res) => {
        res.sendFile("abc");
    })
    .post((req, res) => {
        var username = req.body.Phone_No,
            password = req.body.password;

        Admin.findOne({ where:

           {
               $and :  [

             {Phone_No: username},
             {Password : password}

            ]
           }

         }).then(function (admin) {
            if (!admin) {
                res.send('not valid');
                console.log("not valid")
            // } else if (!admin.validPassword(password)) {
            //     res.send('not valid');
            } else {
                req.session.admin= admin.dataValues;
              //  res.redirect('succesfully login');
                res.status(200).send("succesfully login");
            }
        });
    });



app.get('/logout', (req, res) => {
    if (req.session.user && req.cookies.user_sid) {
        res.clearCookie('user_sid');
        res.redirect('/');
    } else {
        res.redirect('/login');
    }
});



app.use(function (req, res, next) {
  res.status(404).send("Sorry can't find that!")
});

 //require("./route.js")(app);

 var server = app.listen(3007,function(){

  var host = server.address().address;
  var port = server.address().port;

  console.log("app listening at http : //%s //%s",host,port);

 })
