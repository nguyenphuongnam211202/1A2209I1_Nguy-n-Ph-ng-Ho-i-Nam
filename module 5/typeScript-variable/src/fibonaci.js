function fibonacciRecursive(n) {
    if (n <= 0) {
        return 0;
    }
    else if (n === 1) {
        return 1;
    }
    else {
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
}
function fibonacciLoop(count) {
    var fibonacciNumbers = [];
    for (var i = 0; i < count; i++) {
        fibonacciNumbers.push(fibonacciRecursive(i));
    }
    return fibonacciNumbers;
}
function sumFibonacci(count) {
    var fibonacciNumbers = fibonacciLoop(count);
    var sum = 0;
    for (var _i = 0, fibonacciNumbers_1 = fibonacciNumbers; _i < fibonacciNumbers_1.length; _i++) {
        var num = fibonacciNumbers_1[_i];
        sum += num;
    }
    return sum;
}
var count = 10;
console.log("C\u00E1c s\u1ED1 Fibonacci trong d\u00E3y: ".concat(fibonacciLoop(count)));
console.log("T\u1ED5ng c\u00E1c s\u1ED1 Fibonacci trong d\u00E3y: ".concat(sumFibonacci(count)));
