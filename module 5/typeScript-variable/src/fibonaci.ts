function fibonacciRecursive(n: number): number {
    if (n <= 0) {
        return 0;
    } else if (n === 1) {
        return 1;
    } else {
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
}


function fibonacciLoop(count: number): number[] {
    const fibonacciNumbers: number[] = [];
    for (let i = 0; i < count; i++) {
        fibonacciNumbers.push(fibonacciRecursive(i));
    }
    return fibonacciNumbers;
}


function sumFibonacci(count: number): number {
    const fibonacciNumbers: number[] = fibonacciLoop(count);
    let sum = 0;
    for (const num of fibonacciNumbers) {
        sum += num;
    }
    return sum;
}

const count = 10;
console.log(`Các số Fibonacci trong dãy: ${fibonacciLoop(count)}`);
console.log(`Tổng các số Fibonacci trong dãy: ${sumFibonacci(count)}`);
