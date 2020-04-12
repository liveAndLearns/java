package com.learn.algorithm.bytedance;

public class TwoStringNumberAdd {
	
    public static void main(String[] args) {
        
    }
    
    public static int[] addTwoStringWithNumbers(String number1, String number2) {
    	

    	int []  result=  new int[number1.length() +  number2.length() + 1];

        int number1Length = number1.length();
        int number2Length = number2.length();
        int resultIndex = result.length-1;
        boolean uplevel = false;
        
        int maxLength = number1Length >= number2Length ? number1Length : number2Length;
        
        for(int i = 0; i <maxLength ; i ++)
        {
        	
        	int addleft = number1Length-2-i>=0? Integer.valueOf(number1.substring(number1Length-2-i, number1Length-1-i)) : 0;
        	
        	int addright = number1Length-2-i>=0? Integer.valueOf(number2.substring(number2Length-2-i, number2Length-1-i)) : 0;
        	
        	
        	
            int currentLevelResult = addleft + addright;
                            
              if(uplevel) currentLevelResult ++;
               if(currentLevelResult > 9){   
                    uplevel =true;
                }
                else{
                    uplevel = false;
                }
            
            result[resultIndex] =currentLevelResult%10;                    
            
        }
        
        for(int i = 0 ; i < resultIndex ; i ++)
        {
            System.out.print(result[i]); // 0 element 可能默认值
        }
        
        return result;
    }
    
    
}
