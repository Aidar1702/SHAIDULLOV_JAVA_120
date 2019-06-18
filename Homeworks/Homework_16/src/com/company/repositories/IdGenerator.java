package com.company.repositories;

import java.io.*;


public class IdGenerator {
    private String filename;

    public IdGenerator(String filename){
        this.filename = filename;
    }
    public int generate(){
        try {
            InputStream input = new FileInputStream(filename);
            byte bytes[] = new byte[10];
            input.read(bytes);
            String idAsString = new String(bytes);
            int lastGenerateId = Integer.parseInt(idAsString.trim());
            lastGenerateId++;
            input.close();
            OutputStream output = new FileOutputStream(filename);
            idAsString = String.valueOf(lastGenerateId);
            output.write(idAsString.getBytes());
            output.close();
            return lastGenerateId;
        }catch (IOException e){
            throw new IllegalStateException(e);
        }
    }

}
