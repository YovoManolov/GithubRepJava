package com.company;

import java.io.IOException;

public interface Importable {
    Object[] importDataFromFile() throws IOException;
}
