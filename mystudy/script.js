/* **********************JQUERY********************** */
$(function () {
/* **********************INPUT BLUR 시 텍스트 지우기********************** */
    $(".search input").on("blur", function () {
        $(this).val('');
    });
/* **********************STICKY 겹침 설정********************** */
    $(window).scroll(function() {
        const mainNavHeight = $("#main-nav").outerHeight();
        $(".gnb").css("top", mainNavHeight);
/* **********************HOME-BUTTON********************** */
        const scrollTop = $(window).scrollTop();
        if(scrollTop < mainNavHeight){
            $(".banner-box").css("display", "block")
            $(".home-button").css({
                "transform": "scaleY(0)",
                "transition": "transform .3s ease-in-out"
            })
            $(".slide-right-nav").css({
                "margin-left": "-48px",
                "transition": "margin-left .3s .3s ease-in-out"
            })
        } else {
            $(".banner-box").css("display", "none")
            $(".slide-right-nav").css({
                "margin-left": "0",
                "transition": "margin-left .3s ease-in-out"
            })
            $(".home-button").css({
                "transform": "scaleY(1)",
                "transition": "transform .3s .3s ease-in-out"
            })
        }
    })
/* **********************BEST-IMAGE-BOX-BUTTON-FILL*** */
    $(document).on("mouseover", ".bag", function() {
        $(this).find('i').removeClass("bi-bag").addClass("bi-bag-fill");
    });
    $(document).on("mouseout", ".bag", function() {
        $(this).find('i').removeClass("bi-bag-fill").addClass("bi-bag");
    });
    
    $(document).on("mouseover", ".heart", function() {
        $(this).find('i').removeClass("bi-heart").addClass("bi-heart-fill");
    });
    $(document).on("mouseout", ".heart", function() {
        $(this).find('i').removeClass("bi-heart-fill").addClass("bi-heart");
    });
});
/* **********************JAVASCRIPT**************** */
$(document).ready(function () {
    $('div').addClass("user-select-none");
/* **********************JSON********************** */
    fetch("./best.json")
        .then(rs => rs.json())
        .then(src => {
            const bestCard = src.map(data => {
                let color = data.color;
                let title = data.title;
                let oldPrice = data.cost;
                let newPrice = data.price;
                let discount = data.sale;
                let styleString = '';
                color.forEach(color => { //각 color에 적용
                    if (color == "wine") { //style class 생성
                        styleString += `
                    .color-box .${color} {
                    background-color: purple;
                }
                `
                    } else if (color == "mint") {
                        styleString += `
                    .color-box .${color} {
                    background-color: lightgreen;
                }
                `
                    } else {
                        styleString += `
                    .color-box .${color} {
                    background-color: ${color};
                }
                `
                    }
                });
                const styleElement = document.createElement('style'); //style node 생성
                styleElement.innerHTML = styleString; // style node에 styleString 추가
                document.head.appendChild(styleElement); // head node에 style node 추가
                let allColor = color.map(aColor => {
                    return `<span class="${aColor}"></span>`;
                }).join('')

                return `
                <div class="col-12 col-sm-6 col-md-3 position-relative" style="padding: 15px;">
                <div class="best-item-card position-relative overflow-hidden">
                <div class="best-item-img-1"></div>
                <div class="img-content-box">
                    <div class="color-box">
                        ${allColor}
                    </div>
                    <div class="img-text">${title}</div>
                    <div class="price">
                        <span class="old-price">${oldPrice}</span>
                        <span class="discount">${discount}</span>
                        <span class="new-price">${newPrice}</span>
                    </div>
                </div>
                <div class="best-button-box">
                <button class="btn btn-light bag"><a href="javascript: void(0)" class="text-dark"><i class="bi bi-bag"></i></a></button>
                <button class="btn btn-light heart"><a href="javascript: void(0)" class="text-dark"><i class="bi bi-heart"></i></a></button>
                </div>
                </div>
                </div>
            `
            });
            document.querySelectorAll('.slide-1').forEach(data =>
                data.innerHTML += bestCard.join('')
            );
        });
});