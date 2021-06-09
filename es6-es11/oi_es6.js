// Object Initializer
// https://developer.mozilla.org/ko/docs/Web/JavaScript/Reference/Operators/Object_initializer
{
  const person = {a:'scott', b:'42'};

  const name = 'scott';
  const age = '35'

  const person2 = {name : name, age : age};

  // key와 value가 동일할 때는 생략이 가능하다.
  const person3 = {name, age};

  console.log(person, person2, person3);
}