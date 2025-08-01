const a = document.querySelectorAll('a[href="#"]');
a.forEach(function (e) {
    e.addEventListener('click', function (event) {
        event.preventDefault();
    });
});

document.querySelectorAll("div").forEach(all => {
    all.classList.add("user-select-none");
});


let navbar = document.querySelector("#navbar");
const body = document.querySelector("body");
function updateBodyPadding() {
    body.style.paddingTop = navbar.offsetHeight + 'px';
}
updateBodyPadding();
const resizeObserver = new ResizeObserver(entries => {
    for(let entry of entries){
        if (entry.target === navbar) {
        updateBodyPadding();
        };
    };
});
resizeObserver.observe(navbar);

let logo = document.querySelector("#logo");
let navbarContainer = document.querySelector("#navbar-container");
function setContainerMargin() {
    navbarContainer.style.paddingRight = logo.offsetWidth + "px";    
}
setContainerMargin()

document.addEventListener('DOMContentLoaded', () => {
    const typingTextElement = document.getElementById('typing-text');
    const texts = [
        "신세기 에반게리온",
        "이카리 신지",
        "초호기 파일럿"
    ];
    let textIndex = 0;
    let charIndex = 0;
    let isDeleting = false;
    const typingSpeed = 100;
    const deletingSpeed = 50;
    const delayBetweenTexts = 3000;

    function type() {
        const currentText = texts[textIndex];
        if (!isDeleting && charIndex < currentText.length) {
            typingTextElement.textContent += currentText.charAt(charIndex);
            charIndex++;
            setTimeout(type, typingSpeed)
        } else if (isDeleting && charIndex > 0) {
            typingTextElement.textContent = currentText.substring(0, charIndex - 1);
            charIndex--;
            setTimeout(type, deletingSpeed)
        } else {
            isDeleting = !isDeleting;
            if (!isDeleting) {
                textIndex = (textIndex + 1) % texts.length;
            };
            setTimeout(type, delayBetweenTexts);
        };
    };

    if (typingTextElement) {
        type();
    }

    const navbar = document.querySelector('.navbar');
    if (navbar) {
        window.addEventListener('scroll', () => {
            if (window.scrollY > 50) {
                navbar.classList.add('scrolled');
            } else {
                navbar.classList.remove('scrolled');
            };
        });
    };

    const sections = document.querySelectorAll('section[id], main[id="home]');
    const navLinks = document.querySelectorAll('.navbar-nav .nav-link');
    const navHeight = document.querySelector('nav').offsetHeight;

    const observer = new IntersectionObserver((entries) => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                const currentSectionId = entry.target.id;
                navLinks.forEach(link => {
                    link.classList.remove('active');
                });
                const activeLink = document.querySelector(`.navbar-nav .nav-link[href="#${currentSectionId}"]`);
                if (activeLink) {
                    activeLink.classList.add('active')
                };
            };
        });
    }, {
        rootMargin: `-${navHeight}px 0px 0px 0px`,
        threshold: 0.1
    });
    sections.forEach(section => {
        observer.observe(section);
    });
});
