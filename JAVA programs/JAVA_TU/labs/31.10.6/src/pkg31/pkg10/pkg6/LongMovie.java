/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg31.pkg10.pkg6;

import java.io.FileInputStream;

/**
 *
 * @author yovo
 */
public class LongMovie extends Movie{
    
    private String name;
    private int length;
    private FileInputStream fis;
    
    public LongMovie(String name, int lenght, FileInputStream fis) {
        super(name, lenght, fis);
    }
    
    @Override
    public void setLength(int lenght) throws IllegalArgumentException {
        if(lenght < 10800 ){
            throw new IllegalArgumentException("Lenght is not currect set ");
        }
        this.length = lenght;
    }
    
}
