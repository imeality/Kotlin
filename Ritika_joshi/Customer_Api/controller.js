const check = require("express-validator");

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
Count    	             :  req.body.Count

}).then(customer  =>  {

 //var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
//
//if()
// else
// {
//   console.log("valid email");
// }

res.send(customer);

});
};


exports.findById = (req,res)  =>  {

Customer.findById(req.params.customerId).then(customer   =>  {


  if(!customer)
  {
      console.log("There is no data with this id "+req.params.customerId);
      return res.status(400).send("There is no data with this id "+req.params.customerId);


  }
  else{

      console.log("There is data");
  }


res.send(customer);

})

};





exports.findByKeyword = (req,res) => {


let keyword = req.params.keyword;
Customer.findAll({
  //attributes: ['Item_Name', 'Category_Type','Item_Price'],
where :
{
$or:[
{ User_Category          : { $like : '%' + keyword +'%'} },
{ Customer_Name            : { $like : '%' + keyword+'%'}  },
{ Customer_Phone_Number    : {$eq: keyword} }
]
}
}).then(customer => {

  if(customer!=0)
  {
        console.log("there is a customer with this name "+req.params.keyword);
      //  res.status(200).send("there is a item with this name "+req.params.keyword);
        res.send(customer);
  }
  else {
    {
        console.log("there is no customer with this name"+req.params.keyword);
          res.status(200).send("there is no customer with this name "+req.params.keyword);

    }
  }

});

};




exports.findAll = (req,res) => {

Customer.findAll().then(customer => {

  res.send(customer);
});

};
















exports.update = (req,res)  => {

Customer.update({  Customer_Name  : req.body.Customer_Name ,
  Customer_Phone_Number: req.body.Customer_Phone_Number,
  Customer_Email   : req.body.Customer_Email,
  Date_Of_Birth    :req.body.Date_Of_Birth ,
  User_Category      : req.body.User_Category
},{
  where : {Customer_Id : req.params.customerId}
}).then(() => {

res.status(200).send("upadte customer with id = "+req.params.customerId);

})

};







exports.delete = (req,res)  => {

  const id = req.params.customerId;

  Item.destroy({

    where : { Customer_Id:id}

  }).then(customer => {
    if(!customer)
    {
      console.log("There is no id like "+id);
      res.status(200).send("There is no id like = "+id);

    }
    else {
      console.log("delete information");
      res.status(200).send("delete all information with id = "+id);
    }

  })
};














exports.delete = (req,res)  => {

  const id = req.params.customerId;

  Customer.destroy({

    where : { Customer_Id:id}

  }).then(customer => {
    if(!customer)
    {
      console.log("There is no id like "+id);
      res.status(200).send("There is no id like = "+id);

    }
    else {
      console.log("delete information");
      res.status(200).send("delete all information with id = "+id);
    }

  })
};
