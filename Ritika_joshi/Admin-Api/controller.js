const db = require("./config.js");

const Admin = db.admins;

exports.create = (req,res)   =>   {


Admin.create({

  Admin_Id     : req.body.Admin_Id,
  Password     : req.body.Password,
  Phone_No     : req.body.Phone_No,
//  Admin_Status : req.body.Admin_Status

}).then(admin  => {

res.send(admin);

});

};


//find all admin
exports.findAll = (req,res)  => {

Admin.findAll().then(admins =>  {

    res.send(admins);
})
};
//
//find admin by id


exports.findById = (req,res)  =>  {

Admin.findById(req.params.adminId).then(admin => {



 if(!admin)
 {
     console.log("There is no data with this id "+req.params.adminId);
     return res.status(400).send("There is no data with this id "+req.params.adminId);


 }
 else{

     console.log("There is data");
 }
      res.send(admin);
})

};


exports.update = (req,res)  =>   {

const id = req.params.adminId;


Admin.update({Password:req.body.Password,Phone_No:req.body.Phone_No},
{where : {Admin_Id:req.params.adminId}
}).then(()  =>  {


res.status(200).send("update admin with id "+id);

});

};


exports.delete = (req,res)  =>
{
const id = req.params.adminId;

Admin.destroy({

where : { Admin_Id : id }

}).then(admin => {
  if(!admin)
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
