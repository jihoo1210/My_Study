/**************************JQUERY**************************/
$(function(){

   $('.nav-item').hover(function(){
     $(this).find('ul.lnb').fadeToggle();
   });

   $('.category').hover(function(){
      const w = $('.container').width();  //container의 가로크기를 읽어 옴
      $('.categorybox').css('width', w+"px"); //categorybox의 가로 크기로 설정함.
      $(this).find('.categorybox').fadeToggle();
   });

   $('.shoping-icon').mouseenter(function(){
       $(this).find('i').removeClass('ri-shopping-bag-4-line').addClass('ri-shopping-bag-4-fill');
   }).mouseleave(function(){
       $(this).find('i').removeClass('ri-shopping-bag-4-fill').addClass('ri-shopping-bag-4-line');
   });

   $('.heart-icon').mouseenter(function(){
       $(this).find('i').removeClass('ri-heart-2-line').addClass('ri-heart-fill');
   }).mouseleave(function(){
       $(this).find('i').removeClass('ri-heart-fill').addClass('ri-heart-2-line');
   });

   $(window).on('scroll', function(){
      const navigation = $('.navigation').offset().top;
      if($(this).scrollTop() > 220){
         $('.navigation').css({
            position : 'fixed',
            top: '45px',
            width: '100%'
         });
      }else{
         $('.navigation').css({
            position: 'static'
         })
      }
   });

  setInterval(bestSlide, 8000);

   let wrapperWidth = 0;
   let pgCount = 0;
   const totalPage = 3;

   //페이지버튼 생성
   for(let i=0; i < totalPage; i++){
      if(i==0){ 
              $('#page').append(`<li data-index="${i}" class="active"></li>`);
      }else{
              $('#page').append(`<li data-index="${i}"></li>`);
      }       
   }

 
     function updatePage(){
        $('#page li').removeClass('active')
                     .eq(pgCount).addClass('active');
     }

     function bestSlide(){
        pgCount++;
        if(pgCount == totalPage){
            pgCount = 0;
        }
        updatePage();
   
        $(".slide-wrapper-in").animate({
            left: -wrapperWidth + "px"
        }, 300, function(){
            //1. 첫 번째 슬라이드 복제 후 뒤로 이동
            const first = $('.slide-wrapper-in .slide-page').first();
            first.clone().appendTo('.slide-wrapper-in')
            first.remove();
            $('.slide-wrapper-in').css('left', 0);
        });

     }


    function preBestSlide(){
    $("#prev").on("click", function(){
        if(pgCount < 0){
            pgCount = totalPage - 1;
        }
        updatePage();

        const last = $(".slide-wrapper-in .slide-page").last();
        last.clone().prependTo('.slide-wrapper-in')
     });
    }

     $("#next").on("click", function(){
        bestSlide();
     });


fetch("../2025-07-23/best.json")
.then(res => res.json())
.then(rs => {

   let slidePage = "";
   let colPage = "";
   for(let i = 0; i < 3; i++) {
      colPage = "";

      for(let j =0; j < 8; j++) {
         const index = i * 8 + j;
         const data = rs[index];
         
         //색상처리
         let colorHtml = "";
         data.color.forEach(co => {
            colorHtml += `<span class="${co}"></span>`;
         });

         //상품목록 만들기
         colPage += `
            <div class="col-md-3 my-3">
                        <a href="#" class="img-best-box">
                            <img src="${data.img}" alt="${data.alt}">
                            <div class="pd-best-box text-center">
                                <div class="pd-color">
                                    ${colorHtml}
                                </div>
                                <div class="best-title">${data.title}</div>
                                <div class="pd-best-pay">
                                <del>${data.cost}원</del>
                                <span class="sail">${data.sale}</span>
                                <span class="money">${data.price}원</span>
                                </div>
                            </div>
                            <div class="btn-box">
                                    <button type="button" class="best-cart">
                                        <i class="ri-shopping-bag-4-line"></i>
                                    </button>
                                    <button type="button" class="best-heart">
                                        <i class="ri-heart-line"></i>
                                    </button>
                            </div>
                        </a>
                    </div>
         `;
      }
      slidePage += `<div class="row slide-page">${colPage}</div>`;

   }
     document.querySelector(".slide-wrapper-in").innerHTML = slidePage;

        const pageHeight = $('.slide-page:first-child').outerHeight(true);
        $('.slide-wrapper').css('height', pageHeight+"px");
        wrapperWidth = $(".slide-wrapper").width();
     
})
.catch(err=> console.error("🤢 데이터 로딩에 실패했습니다.", err));

});
/**************************JAVASCRIPT**************************/
let slideIndex = 1;
showSlides(slideIndex);

// 5초마다 다음 슬라이드로 자동 전환
setInterval(function(){
    pushSlides(1);
}, 5000);

const input = document.getElementById("searchInput");
const form = document.getElementById("search");

input.addEventListener("focus", function(){
    form.classList.add('focus');
});

input.addEventListener("blur", function(){
    form.classList.remove("focus");
});

// 다음 슬라이드로 이동
function pushSlides(n){
    showSlides(slideIndex += n);
}

// 이전 슬라이드로 이동
function currentSlides(n){
    showSlides(slideIndex -= n);
}

// 슬라이드 표시
function showSlides(n) {
    let i;
    let slides = document.getElementsByClassName("mySlides");

    // 다음 슬라이드에 대한 예외 처리 (인덱스가 범위를 벗어날 때)
    if(n > slides.length) {
        slideIndex = 1;
    }
    // 이전 슬라이드에 대한 예외 처리 (인덱스가 0보다 작거나 같을 때)
    if(n < 1) {
        slideIndex = slides.length;
    }

    // 모든 슬라이드 숨기기
    for(i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }

    // 현재 슬라이드 보이기
    slides[slideIndex-1].style.display = "block";
}
