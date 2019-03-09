module.exports = function(app)
{

const inventory = require("./controller.js");

app.post("/api/inventory",inventory.create);
app.get("/api/inventory",inventory.findAll);
app.get("/api/inventory/:inventoryId",inventory.findById);
app.put("/api/inventory/:inventoryId",inventory.update);
app.delete("/api/inventory/:inventoryId",inventory.delete);
app.get("/api/findbykeyword/:keyword",inventory.findByKeyword);
app.get("/api/findbygreaterqutantiy/:keyword",inventory.findByGreaterQutantiy);
app.get("/api/findbylessqutantiy/:keyword",inventory.findByLessQuantity);


}
