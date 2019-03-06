const db  =  require('./config.js');

const Customer  =  db.customer;

exports.create  =  (req,res)  => {                //post a customer

Customer.create({			          //save to mysql database

Customer_Id            :  req.body.Customer_Id,
Customer_Name          :  req.body.Customer_Name,
Customer_Phone_Number  :  req.body.Customer_Phone_Number,
Customer_Email         :  req.body.Customer_Email,
Date_Of_Birth          :  req.body.Date_Of_Birth,
Customer_Status        :  req.body.Customer_Status,
Count    	             :  req.body.Count,

}).then(customer  =>  {

const id = req.params.customerId;

res.send(customer);

});
};
//get all detail by id

exports.findById = (req,res)  =>  {

Customer.findById(req.params.customerId).then(customer   =>  {


  if (res.data != undefined) {
         console.log("There is data");
     } else {
         res.send("No data present with this id = "+req.params.customerId)
     }
res.send(customer);

})

};
