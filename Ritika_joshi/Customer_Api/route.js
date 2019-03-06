 module.exports = function(app)
 {

const customer = require('./controller.js');

app.post("/api/customer",customer.create);              //for create customer

app.get("/api/customer/:customerId",customer.findById);

 }
