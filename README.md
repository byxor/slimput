# slimput
Java IO is slow. Let's fix that.

## What is Slimput?

It's a simple library to make IO faster for Java.

## What do you mean?

The common way of reading standard input in Java is to use `java.util.Scanner`. The problem with this is how slow it is.

## Does it matter?

Yes. Competitive programming requires a _lot_ of reading from standard input. It sucks when your solution to a programming problem is optimal, yet exceeds the time limit because of slow IO.

## How do I use it?

If you need to submit the code, you can copy and paste the IntegerScanner class into your own file.

Here is an example of slimput being used.

```java

public static void main(String[] args) {
    IntegerScanner scanner = new IntegerScanner();

    int number = scanner.readNextLineAsInt();
    System.out.println(number);

    int[] numbers = scanner.readNextLineAsIntArray();
    for (int x : numbers)
        System.out.println(x);
}
```
