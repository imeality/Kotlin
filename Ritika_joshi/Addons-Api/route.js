module.exports = function(app)
{

 const addon = require("./controller.js");

 app.post("/api/addon",addon.create);
 app.get("/api/addon",addon.findAll);
 app.get("/api/addon/:addonId",addon.findById);
 app.put("/api/addon/:addonId",addon.update);
 app.delete("/api/addon/:addonId",addon.delete);
 app.get("/api/addoninventory",addon.findAllData);
 app.get("/api/addoninventory/:addonId",addon.findAllById);
 app.get("/api/addonkeyword/:keyword",addon.findByKeyword);
 app.get("/api/addonlessprice/:keyword",addon.findByLessPrice);
 app.get("/api/addongreaterprice/:keyword",addon.findByGreaterPrice);
}
