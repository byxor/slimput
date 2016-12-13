package io.github.byxor.slimput.scanners;

import org.testng.annotations.Test;
import java.io.IOException;


public class IntegerScannerTest {

    private IntegerScanner integerScanner;
    private int result;

    @Test(expectedExceptions = IOException.class)
    public void shouldThrowIOExceptionWhenReadingEmptyLineAsInt() throws IOException {
        givenAnIntegerScanner();
        whenReadingNextLineAsInt();
    }

//    @Test
//    public void shouldReadZeroFromLineContainingZero() throws IOException {
//        givenAnIntegerScanner();
//        whenStreamIsFed('0');
//        whenStreamIsFedEOF();
//        whenReadingNextLineAsInt();
//        thenResultIs(0);
//    }

    private void givenAnIntegerScanner() {
        writeableInputStream = new WriteableInputStream();
        integerScanner = new IntegerScanner(writeableInputStream);
    }

    private void whenReadingNextLineAsInt() throws IOException {
        result = integerScanner.readNextLineAsInt();
    }

    private void whenStreamIsFed(char data) {
        writeableInputStream.write((int) data);
    }

    private void whenStreamIsFedEOF() {
        writeableInputStream.write(-1);
    }

    private void thenResultIs(int expected) {
        assertEquals(result, expected);
    }

}