h1 = document.getElementById("h1")


function getStudentList(){
    let out = "";
    axios.get("/getAll")
        .then(function (response){
            if (response.status===200){
                console.log(response);

                const outString = JSON.stringify(response.data.object);
                const data = JSON.parse(outString);
                data.forEach(function (d){
                    out+="    <tr>" +
                        "        <td id=\"idp\" class='bg-info'>"+d.id+"</td>\n" +
                        "        <td id=\"namep\">"+d.name+"</td>\n" +
                        "         <td id=\"lastNamep\">"+d.lastName+"</td> " +
                        "           <td id=\"agep\">"+d.age+"</td> " +
                        "    </tr>"
                });
                document.getElementById("root").innerHTML=out;


            }
        })
}





function f(){
axios.get("/api")
.then(function (response){
        if (response.status===200) {
            console.log(response);
            h1.innerHTML = response.data
        }
});

};