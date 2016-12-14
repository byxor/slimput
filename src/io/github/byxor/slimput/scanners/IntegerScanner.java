package io.github.byxor.slimput.scanners;

import io.github.byxor.slimput.SlimputException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class IntegerScanner {

    private final BufferedReader bufferedReader;

    public IntegerScanner(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public IntegerScanner() {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        this.bufferedReader = new BufferedReader(streamReader);
    }

    public int readNextLineAsInt() throws SlimputException, IOException {
        String line = bufferedReader.readLine();
        if (line.equals(""))
            throw new SlimputException();
        else
            return Integer.parseInt(line);
    }

    public int[] readNextLineAsIntArray() throws IOException {
        String line = bufferedReader.readLine();
        if (line.equals(""))
            return new int[0];
        else {
            String[] words = line.split(" ");
            int size = words.length;
            int[] numbers = new int[size];
            for (int i = 0; i < size; i++)
                numbers[i] = Integer.parseInt(words[i]);
            return numbers;
        }
    }
}