/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labs_21_11_16;

import java.util.Comparator;

/**
 *
 * @author yovo
 */
public class DateOfSendingComparator implements Comparator <Shipment> {

            @Override
            public int compare (Shipment o1 , Shipment o2){
                String [] date1 = o1.getDateOfSending().split("\\.");
                String [] date2 = o2.getDateOfSending().split("\\.");
                
                String date11 = "";
                String date22 = new String("");
                
                for (int i =0 ; i<3 ; i ++ ) {
                    date11 += date1[i];
                }
                for (int i =0 ; i < 3 ; i ++ ) {
                    date22 += date2[i];
                }
               
                Long a = Long.valueOf(date11);
                Long b = Long.valueOf(date22);
                
                 if(a == b)return 0;
                 else if(a > b)return 1;
                 else return -1;
                
                /*String [] date1 = o1.getDateOfSending().split("\\.");
                String [] date2 = o2.getDateOfSending().split("\\.");
                Integer []dateArray1 = new Integer [date1.length];
                Integer []dateArray2 = new Integer [date2.length];
                for(int i = 0 ;i < 3; i++){
                dateArray1 [i] = Integer.getInteger(date1[i]);
                dateArray2 [i] = Integer.getInteger(date2[i]);
                }
                if(dateArray1[2] == dateArray2[2]){
                if( dateArray1[1] == dateArray2[1]){
                if(dateArray1[0] == dateArray2[0]){
                return 0;
                }
                if(dateArray1[0] > dateArray2[0]){
                return 1;
                }else return -1;
                }
                else if(dateArray1[1] > dateArray2[1]){
                return 1;
                }else return -1;
                }else if(dateArray1[2] > dateArray2[2]){
                return 1;
                }else return -1;
                 */ 
            }     
};
