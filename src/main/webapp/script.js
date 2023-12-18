const url = "http://localhost:8000/LoginPage/api/v1.0/trypost";
function handler(e){
    e.preventDefault();
    const formObj = {
       'id':username.value,
       'password':password.value
    };
    console.log(formObj);
    console.log("Sending Request Now");
    const options = {
        method:'POST',
        headers: {
        'Content-Type': 'application/json', 
        },
        body:JSON.stringify(formObj)
    };

    fetch(url,options).then((response)=>{
        return response.json();
    }).then((value)=>{
        console.log("Received");
        console.log(value);
        let disp;
        if(value.status!=200){
            disp = "Sorry some error occured"; 
        }else if(!value.responseObject.found){
            disp = "Oops! wrong password or name";
        }else{
            disp = "Logged in Successfully";
        }
        alert(disp);
        username.value = " ";
        password.value = "";
     }).catch(console.log);
}
document.getElementById("formID").addEventListener('submit',handler);