console.log("Hello World!!!");
//
//fetch("http://localhost:8080/api/v1/player")
//.then((response)=>{return response.json()})
//.then(
//    (parsedResponse) => {
//        console.log(parsedResponse);
//
//        parsedResponse.forEach(element => {
//            console.log(element.id + " -- " + element.name);
//
//            let wrapperDiv = document.createElement("div");
//            wrapperDiv.className = "card";
//
//            let cardTitleDiv = document.createElement("div");
//            cardTitleDiv.className = "card-title";
//            cardTitleDiv.textContent = element.id;
//
//            let cardDescDiv = document.createElement("div");
//            cardDescDiv.className = "card-description";
//            cardDescDiv.textContent = element.name;
//
//            wrapperDiv.appendChild(cardTitleDiv);
//            wrapperDiv.appendChild(cardDescDiv);
//
//            let cardBoardDiv = document.getElementById("cardBoard");
//            cardBoardDiv.append(wrapperDiv);
//        });
//    }
//)



const allPlyers=[]
/*            functions               */



console.log("DOne with Hello World!!!");


function createPlayer(){
  const  player={
    name:document.getElementById("name").value,
    gender:document.querySelector('input[name="gender"]:checked').value,
    country:document.getElementById("country").value
    }



var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");

var raw = JSON.stringify(player);

var requestOptions = {
  method: 'POST',
  headers: myHeaders,
  body: raw,
  redirect: 'follow'
};

fetch("http://localhost:9000/api/v1/player",requestOptions)
                                             .then(response => response.text())
                                             .then(result => console.log(result))
                                             .catch(error => console.log('error', error));

}




let parentElement =document.getElementById("parentList")
fetch("http://localhost:9000/api/v1/player")
 .then((response) => {return response.json()})
.then((pasreResponse)=>{

pasreResponse.forEach(e =>{

let newItem = document.createElement("div");

newItem.innerHTML+= '<p><span style="color: #545871;font-weight: bolder;">id :   </span>' +  e.id + '</p>';
 newItem.innerHTML+= '<p><span style="color: #545871;font-weight: bolder;">name :   </span>' +  e.name + '</p>';
   newItem.innerHTML += '<p><span style="color: #545871;font-weight: bolder;">gender :   </span>' +  e.gender + '</p>';
   newItem.innerHTML += '<p><span style="color: #545871;font-weight: bolder;">country :   </span>' +  e.country + '</p>';
newItem.style.backgroundColor = "rgb(235 208 206 / 30%)";
 newItem.style.margin= "5PX";
    newItem.style.borderRadius= "10px";
    var inputElement = document.createElement('input');
inputElement.type = "button"
inputElement.value="update this player "
inputElement.addEventListener('click', function(){
  updateTest(e);
});
newItem.append(inputElement)
 parentElement.appendChild(newItem)
})
})
  .catch(error => console.log('error', error));





  function updatePlayer(){



    const  player={

      name:"",
      gender:"",
      country:""
      }
   player.id=document.getElementById("playerid").value
      player.name= document.getElementById("uname").value;
      player.gender= document.querySelector('input[name="ugender"]:checked').value;
      player.country= document.getElementById("ucountry").value;

console.log(player)



 var myHeaders = new Headers();
 myHeaders.append("Content-Type", "application/json");
 myHeaders.append("Authorization", "Basic YXM6MTIz");

 var raw = JSON.stringify(player);

 var requestOptions = {
   method: 'PUT',
   headers: myHeaders,
   body: raw,
   redirect: 'follow'
 };


fetch("http://localhost:9000/api/v1/player/"+document.getElementById("playerid").value, requestOptions)
  .then(response => response.text())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));
  }

function registerOnePlayer(){
var requestOptions = {
  method: 'GET',
  redirect: 'follow'
};

fetch("http://localhost:9000/api/v1/player/"+document.getElementById("playerid").value, requestOptions)
.then((response) => {return response.json()})
.then((e)=>{
alert(e.name +" "+e.gender+" "+e.country)

document.getElementById("playerid").value=e.id
   document.getElementById("uname").value=e.name
    document.querySelector('input[name="ugender"]:checked').value=e.gender
 document.getElementById("ucountry").value=e.country



})
  .catch(error => console.log('error', error));




}
function deletePlayer(){


var requestOptions = {
  method: 'DELETE',
  redirect: 'follow'
};
fetch("http://localhost:9000/api/v1/player/"+document.getElementById("dplayerid").value, requestOptions)
  .then(response => response.text())
  .then(result => console.log(result))

}

function updateTest(e){
document.getElementById("playerid").value=e.id
   document.getElementById("uname").value=e.name
   const option1 = document.getElementById('c1');
   const option2 = document.getElementById('c2');
   if(e.gender=='male'){
    option1.checked=true
    option2.checked=false
   }
   else{
    option1.checked=false
    option2.checked=true
   }


 document.getElementById("ucountry").value=e.country



}