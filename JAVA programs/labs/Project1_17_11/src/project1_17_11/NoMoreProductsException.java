/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1_17_11;

/**
 *
 * @author yovo
 */
class NoMoreProductsException extends Exception {
    @Override
    public String getMessage() {
        return "No more products !!!!" ;
    }
}
