/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagementsystem;

/**
 *
 * @author farid
 */
public class Test {
    public static void main(String args[]){
        String str1[] = {"farid","zia","aziz"};
        String str2[] = {"hadi","ahmad","safar"};
        String result[] = Tools.mergeArrays(str1, str2);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
}
