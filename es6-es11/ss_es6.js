// Speed Syntax - 주소의 참조값만 복사해 온다. 그 아래 하나하나씩 복하는 것이 아니다.

{
  const emp = { key : 'empno'};
  const dept = { key : 'deptno'};
  const array = [emp, dept];

  // Array Copy
  const arrayCopy = [...array]; // 주소 값만 복사한다.
  console.log(array, arrayCopy);

  const arrayCopy2 = [...array, { key : 'bm_no' }];
  // emp.key = 'newKey';
  console.log(array, arrayCopy, arrayCopy2);

  // Object Copy
  const otherEmp = {...emp};
  console.log(otherEmp);
}