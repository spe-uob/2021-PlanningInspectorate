//for security CORS
// npm install cors?

import express from "express";
import cors from "cors";

const app = express();

app.use(
  cors({
    //credentials: true, //for cookie
    origin: "http://localhost:8080/api/v1/dbCrud",
    methods: ["GET", "POST", "PUT", "DELETE"], //should be passed individually?

  })
);
//for security CORS
import express from "express";
import cors from "cors";

const app = express();

app.use(
  cors({
    //credentials: true, //for cookie
    origin: "http://localhost:8082/manageDatabase",
    methods: ["GET", "POST", "PUT"], //should be passed individually?

  })
);


app.get("/getRecords",GetRecordApi(req, res))  (
  res.send(data) //json //check
);

app.put("/editRecords", EditRecordApi(req,res))(
  res.send(data)
);


app.post("/addRecords", AddRecordApi(req, res))(
    res.send(data)
);

//--------------------------------------------------

app.get("/getRecords",GetRecordApi(req, res))  (
  res.send(data) //json //check
);

app.put("/editRecords", EditRecordApi(req,res))(
  res.send(data)
);


app.post("/addRecords", AddRecordApi(req, res))(
    res.send(data)
);

//------------------------------------
// For Delete
app.options('http://localhost:8080/api/v1/dbCrud', cors()) // enable pre-flight request for DELETE request
app.del('/deleteRecords', cors(), DeleteRecordApi(req,res)) {
  res.json({msg: 'implement functions'})
})