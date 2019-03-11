const db = require("./config.js");

const Category = db.category;

exports.create  = (req,res)  =>  {

 Category.create({

        Category_Id    :  req.body.Category_Id,
        Category_Name  :  req.body.Category_Name,
        Category_Image :  req.body.Category_Image
   // Category_Status
 }).then(category  => {

   res.send(category);

 });

};


//find all category list

exports.findAll = (req,res)  =>  {

  Category.findAll().then(category =>
  {
      res.send(category);
  })
};


//find category by id

exports.findById = (req,res)  =>  {

  Category.findById(req.params.categoryId).then(category => {

    if(!category){
        console.log("There is no data with id "+req.params.categoryId);
      return res.status(400).send("There is no data with id "+req.params.categoryId);

    }
    else {
      {
        console.log("There is a data");
        res.send(category);
      }
    }

  });
};




//find by findByKeyword


exports.findByKeyword = (req,res) => {


let keyword = req.params.keyword;
Category.findAll({
  //attributes: ['Item_Name', 'Category_Type','Item_Price'],
where :


{
  Category_Name     : { $like : '%' + keyword +'%'}
 }


}).then(category => {

  if(category!=0)
  {
        console.log("there is a item with this name "+req.params.keyword);
      //  res.status(200).send("there is a item with this name "+req.params.keyword);
        res.send(category);
  }
  else {
    {
        console.log("there is no item with this name"+req.params.keyword);
          res.status(200).send("there is no item with this name "+req.params.keyword);

    }
  }


});

};


//update category with the help of id
exports.update = (req,res)  => {

Category.update({  Category_Name : req.body.Category_Name,Category_Image : req.body.Category_Image},{
  where : {Category_Id : req.params.categoryId}
}).then(() => {

res.status(200).send("upadte category with id = "+req.params.categoryId);

})

};

exports.delete = (req,res)  => {

  const id = req.params.categoryId;

  Category.destroy({

    where : {Category_Id:id}

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
