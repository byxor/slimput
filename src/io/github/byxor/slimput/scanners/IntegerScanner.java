package io.github.byxor.slimput.scanners;

import io.github.byxor.slimput.SlimputException;

import java.io.BufferedReader;
import java.io.IOException;


public class IntegerScanner {

    private final BufferedReader bufferedReader;

    public IntegerScanner(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public int readNextLineAsInt() throws SlimputException, IOException {
        String line = bufferedReader.readLine();
        if (line == "") {
            throw new SlimputException();
        } else {
            return Integer.parseInt(line);
        }
    }

}