module.exports = function(app)
{

  const category = require("./controller.js");

  app.post("/api/category",category.create);
  app.get("/api/category",category.findAll);
  app.get("/api/category/:categoryId",category.findById);
  app.put("/api/category/:categoryId",category.update);
  app.delete("/api/category/:categoryId",category.delete);


}
