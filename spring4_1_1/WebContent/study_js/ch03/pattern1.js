// 제공 함수를 통한 패턴 분석 1
{
  //console.log('test01');
  'use strict'
  let addNum = 0;
  let subNum = 100;

  let auto_1 = setInterval(function() {
    addNum++;
    if (addNum < 10) {
      console.log("addNum : " + addNum);
    }
  }, 2000);

  let auto_2 = setInterval(function() {
    subNum--;
    if (subNum > 90) {
      console.log("subNum : " + subNum);
    }
  }, 2000);
}