 module.exports = (sequelize,Sequelize) => {

   var Item = sequelize.define("FOODITEM",{

	FoodItem_Id:{

            type           : Sequelize.INTEGER(150),
            autoIncrement  : true,
            primaryKey     : true,
            allowNull      : false,
            autoGenerated  : true,

  },

  Category_Id : {

           type            : Sequelize.INTEGER(150),
           allowNull       : false
  },

  Item_Name   : {

           type            : Sequelize.STRING(255),
           allowNull       : false
  },
  Category_Type : {

           type            : Sequelize.STRING(255),
           allowNull       : false

  },

  Item_Price : {

           type            : Sequelize.FLOAT(50,2),
           allowNull       : false

  },

  Status :
  {
            type            : Sequelize.INTEGER(11),
            allowNull       : false,
            defaultValue    : 1

  }
}
 ,{

            createdAt       : false,
            updatedAt       : false,
            freezeTableName : true

   });


       Item.removeAttribute("id");

       return Item;



 };
 
