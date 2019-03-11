 module.exports = function(app)
 {

const customer = require('./controller.js');

app.post("/api/customer",customer.create);              //for create customer
app.get("/api/customer",customer.findAll);
app.get("/api/customer/:customerId",customer.findById);
app.put("/api/customer/:customerId",customer.update);
app.get("/api/customerkeyword/:keyword",customer.findByKeyword);

app.delete("/api/customer/:customerId",customer.delete);
 }
