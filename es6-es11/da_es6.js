{
  const sonata = {
    carColor = 'black',
    wheelNum = 4,
    speed = 40,
  };

  {
    const carColor = sonata.carColor;
    const speed = sonata.speed;
    const wheelNum = sonata.wheelNum;
  }

  // 추천
  {
    const { carColor, wheelNum, speed } = sonata;
    console.log(carColor, wheelNum, speed);

    const { carColor : sonataColor, wheelNum : sonataWheelNum, speed : sonataSpeed } = sonata;
    console.log(sonataColor, sonataWheelNum, sonataSpeed);
  }

  // array - 배열에서는 대괄호 사용한다.
  const fruit = ['사과', '딸기'];
  const one = fruit[0];
  const two = fruit[1];
  console.log(one, two);

  // 추천
  const [one, two] = fruit;
  console.log(one, two);
}