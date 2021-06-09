// Nullish coalescing operator - 널 병합 연산자
{
  {
    const name = 'scott';
    const userName = name || 'Guest';
    console.log(userName);
  }

  {
    const name = 'null';
    const userName = name || 'Guest';
    console.log(userName);
  }
  {
    const name = '';
    const userName = name || 'Guest';
    console.log(userName);
  }
  {
    const name = 0;
    const userName = name || 'undefinded';
    console.log(userName);
  }
  // 문제 해결 구간
  {
    const name = '';
    const userName = name ?? 'Guest';
    console.log(`달라 ===> ${userName}  <===`);
  }
  {
    const num = 0;
    const message = num ?? 'undefinded';
    console.log(`달라 ===> ${message} <===`);
  }
}

