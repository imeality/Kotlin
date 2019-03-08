const db = require("./config.js");

const Item = db.item;

exports.create = (req,res) => {

Item.create({
  FoodItem_Id    : req.body.FoodItem_Id,
  Category_Id    : req.body.Category_Id,
  Item_Name      : req.body.Item_Name,
  Category_Type  : req.body.Category_Type,
  Item_Price     : req.body.Item_Price

}).then(item => {

res.send(item);

});

};

exports.findAll = (req,res) => {

Item.findAll().then(item => {

  res.send(item);
});

};

// exports.findalldata = (req,res) => {
//
//  Item.find({  Category_Name : req.body.Category_Name,Category_Image : req.body.Category_Image,Category_Id : req.body.Category_Id,Item_Name : req.body.Item_Name,Category_Type  : req.body.Category_Type,},{
//    where : {FoodItem_Id : req.body.FoodItem_Id}}).then(() => {
//
//    res.status(200).send("finad all data with the id = "+req.body.FoodItem_Id);
//
//  });
//
// };


exports.findById = (req,res)  =>  {

  Item.findById(req.params.itemId).then(item => {

    if(!item){
      return res.status(400).send("There is no data with id "+req.params.itemId);
      console.log("There is no data with id "+req.params.itemId);
    }
    else {
      {
        console.log("There is a data");

      }
        res.send(item);
    }

  });
};







exports.update = (req,res)  => {

Item.update({  Category_Id : req.body.Category_Id,  Item_Name : req.body.Item_Name,
  Category_Type: req.body.Category_Type,
  Item_Price   : req.body.Item_Price},{
  where : {FoodItem_Id : req.params.itemId}
}).then(() => {

res.status(200).send("upadte food item with id = "+req.params.itemId);

})

};

exports.delete = (req,res)  => {

  const id = req.params.itemId;

  Item.destroy({

    where : { FoodItem_Id:id}

  }).then(category => {
    if(!category)
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
