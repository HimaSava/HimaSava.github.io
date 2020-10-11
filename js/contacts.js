 // api url 
 const api_url = 
 "https://api.rootnet.in/covid19-in/contacts"; 
 
 // Defining async function 
 async function getapi(url) { 
 
 // Storing response 
 const response = await fetch(url); 
 
 // Storing data in form of JSON 
 var data1 = await response.json(); 
 console.log(data1); 
 if (response) { 
   hideloader(); 
 } 
 show(data1); 
 } 
 // Calling that async function 
 getapi(api_url); 
 
 // Function to hide the loader 
 function hideloader() { 
 document.getElementById('loading').style.display = 'none'; 
 } 
 // Function to define innerHTML for HTML table 
 function show(data1) { 
 let tab = 
   ``; 
 
 // Loop to access rows 
 for (let r of data1.data.contacts.regional) { 
     
           tab += `
           <tr>
         <td class="text-left">${r.loc} </td>
         <td class="text-left">${r.number}</td>
         </tr>`; 
     
 } 
 // Setting innerHTML as tab variable 
 document.getElementById("notf").innerHTML = tab; 
 
 } 