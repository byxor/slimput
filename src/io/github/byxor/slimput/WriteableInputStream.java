package io.github.byxor.slimput;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Queue;

public class WriteableInputStream extends InputStream {

    private int numberOfAvailableBytes = 0;
    private Queue<Byte> availableBytes = new LinkedList<>();

    @Override
    public int read() throws IOException {
        if (numberOfAvailableBytes == 0)
            throw new IOException("No bytes available to read");
        else {
            numberOfAvailableBytes--;
            return (int) availableBytes.remove();
        }
    }

    @Override
    public int available() {
        return numberOfAvailableBytes;
    }

    public void write(char character) {
        availableBytes.add((byte) character);
        numberOfAvailableBytes++;
    }
}
