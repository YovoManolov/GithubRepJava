/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;

import java.io.IOException;

/**
 *
 * @author yovo
 */
public interface Importable {

    /**
     *
     * @return
     * @throws IOException
     */
    Event[] importDataFromFile() throws IOException ,UnrecognisedRowException ;
}
