const db = require("./config.js");

const Inventory = db.inventory;

exports.create = (req,res) => {

    Inventory.create({

    Inventory_Id         :  req.body.Inventory_Id,
    Inventory_Name       :  req.body.Inventory_Name,
    Inventory_Quantity   :  req.body.Inventory_Quantity

  //  Is_Addon
}).then(inventory => {
  res.send(inventory);

});
};




exports.findAll = (req,res)  =>  {

Inventory.findAll().then(inventory => {

res.send(inventory);

});
};


exports.findByKeyword = (req,res)  => {

let keyword = req.params.keyword;

Inventory.findAll({
  where : {

    $or : [
      {  Inventory_Name     : {$like : '%' +keyword+ '%'}},
      {   Inventory_Quantity : {$eq : keyword}   }

    ]

  }
}).then(inventory => {

  if(inventory!=0)
  {
    console.log("there is inventory");
      res.send(inventory);
  }
  else {
    {
      res.status(200).send("there is no inventory with "+keyword);
    }

  }
})
};











exports.findByGreaterQutantiy = (req,res) =>
{
  let keyword = req.params.keyword;

Inventory.findAll({

  where : {

        Inventory_Quantity : {$gte : keyword}

  }

}).then(inventory => {

if(inventory!=0){
res.send(inventory);

    console.log("there is  inventory greater then "+keyword);

}
else
  {
    res.status(200).send("thre is no inventory is greater than or equals to"+keyword);
    console.log("thre is no inventory is greater than or equals to"+keyword);
  }

});
};










exports.findByLessQuantity = (req,res) =>
{
  let keyword = req.params.keyword;

Inventory.findAll({

  where : {
     Inventory_Quantity: {$lte:keyword}
  }

}).then(inventory => {
if(inventory!= 0){
  console.log("there is  quantity less then "+keyword);
  res.send(inventory);
}
else
  {
    res.status(400).send("thre is no quantity is less than or equal to"+keyword);
    console.log("thre is no quantity is greater than or equal to"+keyword);
  }

});
};








exports.findById = (req,res)  => {

Inventory.findById(req.params.inventoryId).then(inventory => {

if(!inventory)
{
  res.status(400).send("There is no Inventory with this Id "+req.params.inventoryId);
  console.log("There is no Inventory with This Id "+req.params.inventoryId);
}

else {

console.log("There is Inventory with This Id "+req.params.inventoryId);
res.send(inventory);
}

});
};













exports.update = (req,res)  => {
  Inventory.update({Inventory_Name:req.body.Inventory_Name,
    Inventory_Quantity:req.body.Inventory_Quantity},{
    where : {Inventory_Id:req.params.inventoryId}
  }).then(() => {

res.status(200).send("update inventory with this id "+req.params.inventoryId);
  });
};









exports.delete = (req,res)  => {
  const id = req.params.inventoryId;
  Inventory.destroy({
    where: {Inventory_Id:req.params.inventoryId}
  }).then(inventory => {

    if(!inventory)
    {
      console.log("There is no id like "+id);
      res.status(200).send("There is no id like = "+id);

    }
    else {
      console.log("delete information");
      res.status(200).send("delete all information with id = "+id);
    }

  });
};
