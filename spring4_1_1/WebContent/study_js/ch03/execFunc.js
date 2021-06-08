// 즉시 실행 함수
/*
  (function() {
    자바스크립트 코드; -> 외부 API를 사용할 때 많이 사용한다.
  }());
*/
{
  (function() {
    let num = 100;
    function menu() {
      num += 100;
      // alert(num);
      // console.log(num);
      document.write(num + "<br>");
    }
    menu();
  }());

  // 개발자 A와 B가 즉시 실햄 함수에 지역변수와 지역함수를 선언하여 충돌을 방지한다.
  (function() {
    let num = 100;
    function menu() {
      // console.log(`num ${num}`);
      document.write(num);
    }
    menu();
  }());
}