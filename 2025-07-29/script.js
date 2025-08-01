// DOMContentLoaded 이벤트는 HTML 문서가 완전히 로드되고 파싱되었을 때 발생합니다.
// 이를 통해 스크립트가 실행될 때 모든 HTML 요소가 준비되었음을 보장합니다.
document.addEventListener('DOMContentLoaded', () => {
    // 테마 토글 버튼과 아이콘, body 요소를 JavaScript 변수로 가져옵니다.
    const themeToggleButton = document.getElementById('theme-toggle-button');
    const themeIcon = document.getElementById('theme-icon');
    const body = document.body;

    // 테마를 설정하는 함수 정의
    // 이 함수는 'dark' 또는 'light' 값을 인자로 받아 body에 클래스를 추가/제거하고,
    // 아이콘을 변경하며, 로컬 스토리지에 테마 설정을 저장합니다.
    const setTheme = (theme) => {
        if (theme === 'dark') {
            // body에 'dark-mode' 클래스를 추가하여 다크 모드 CSS 변수를 활성화합니다.
            body.classList.add('dark-mode');
            // 네비게이션 바의 배경 및 텍스트 클래스를 변경합니다.
            // (CSS 변수를 사용하기 때문에 이 부분은 선택 사항이지만, Bootstrap 클래스 오버라이드를 위해 필요할 수 있습니다.)
            document.querySelector('.navbar').classList.remove('navbar-light', 'bg-light');
            document.querySelector('.navbar').classList.add('navbar-dark', 'bg-dark');
            // 푸터의 배경 및 텍스트 클래스를 변경합니다.
            document.querySelector('footer').classList.remove('bg-light', 'text-dark'); // 혹시 모를 충돌 대비
            document.querySelector('footer').classList.add('bg-dark', 'text-white'); // 다크 모드 푸터는 어두운 배경 밝은 텍스트 유지

            // 테마 아이콘을 달 아이콘으로 변경합니다.
            themeIcon.classList.remove('bi-brightness-high-fill'); // 밝은 테마 아이콘 제거
            themeIcon.classList.add('bi-moon-fill'); // 어두운 테마 아이콘 추가
            // 접근성을 위한 aria-label 텍스트를 변경합니다.
            themeToggleButton.setAttribute('aria-label', '밝은 테마로 변경');
            // 로컬 스토리지에 'dark' 테마를 저장하여 사용자의 선호도를 기억합니다.
            localStorage.setItem('theme', 'dark');
        } else {
            // body에서 'dark-mode' 클래스를 제거하여 라이트 모드 CSS 변수를 활성화합니다.
            body.classList.remove('dark-mode');
            // 네비게이션 바의 배경 및 텍스트 클래스를 변경합니다.
            document.querySelector('.navbar').classList.remove('navbar-dark', 'bg-dark');
            document.querySelector('.navbar').classList.add('navbar-light', 'bg-light');
            // 푸터의 배경 및 텍스트 클래스를 변경합니다.
            document.querySelector('footer').classList.remove('bg-dark', 'text-white'); // 혹시 모를 충돌 대비
            document.querySelector('footer').classList.add('bg-light', 'text-dark'); // 라이트 모드 푸터는 밝은 배경 어두운 텍스트

            // 테마 아이콘을 해 아이콘으로 변경합니다.
            themeIcon.classList.remove('bi-moon-fill'); // 어두운 테마 아이콘 제거
            themeIcon.classList.add('bi-brightness-high-fill'); // 밝은 테마 아이콘 추가
            // 접근성을 위한 aria-label 텍스트를 변경합니다.
            themeToggleButton.setAttribute('aria-label', '어두운 테마로 변경');
            // 로컬 스토리지에 'light' 테마를 저장합니다.
            localStorage.setItem('theme', 'light');
        }
    };

    // 페이지 로드 시 로컬 스토리지에서 저장된 테마 설정을 불러옵니다.
    const savedTheme = localStorage.getItem('theme');
    // 만약 저장된 테마가 있다면 그 테마로 설정합니다.
    if (savedTheme) {
        setTheme(savedTheme);
    } else {
        // 저장된 테마가 없다면, 사용자의 OS 테마 설정을 확인합니다.
        // window.matchMedia('(prefers-color-scheme: dark)').matches는 OS가 다크 모드인 경우 true를 반환합니다.
        if (window.matchMedia && window.matchMedia('(prefers-color-scheme: dark)').matches) {
            setTheme('dark'); // OS가 다크 모드라면 다크 모드로 설정
        } else {
            setTheme('light'); // OS가 라이트 모드거나 설정이 없다면 라이트 모드로 설정
        }
    }

    // 테마 토글 버튼에 클릭 이벤트 리스너를 추가합니다.
    themeToggleButton.addEventListener('click', () => {
        // 현재 body에 'dark-mode' 클래스가 있는지 확인하여 현재 테마를 판단합니다.
        if (body.classList.contains('dark-mode')) {
            setTheme('light'); // 다크 모드라면 라이트 모드로 변경
        } else {
            setTheme('dark'); // 라이트 모드라면 다크 모드로 변경
        }
    });

    // 검색 토글 기능 (아직 기능 구현은 안함, UI 토글만)
    const searchToggleButton = document.getElementById('search-toggle-button');
    const searchInputContainer = document.getElementById('search-input-container');

    searchToggleButton.addEventListener('click', () => {
        // d-none 클래스를 토글하여 보였다 숨겼다 합니다.
        searchInputContainer.classList.toggle('d-none');
        // 검색 입력 필드가 나타나면 바로 포커스하도록 설정 (사용자 편의성)
        if (!searchInputContainer.classList.contains('d-none')) {
            searchInputContainer.querySelector('input').focus();
        }
    });
});