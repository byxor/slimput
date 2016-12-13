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
    private int result;

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
        thenTheResultIs(0);
    }

    @Test
    public void shouldReturnTwelveWhenReadingTwelveAsInt() throws Exception {
        givenAnIntegerScanner();
        givenReadLineReturns("12");
        whenReadingNextLineAsInt();
        thenTheResultIs(12);
    }

    private void givenAnIntegerScanner() {
        bufferedReader = mock(BufferedReader.class);
        integerScanner = new IntegerScanner(bufferedReader);
    }

    private void givenReadLineReturns(String line) throws Exception {
        when(bufferedReader.readLine()).thenReturn(line);
    }

    private void whenReadingNextLineAsInt() throws Exception {
        result = integerScanner.readNextLineAsInt();
    }

    private void thenTheResultIs(int expected) {
        assertEquals(result, expected);
    }

}