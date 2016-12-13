package io.github.byxor.slimput;

import io.github.byxor.slimput.WriteableInputStream;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class WriteableInputStreamTest {

    private WriteableInputStream writeableInputStream;
    private byte byteFromStream;

    @Test
    public void shouldHaveNoAvailableBytesInNewlyCreatedStream() throws IOException {
        givenAWriteableInputStream();
        thenTheNumberOfAvailableBytesIs(0);
    }

    @Test
    public void shouldHaveOneAvailableByteWhenFedByte() throws IOException {
        givenAWriteableInputStream();
        whenWriting('a');
        thenTheNumberOfAvailableBytesIs(1);
    }

    @Test(expectedExceptions = IOException.class)
    public void shouldThrowIOExceptionWhenReadingFromNewlyCreatedStream() throws IOException {
        givenAWriteableInputStream();
        whenReadingAByte();
    }

    @Test
    public void shouldReadByteFromStreamWhenFedByte() throws IOException {
        givenAWriteableInputStream();
        whenWriting('a');
        whenReadingAByte();
        thenByteIs('a');
    }

    @Test
    public void shouldReadTwoBytesFromStreamWhenFedTwoBytes() throws IOException {
        givenAWriteableInputStream();
        whenWriting('a');
        whenWriting('b');
        thenTheNumberOfAvailableBytesIs(2);
        whenReadingAByte();
        thenByteIs('a');
        thenTheNumberOfAvailableBytesIs(1);
        whenReadingAByte();
        thenByteIs('b');
        thenTheNumberOfAvailableBytesIs(0);
    }

    private void givenAWriteableInputStream() {
        writeableInputStream = new WriteableInputStream();
    }

    private void whenReadingAByte() throws IOException {
        byteFromStream = (byte) writeableInputStream.read();
    }

    private void whenWriting(char character) {
        writeableInputStream.write(character);
    }

    private void thenTheNumberOfAvailableBytesIs(int expected) throws IOException {
        assertEquals(writeableInputStream.available(), expected);
    }

    private void thenByteIs(char expected) throws IOException {
        assertEquals(byteFromStream, (byte) expected);
    }

}
