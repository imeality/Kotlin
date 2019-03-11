const db = require("./config.js");

const Addons = db.addon;

const Inventory = db.inventory;

exports.create = (req,res) => {

Addons.create({
  AddOn_Id              : req.body.AddOn_Id,
  Inventory_Name        : req.body.Inventory_Name,
  Inventory_Id          : req.body.Inventory_Id,
  Price                 : req.body.Price

}).then(addon => {

res.send(addon);

});

};

exports.findAll = (req,res) => {

Addons.findAll().then(addon => {

  res.send(addon);
});

};





exports.findByKeyword = (req,res) => {


let keyword = req.params.keyword;
Addons.findAll({
  //attributes: ['Item_Name', 'Category_Type','Item_Price'],
where :
{
$or:[
{ Inventory_Name     : { $like : '%' + keyword +'%'} },
{ Price    : {$eq: keyword} }
]
}
}).then(addon => {

  if(addon!=0)
  {
        console.log("there is a addon with this name or price "+req.params.keyword);
      //  res.status(200).send("there is a item with this name "+req.params.keyword);
        res.send(addon);
  }
  else {
    {
        console.log("there is no addon with this name or price "+req.params.keyword);
          res.status(200).send("there is no addon with this name or price "+req.params.keyword);

    }
  }


});

};










exports.findByGreaterPrice = (req,res) => {


let keyword = req.params.keyword;
Addons.findAll({
  //attributes: ['Item_Name', 'Category_Type','Item_Price'],
where :
{

 Price  : {$gte: keyword}

}
}).then(addon => {

  if(addon!=0)
  {
        console.log("there is addon greater then equals to"+req.params.keyword);
      //  res.status(200).send("there is a item with this name "+req.params.keyword);
        res.send(addon);
  }
  else {
    {
          console.log("there is no addon greater then equal or equals to"+req.params.keyword);
          res.status(200).send("there is no addon greater then equals to"+req.params.keyword);
    }
  }


});

};
















exports.findByLessPrice = (req,res) => {


let keyword = req.params.keyword;
Addons.findAll({
  //attributes: ['Item_Name', 'Category_Type','Item_Price'],
where :
{
    Price    : {$lte: keyword}
}
}).then(addon => {

  if(addon!=0)
  {
        console.log("there is addon less then or equal to"+req.params.keyword);
      //  res.status(200).send("there is a item with this name "+req.params.keyword);
        res.send(addon);
  }
  else {
    {
        console.log("there is no addon less then or equal to"+req.params.keyword);
          res.status(200).send("there is no addon less then or equal to"+req.params.keyword);

    }
  }


});

};
















exports.findAllData = (req,res) => {

Addons.findAll({
  include: [
    {
      model: db.inventory,
      required: true

    }
  ]
}).then(addon => {

  res.send(addon);
});

};



exports.findAllById = (req,res) => {

 Addons.findAll({
   where: { AddOn_Id : req.params.addonId},
   include : [
     {
       model : db.inventory,
       required: true
     }
   ]
 }).then(addon => {


  if(addon!=0)
  {
      console.log("there is addon with this id "+req.params.addonId);
      res.send(addon);
  }

  else
  {
    console.log("there is no addon with this id "+req.params.addonId);
    res.send("there is no addon with this id "+req.params.addonId);
  }

 });
};





exports.findById = (req,res)  =>  {

  Addons.findById(req.params.addonId).then(addon => {

    if(!addon){
      return res.status(400).send("There is no data with id "+req.params.addonId);
      console.log("There is no data with id "+req.params.addonId);
    }
    else {
      {
        console.log("There is a data");
        res.send(addon);
      }

    }

  });
};







exports.update = (req,res)  => {

Addons.update({ Inventory_Name : req.body.Inventory_Name,
  Price    : req.body.Price},{
  where : {AddOn_Id : req.params.addonId}
}).then(() => {

res.status(200).send("upadte food addon with id = "+req.params.addonId);

})

};

exports.delete = (req,res)  => {

  const id = req.params.addonId;

  Addons.destroy({

    where : { AddOn_Id:id}

  }).then(addon => {
    if(!addon)
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
