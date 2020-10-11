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
  