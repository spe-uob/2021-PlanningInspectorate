//for security CORS
//but should be wrong
//for now, reference(https://www.youtube.com/watch?v=PNtFSVU-YTI)
fetch("http://localhost:8080/api/v1/dbCrud", .{ method: 'PUT'})
    .then(res -> res.json())
    .then(res -> console.log(data)) //I'm sure it's wrong