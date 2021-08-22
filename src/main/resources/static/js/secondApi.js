
function addStudent(){
    const name = document.getElementById("name").value;
    const lastName = document.getElementById("lastName").value;
    const age = document.getElementById("age").value;

    let data = {
        name:name,
        lastName:lastName,
        age:age
    };
    axios.post("/secondPage/addStudent",data)
        .then(function (response){
            console.log(response)
        });
};
