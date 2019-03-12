module.exports = (sequelize,Sequelize) => {

const Admin= sequelize.define('ADMIN',{

Admin_Id :{

               type             : Sequelize.INTEGER(50),
               autoIncrement    : true,
               allowNull        : false,
               primaryKey       : true,
               autoGenerated    : true,
},

Password : {
               type:Sequelize.STRING(50),
               allowNull:false

},

Phone_No  :  {

             type:Sequelize.STRING(20),
             allowNull:false

},

Admin_Status  :  {

             type:Sequelize.INTEGER(10),
             allowNull:false,
             defaultValue:1

}

},{

             updatedAt:false,
             createdAt:false,
             freezeTableName:true



});


Admin.removeAttribute('id');

return Admin;
}
