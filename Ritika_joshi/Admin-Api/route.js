module.exports = function(app)
{

  const admins = require("./controller.js");


  app.post("/api/admin",admins.create);

  app.get("/api/admin",admins.findAll);
  //
  app.get("/api/admin/:adminId",admins.findById);

  app.put("/api/admin/:adminId",admins.update);

  app.delete("/api/admin/:adminId",admins.delete);

}
 
