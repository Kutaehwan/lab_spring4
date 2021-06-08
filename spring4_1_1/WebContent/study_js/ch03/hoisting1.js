/*
  일반 함수 정의방식과 익명 함수 선언
  일반 함수 정의는 함수 호출 시 Hoisting 기술을 지원한다.
  그러나 익명 함수 선언 참조 방식은 호이스팅을 지원하지 않는다.
  Hoisting을 적용하면 함수 정의문 보다 호출문이 먼저 나와도 함수 정의문을
  끌어올려서 함수를 호출한다.
*/
{
  let count = 0; // var를 사용하지 않는다.
  myFnc();

  function myFnc() {
    count++;
    // document.write("hello" + count, "<br>");
    document.write(`hello ${count} <br>`); // ES6에서 추가되었다. / https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Template_literals
  }
  myFnc();

  // hoisting이 발생하지 않는다.
  const theFnc = function() {
    count++;
    //document.write("bye"+count, "<br>");
    document.write(`bye ${count} <br>`);
  }
  theFnc();
}