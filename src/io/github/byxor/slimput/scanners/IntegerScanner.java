package io.github.byxor.slimput.scanners;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class IntegerScanner {

    private final BufferedReader bufferedReader;

    public IntegerScanner(InputStream inputStream) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        this.bufferedReader = new BufferedReader(inputStreamReader);
    }

    public int readNextLineAsInt() throws IOException {
        String line = bufferedReader.readLine();
        return Integer.parseInt(line);
    }

}