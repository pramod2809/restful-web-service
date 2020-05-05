package com.rest.webservice.restfulwebservice.user;

import java.util.Objects;

public class test {
    byte r=127; // -128 to 127 - default =0
    short s=32767; //-32768 to 32767 default=0
    int i= 2147483647; //-2147483648 and 2147483647 32-bit
    long l= 100L;//64 bit default=0L
    float f=234.5F ;//32 bit 7 decimals
    double d=123.4 ;// 64 bit 15 decimals
    boolean b=true; // 1bit
    char c='A';//single char

    private String name;

   // public static boolean equals(Object a, Object b) {
        //return  (a.equals(b)) ;
    //}

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        test test = (test) o;
//        return Objects.equals(name, test.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name);
//    }

    public static void main(String[] args) {
      //  System.out.println( equals(10,100));
        String str= "pramod";
        String str1="raj";
        System.out.println(str.equals(str1));


    }
}
