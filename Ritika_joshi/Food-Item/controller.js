const db = require("./config.js");

const Item = db.item;

const Category = db.category;

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



exports.findByKeyword = (req,res) => {


let keyword = req.params.keyword;
Item.findAll({
  //attributes: ['Item_Name', 'Category_Type','Item_Price'],
where :
{
$or:[
{ Item_Name     : { $like : '%' + keyword +'%'} },
{ Category_Type : { $like : '%' + keyword+'%'}  },
{ Item_Price    : {$eq: keyword} }
]
}
}).then(item => {

  if(item!=0)
  {
        console.log("there is a item with this name "+req.params.keyword);
      //  res.status(200).send("there is a item with this name "+req.params.keyword);
        res.send(item);
  }
  else {
    {
        console.log("there is no item with this name"+req.params.keyword);
          res.status(200).send("there is no item with this name "+req.params.keyword);

    }
  }


});

};









exports.findByGreaterPrice = (req,res) => {


let keyword = req.params.keyword;

Item.findAll({
  //attributes: ['Item_Name', 'Category_Type','Item_Price'],
where :
{


Item_Price    :  {$gte : keyword}


}
}).then(item => {

  if(item!=0)
  {
        console.log("there is item greater then or equal to"+req.params.keyword);

      res.send(item);
  }
  else {
    {
        console.log("there is no item greater then or equal to"+req.params.keyword);
          res.status(200).send("there is no item greater then or equal to"+req.params.keyword);

    }
  }


});

};
















exports.findByLessPrice = (req,res) => {


let keyword = req.params.keyword;
Item.findAll({
  //attributes: ['Item_Name', 'Category_Type','Item_Price'],
where :
{
 Item_Price    : {$lte: keyword}
}
}).then(item => {

  if(item!=0)
  {
        console.log("there is item less then or equal to"+req.params.keyword);

      res.send(item);
  }
  else {
    {
        console.log("there is no item less then or equal to"+req.params.keyword);
          res.status(200).send("there is no item less then or equal to"+req.params.keyword);

    }
  }


});

};
















exports.findAllData = (req,res) => {

Item.findAll({
  include: [
    {
      model: db.category,
      required: true

    }
  ]
}).then(item => {

  res.send(item);
});

};













exports.findAllById = (req,res) => {

 Item.findAll({
   where: {FoodItem_Id : req.params.itemId},
   include : [
     {
       model : db.category,
       required: true
     }
   ]
 }).then(item => {

     if(item!=0)
     {
       console.log("There is data");
         res.send(item);
     }

     else {
       res.status(200).send("there is no item with this id "+req.params.itemId);
       console.log("thre is no item with this id "+req.params.itemId);
     }



 });
};
















exports.findById = (req,res)  =>  {

  Item.findById(req.params.itemId).then(item => {

    if(!item){
      return res.status(400).send("There is no data with id "+req.params.itemId);
      console.log("There is no data with id "+req.params.itemId);
    }
    else {
      {
        console.log("There is a data");
        res.send(item);
      }

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

  }).then(item => {
    if(!item)
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
