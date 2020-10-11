$(".navTrigger").click(function () {
    $(this).toggleClass("active");
    console.log("Clicked menu");
    $("#mainListDiv").toggleClass("show_list");
    $("#mainListDiv").fadeIn();
  });
  
  $(window).scroll(function () {
    if ($(document).scrollTop() > 100) {
      $(".nav div.logo a").removeClass("affix2");
      $(".nav div.main_list ul li a").removeClass("affix2");
      $(".nav div.logo a").addClass("affix3");
      $(".nav div.main_list ul li a").addClass("affix3");
      $(".nav").addClass("affix");
      console.log("OK");
    } else if ($(document).scrollTop() <= 100) {
      $(".nav").removeClass("affix");
      $(".nav div.logo a").removeClass("affix3");
      $(".nav div.main_list ul li a").removeClass("affix3");
      $(".nav div.logo a").addClass("affix2");
      $(".nav div.main_list ul li a").addClass("affix2");
    }
  });
  
  // api url 
const api_url = 
"https://api.rootnet.in/covid19-in/notifications"; 

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
for (let r of data1.data.notifications) { 
    
          tab += `
          <tr>
        <td class="text-left">${r.title} </td>
        <td class="text-left"><a href="${r.link}" target="_blank" style="color:#4285f4">[Link]</a></td>
        </tr>`; 
    
} 
// Setting innerHTML as tab variable 
document.getElementById("notf").innerHTML = tab; 

} 
