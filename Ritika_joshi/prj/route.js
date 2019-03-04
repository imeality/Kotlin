module.exports = function(app)
{

const customers = require('controller.js');

//create a new customer

app.post('/api/customer',cutomers.create);

//retrieve all data

app.get('/api/customer',customers.findAll);

//Retrieve a single Customer by Id

app.get('/api/customer/:customerId',customer.findbyId);

//update a Customer with Id

app.put('/api/cutomer/:cutomerId',customer.update);

//delete a customer with id

app.delete('/api/customer/:customerid',customer.delete);


}
