package com.cecchettodadone.juego1943;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Nivel {
    private Map<String, String> nivel;

    public Nivel (String fileName) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader(Util.getFile("niveles/" + fileName)));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        nivel = new LinkedHashMap<>();


        if (scanner == null) return;

        String line;
        while (scanner.hasNext()) {
            line = scanner.next();
            if (!line.startsWith("#") && !line.isEmpty()) {
                String[] columns = line.split("=");
                nivel.put(columns[0], columns[1]);
            }
        }
    }

    public Map<String, String> getPropiedades () {
        return nivel;
    }

}
