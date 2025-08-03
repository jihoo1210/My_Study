$(function() {
    $("#agree-terms").on("change", function(){
        if($("#agree-terms").prop("checked") == true){
            $("#submit-button").prop("disabled", false);
        } else {
            $("#submit-button").prop("disabled", true);
        }
    });
});
/**
 * prop()과 attr() 차이
 * - attr()
 * 1. 해당 속성의 value의 그 자체의 값을 반환한다.
 * - prop()
 * 1. 해당 속성의 value를 boolean 타입으로 반환한다.
 */