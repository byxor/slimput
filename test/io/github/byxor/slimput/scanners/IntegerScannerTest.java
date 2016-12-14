package io.github.byxor.slimput.scanners;

import io.github.byxor.slimput.SlimputException;
import org.testng.annotations.Test;

import java.io.BufferedReader;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;


public class IntegerScannerTest {

    private BufferedReader bufferedReader;
    private IntegerScanner integerScanner;
    private int integer;
    private int[] integerArray;

    @Test(expectedExceptions = SlimputException.class)
    public void shouldThrowSlimputExceptionWhenReadingEmptyLineAsInt() throws Exception {
        givenAnIntegerScanner();
        givenReadLineReturns("");
        whenReadingNextLineAsInt();
    }

    @Test
    public void shouldReturnZeroWhenReadingZeroAsInt() throws Exception {
        givenAnIntegerScanner();
        givenReadLineReturns("0");
        whenReadingNextLineAsInt();
        thenTheIntegerIs(0);
    }

    @Test
    public void shouldReturnTwelveWhenReadingTwelveAsInt() throws Exception {
        givenAnIntegerScanner();
        givenReadLineReturns("12");
        whenReadingNextLineAsInt();
        thenTheIntegerIs(12);
    }

    @Test
    public void shouldReturnEmptyArrayWhenReadingEmptyLineAsIntArray() throws Exception {
        givenAnIntegerScanner();
        givenReadLineReturns("");
        whenReadingNextLineAsIntArray();
        thenTheIntegersAre();
    }

    @Test
    public void shouldReturnArrayWhenReadingLineAsIntArray() throws Exception {
        givenAnIntegerScanner();
        givenReadLineReturns("2 3 1 40 20");
        whenReadingNextLineAsIntArray();
        thenTheIntegersAre(2, 3, 1, 40, 20);
    }

    @Test
    public void shouldCreateIntegerScannerWithSystemIn() throws Exception {
        givenAnIntegerScannerWithoutParameters();
    }

    private void givenAnIntegerScannerWithoutParameters() {
        integerScanner = new IntegerScanner();
    }

    private void givenAnIntegerScanner() {
        bufferedReader = mock(BufferedReader.class);
        integerScanner = new IntegerScanner(bufferedReader);
    }

    private void givenReadLineReturns(String line) throws Exception {
        when(bufferedReader.readLine()).thenReturn(line);
    }

    private void whenReadingNextLineAsInt() throws Exception {
        integer = integerScanner.readNextLineAsInt();
    }

    private void whenReadingNextLineAsIntArray() throws Exception {
        integerArray = integerScanner.readNextLineAsIntArray();
    }

    private void thenTheIntegerIs(int expected) {
        assertEquals(integer, expected);
    }

    private void thenTheIntegersAre(int ... expectedIntegers) {
        assertEquals(integerArray, expectedIntegers);
    }

}