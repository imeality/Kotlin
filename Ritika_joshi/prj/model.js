

module.exports = (sequelize,Sequelize)=>{

const Customer = sequelize.define('CUSTOMER_DETAIL',{

cust_name  :  {

type:Sequelize.STRING 

},


cust_phone_number :  {

type:Sequelize.INTEGER
},


cust_email  :  {

type:Sequelize.STRING

}


});


return Customer;

}
