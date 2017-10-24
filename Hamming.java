import java.math.*;

public class Hamming {
    public Hamming(){


    }
    public String get_hamming_code(String data){
        int parity_count = get_no_of_parity(data.length());
        int hamming_code_length = data.length()+parity_count;
        int [] hamming_code = new int [hamming_code_length];
        int j = 0;
        for(int i = 0;i<hamming_code_length;i++){
            if(i != Math.pow(2,j)){
                hamming_code[i] = data.charAt(i);
            }
            else {
                j++;
            }
        }
        

    }

    private int get_no_of_parity(int data_length){
        int no_of_parity = 0;
        while(Math.pow(2,no_of_parity) >= no_of_parity + data_length + 1){
            no_of_parity++;
        }
        return no_of_parity;
    }
}
