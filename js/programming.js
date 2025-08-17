$(function() {
    $("body").css({
        "padding-top": $("header").height()
    })
    $(document).on('click', "section ul.navbar-nav a.nav-link", function() {
        if(!$(this).hasClass('active')){
        $("section ul.navbar-nav a.nav-link").removeClass('active');
        $(this).addClass('active')
        } else {$(this).removeClass('active')}
    })
    fetch("./js/json.json")
    .then(rs => rs.json())
    .then(data => {
        const list = data[0].contents.map(item => {
            return `<li class='nav-item'><a href='javascript: void(0)' class='nav-link position-relative'>${item}</a></li>`
        })
        $("section.navbar ul.navbar-nav").append(list);
    })
    .catch(e => {console.log("error: " + e)})
})