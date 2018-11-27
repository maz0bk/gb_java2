package com.geekbrains;

public class MainClass {
    public static void main(String[] args) {
        String [][] strMas ={   {"1","2","3","5"},
                                {"1","2","3","4"},
                                {"1","2","3","4"},
                                {"1","2","3","4"}};
        int sum=0;
        try{
       sum =countArray(strMas);
       }
       catch (MyArrayDataException | MyArraySizeException e){
            System.out.println(e);
            return;
        }
        System.out.println("Сумма членов массива равна " +  sum);
    }

    public static int countArray(String [][] strMas) throws MyArraySizeException,MyArrayDataException{
        if (strMas.length >4) throw new MyArraySizeException();
        for (String arrayString[] : strMas) {
            if (arrayString.length > 4) throw new MyArraySizeException();
        }
        int sum=0;
        Integer tmp;
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                try {
                    tmp = Integer.parseInt(strMas[i][j]);
                }
                catch (NumberFormatException e){
                    throw new MyArrayDataException(i,j);
                }
                sum =sum+tmp;
                tmp=0;
            }
        }
        return sum;
    }
}
