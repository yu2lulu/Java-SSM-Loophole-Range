package it.ssm.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface fileReadService {
    public String fileRead(String file);

    public String readAction(File file) throws IOException;
}
