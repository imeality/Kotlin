module.exports = function(app)
{

 const item = require("./controller.js");

 app.post("/api/fooditem",item.create);
 app.get("/api/fooditem",item.findAll);
 app.get("/api/fooditem/:itemId",item.findById);
 app.put("/api/fooditem/:itemId",item.update);
 app.delete("/api/fooditem/:itemId",item.delete);
 app.get("/api/itemcategory",item.findAllData);
 app.get("/api/itemcategory/:itemId",item.findAllById);
 app.get("/api/itemkeyword/:keyword",item.findByKeyword);
 app.get("/api/itemlessprice/:keyword",item.findByLessPrice);
 app.get("/api/itemgreaterprice/:keyword",item.findByGreaterPrice);
}
 
