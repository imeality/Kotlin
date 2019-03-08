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

           type            : Sequelize.DOUBLE(100,3),
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
      //       classMethods:{
      // associate:function(model){
      // Location.belongsTo(model.FOODCATEGORY, { foreignKey:'Category_Id', foreignKeyConstraint:true} );
      //                         }
      //
      //                    }

   });











   var Category  =  sequelize.define("FOODCATEGORY", {

   Category_Id :  {

           type             : Sequelize.INTEGER(150),
           autoIncrement    : true,
           allowNull        : false,
           primaryKey       : true,
           autoGenerated    : true,

   },
   Category_Name:{

           type             : Sequelize.STRING(255),
           allowNull        : false

   },
   Category_Image :{
           type             : Sequelize.STRING(255),
           allowNull        : false
   },
   Category_Status :{
           type             : Sequelize.INTEGER(11),
           allowNull        : false,
           defaultValue     : 1
   }

   },{

           createdAt : false,
           updatedAt : false,
           freezeTableName : true

   });



















   // Item.hasOne(Category, { foreignKey: 'Category_Id' })
   // Item.belongsTo(Category, { foreignKey: 'Category_Id' })

   // Item.hasOne(Category);
   //        Item.removeAttribute("id");
//    //        return Item;
// Item.hasOne(Category);



Item.belongsTo(Category, {foreignKey: 'Category_Id'});
Category.hasOne(Item, {foreignKey: 'Category_Id'});
       Item.removeAttribute("id");
       return Item;

 };
