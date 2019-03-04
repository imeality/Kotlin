const db = require(config.js);

const Customer = db.customers;

//post  a customer
exports.create =  (req,res)  =>  {


//save to mysql databases
Customer.create({

cust_name:req.body.cust_name,

cust_phone_number:req.body.cust_phone_number,

cust_email: req.body.cust_email

}).then(customer =>{

///save customer & send ;
 
res.send(customer);

});

};

//find all cutomer
exoprts.findAll=(req,res) => {

Customer.findAll().then(customer  =>  {

res.send(customer);
})

};

//find cutomer by id




export.findById = (req.res)  => {

exports.findbyId(req,params,customerId).then(customer  =>  {

})

};


// Delete a customer by id

exports.delete  = (req.res) =>

{

const id= req.params.customerId;

Customer.destroy({

where :{ id : id }

}).then(() => {


res.status(200).send('delete customer'+id);
});

};
