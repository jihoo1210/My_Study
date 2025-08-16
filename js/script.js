$(function() {
    let defaultScroll = $(this).scrollTop();
    $("nav.navbar").css({"transform": "translateY(100%)"})
    $(window).on("scroll", function() {
        navbarMove();
    });
    function navbarMove() {
        if(run){
        let currentScroll = $(window).scrollTop();
        if(currentScroll > defaultScroll){
            $("nav.navbar").css({"transform": "translateY(100%)"})
        } else {
            $("nav.navbar").css({"transform": "translateY(0)"})
        }
        $(".lnb").css("bottom", $("nav.navbar").height());
        defaultScroll = currentScroll;
        }
    }

    $(document).on("mouseenter", ".gnb > li", function() {
        $(this).find(".lnb").css("max-height", "1000px");
    });
    $(document).on("mouseleave", ".gnb > li", function() {
        $(this).find(".lnb").css("max-height", "0px");
    });

    let run = true;
    $("p a.logo").on("click", function() {
        if(run){
            $(this).css("text-shadow", "0 1px rgba(0, 0, 0, 1)")
            $("aside").css("transform", "translateX(0)")
            $("nav.navbar").css("transform", "translateY(0)");
            $(".lnb").css("max-height", "1000px");
            $(".lnb").css("bottom", $("nav.navbar").height());
            return run = false;
        } else {
            $(this).css("text-shadow", "0 1px rgba(0, 0, 0, 0)")
            $("aside").css("transform", "translateX(-100%)")
            $("nav.navbar").css("transform", "translateY(100%)");
            $(".lnb").css("bottom", $("nav.navbar").height());
            $(".lnb").css("max-height", "0");
            return run = true;
        }
    })
    fetch("./js/json.json")
    .then(rs => rs.json())
    .then(data => {
        const list = data.map(data => {
            const contents = data.contents.map(ls => {
                return `<li class="nav-item"><a href="javascript: void(0)" class="nav-link text-uppercase">${ls}</a></li>`
            }).join('');
            return `
            <li class="nav-item position-relative">
                <a href="javascript: void(0)" class="nav-link text-uppercase font-weight-bold py-3">${data.title}</a>
                <ul class="lnb navbar-nav position-absolute flex-column text-center font-weight-bold" style='background-color: rgba(0, 0, 0, .5)';>
                    ${contents}
                </ul>
            </li>
            `
        });
        //태그 끝에 해당 요소 추가
        $(".gnb").append(list.join(''));
    }) 
    .catch(function(e){
        console.log(`오류 발생: ${e}`)
    })

    // 코드 수정
fetch("./js/main.json")
    .then(rs => rs.json())
    .then(data => {
        let list = '';
        let count = 0;
        let scrollspy = ''; // scrollspy 변수를 누적할 빈 문자열로 초기화

        for (let i = 0; i < data.length; i += 3) {
            const group = data.slice(i, i + 3);
            let imgTags = group.map(item => {
                return `<img src='${item.src}' alt='${item.alt}' class='col-4 img-fluid' style="padding: 0px;"></img>`;
            }).join('');

            list += `<div id="sec-${i}" class="w-100">${imgTags}</div>`; // a 태그의 href 값을 #i로 수정하여 스크롤 스파이와 연결

            // group 배열의 각 아이템에 직접 접근하여 alt 속성 가져오기
            const firstAlt = group[0] ? group[0].alt : '';
            const secondAlt = group[1] ? group[1].alt : '';
            const thirdAlt = group[2] ? group[2].alt : '';
            const groupAltText = `${firstAlt} | ${secondAlt} | ${thirdAlt}`;
            if(count == 0){scrollspy += `<li class="nav-item"><a href="#sec-${i}" class="nav-link">${groupAltText}</a></li>`; count++;}
            else scrollspy += `<li class="nav-item"><a href="#sec-${i}" class="nav-link">${groupAltText}</a></li>`; // p 태그에 id를 i로 설정하고, 변수를 누적하여 추가
        }

        $(".main").append(list);
        $("#scrollspy").append(scrollspy);
        $('aside').scrollspy('refresh');
    })
    .catch(e => console.log(`오류 발생: ${e}`));
})