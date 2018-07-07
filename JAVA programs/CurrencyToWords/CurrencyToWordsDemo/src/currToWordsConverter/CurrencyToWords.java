package currToWordsConverter;

import java.text.DecimalFormat;

public class CurrencyToWords {

  private static final String[] tensNames = {
    "",
    " �����",
    " ��������",
    " ��������",
    " �����������",
    " ��������",
    " ���������",
    " ����������",
    " ���������",
    " ����������"
  };
  
  private static final String[] hundredsNames = {
		    "",
		    " ���",
		    " ������",
		    " ������",
		    " ������������",
		    " ���������",
		    " ����������",
		    " �����������",
		    " ����������",
		    " �����������"
  };

  private static final String[] numNames = {
		    "",
		    " ����",
		    " ���",
		    " ���",
		    " ������",
		    " ���",
		    " ����",
		    " �����",
		    " ����",
		    " �����",
		    " �����",
		    " ����������",
		    " ����������",
		    " ����������",
		    " �������������",
		    " ����������",
		    " �����������",
		    " ������������",
		    " �����������",
		    " ������������"
  };
  
  private CurrencyToWords() {}

  private static String convertLessThanOneThousand(int number) {
    String soFar;
    int numberAtEntrace = number;
    
    if (number % 100 < 20){
      soFar = numNames[number % 100];
      number /= 100;
    }
    else {
     // ����� ������� ������ �������� �
      //54,67,78
      soFar = numNames[number % 10];
      number /= 10;
      
      if((number % 10) > 0) {
    	  soFar = tensNames[number % 10]+ " � "+ soFar;
      }else {
          soFar = tensNames[number % 10] + soFar;
      }
      number /= 10;
    }
    if(soFar.isEmpty()) {
    	return hundredsNames[number];
    }else {
    	if (numberAtEntrace % 100 < 21 && numberAtEntrace % 100 > 0) {
            return hundredsNames[number] + " �" + soFar;
    	}else {
            return hundredsNames[number] + soFar;
    	}
    }
  }


  public static String convert(long number) {
    // 0 to 999 999 999 999
    if (number == 0) { return "����"; }

    String snumber = Long.toString(number);

    // pad with "0"
    String mask = "000000000000";
    DecimalFormat df = new DecimalFormat(mask);
    snumber = df.format(number);

    // XXXnnnnnnnnn
    int billions = Integer.parseInt(snumber.substring(0,3));
    // nnnXXXnnnnnn
    int millions  = Integer.parseInt(snumber.substring(3,6));
    // nnnnnnXXXnnn
    int hundredThousands = Integer.parseInt(snumber.substring(6,9));
    // nnnnnnnnnXXX
    int thousands = Integer.parseInt(snumber.substring(9,12));

    
    
    //-------////BILLIONS////-------//
    //------------------------------//
    String tradBillions = "";
    switch (billions) {
    case 0:
      tradBillions = "";
      break;
    case 1 :
      tradBillions = "���� ������� ";
      break;
    default :
      if(billions == 2) {
    	  tradBillions = "���";
      }else {
          tradBillions = tradBillions + convertLessThanOneThousand(billions);
      }
      tradBillions = tradBillions + " �������� ";
    }
    String result =  tradBillions;

    //-------////MILLIONS////-------//
    //------------------------------//
    String tradMillions="";
    switch (millions) {
    case 0:
      tradMillions = "";
      break;
    case 1 :
      tradMillions = "���� ������ ";
      break;
    default :
      if(millions == 2) {
    	  tradMillions = "���";
      }else {
    	  tradMillions = tradMillions + convertLessThanOneThousand(millions);
      }
      tradMillions = tradMillions + " ������� ";
    }
    result =  result + tradMillions;
    
    
    //-------////HUNDRED_THOUSANDS////-------//
    //---------------------------------------//
    String tradHundredThousands;
    switch (hundredThousands) {
    case 0:
      if( ( (!tradMillions.isEmpty()) || (!tradBillions.isEmpty()) )
    		  	&&  (!convertLessThanOneThousand(thousands).isEmpty())) {
    	  tradHundredThousands = "� ";
      }else {
          tradHundredThousands = "";
      }
      break;
    case 1 :
       if( ( (!tradMillions.isEmpty()) || (!tradBillions.isEmpty()) )
     		  	&&  (!convertLessThanOneThousand(thousands).isEmpty())) {
     	  tradHundredThousands = "� ";
       }else {
           tradHundredThousands = "";
       }	
       tradHundredThousands =tradHundredThousands + "������ ";
      
      break;
    default :
      tradHundredThousands = convertLessThanOneThousand(hundredThousands)
         + " ������ ";
    }
    result =  result + tradHundredThousands;

    String tradThousand;
    tradThousand = convertLessThanOneThousand(thousands);
    result =  result + tradThousand;

    // remove extra spaces!
    return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
  }

  /**
   * testing
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("*** " + CurrencyToWords.convert(0));
    System.out.println("*** " + CurrencyToWords.convert(1));
    System.out.println("*** " + CurrencyToWords.convert(16));
    System.out.println("*** " + CurrencyToWords.convert(52));
    System.out.println("*** " + CurrencyToWords.convert(100));
    System.out.println("*** " + CurrencyToWords.convert(118));
    System.out.println("*** " + CurrencyToWords.convert(200));
    System.out.println("*** " + CurrencyToWords.convert(219));
    System.out.println("*** " + CurrencyToWords.convert(800));
    System.out.println("*** " + CurrencyToWords.convert(801));
    System.out.println("*** " + CurrencyToWords.convert(1001));
    System.out.println("*** " + CurrencyToWords.convert(1060));
    System.out.println("*** " + CurrencyToWords.convert(1316));
    System.out.println("*** " + CurrencyToWords.convert(1000000));
    System.out.println("*** " + CurrencyToWords.convert(2000000));
    System.out.println("*** " + CurrencyToWords.convert(3000200));
    System.out.println("*** " + CurrencyToWords.convert(3000010));
    System.out.println("*** " + CurrencyToWords.convert(700000));
    System.out.println("*** " + CurrencyToWords.convert(9000000));
    System.out.println("*** " + CurrencyToWords.convert(9001000));
    System.out.println("*** " + CurrencyToWords.convert(9001050));
    System.out.println("*** " + CurrencyToWords.convert(123456789));
    System.out.println("*** " + CurrencyToWords.convert(2147483647));
    System.out.println("*** " + CurrencyToWords.convert(3000000010L));

  }
}