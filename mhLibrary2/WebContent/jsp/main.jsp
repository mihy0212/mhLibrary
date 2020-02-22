<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Swiper demo</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">

  <!-- Link Swiper's CSS -->
  <link rel="stylesheet" href="css/slide.css">

  <!-- Demo styles -->
  <style>
    html, body {
      position: relative;
      height: 100%;
    }
    body {
      background: #eee;
      font-family: Helvetica Neue, Helvetica, Arial, sans-serif;
      font-size: 14px;
      color:#000;
      margin: 0;
      padding: 0;
    }
    .swiper-container {
      width: 100%;
      height: 50%;
    }
    .swiper-slide {
      background-position: center;
      background-size: cover;
    }
  </style>
</head>
<body>
  <!-- Swiper -->
  <div class="swiper-container">
    <div class="swiper-wrapper">
      <div class="swiper-slide" style="background-image:url(img/img_library_slide1.jpg)"></div>
      <div class="swiper-slide" style="background-image:url(img/img_library_slide2.jpg)"></div>
      <div class="swiper-slide" style="background-image:url(img/img_library_slide3.jpg)"></div>
      <div class="swiper-slide" style="background-image:url(img/img_library_slide4.jpg)"></div>
      <div class="swiper-slide" style="background-image:url(img/img_library_slide5.jpg)"></div>
    </div>
    <!-- Add Pagination -->
    <div class="swiper-pagination swiper-pagination-white"></div>
    <!-- Add Arrows -->
    <div class="swiper-button-next swiper-button-white"></div>
    <div class="swiper-button-prev swiper-button-white"></div>
  </div>

  <!-- Swiper JS -->
  <script src="js/slide.js"></script>

  <!-- Initialize Swiper -->
  <script>
    var swiper = new Swiper('.swiper-container', {
      spaceBetween: 30,
      effect: 'fade',
      pagination: {
        el: '.swiper-pagination',
        clickable: true,
      },
      navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
      },
    });
  </script>
</body>
</html>