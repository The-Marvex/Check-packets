public class Hamming {

    public Hamming(){
    }

    public String get_hamming_code(String data){
        int parity_count = get_no_of_parity(data.length());
        int hamming_code_length = data.length()+parity_count;
        int [] hamming_code = new int [hamming_code_length];
        int j = 0;
        int loop_counter;
        int sum;
        int k = 0;
        // filling data bits at their positions :
        for(int i = 0;i<hamming_code_length;i++){
            if(i+1 != Math.pow(2,j)){
                hamming_code[i] = data.charAt(k);
                k++;
            }
        }
        k = 0;
        // filling parity bits at 2^n positions :
        int [] parity_position = get_parity_position(hamming_code_length,parity_count);
        for (int item : parity_position){
            sum = 0;
            if(item ==0){
                sum = sum + hamming_code[item];
                item = item +2;
            }
            else if(item ==1){
                sum = sum + hamming_code[item];
                sum = sum + hamming_code[item+3];
                item = item + 3;
            }

            else {
                k = 0;
                while(k < hamming_code_length){
                    sum = sum  + hamming_code[k];
                    if (k%item ==0 && k!=0){
                        k = k + item + 1;
                    }
                    else {
                        k = k + 1;
                    }
                }
            }
            if(sum%2 == 0){
                hamming_code[item] = 0;
            }
            else {
                hamming_code[item] = 1;
            }
        }
        String code = "";
        for(int i = 0;i<hamming_code_length;i++){
            code = code + hamming_code[i];
        }
        return code;
    }

    public int [] get_parity_position(int code_length, int no_of_parity){
        int j = 0,i=0;
        int [] parity_positions = new int [no_of_parity];
        while (j < code_length){
            if(j%2 ==0){
                parity_positions[i] = j;
                i++;
            }
            j++;
        }
        return parity_positions;
    }

    private int get_no_of_parity(int data_length){
        int no_of_parity = 0;
        while(Math.pow(2,no_of_parity) >= no_of_parity + data_length + 1){
            no_of_parity++;
        }
        return no_of_parity;
    }
}
