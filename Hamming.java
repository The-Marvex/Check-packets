import java.util.Arrays;

public class Hamming {

    public Hamming(){
    }

    public String get_hamming_code(String data){
        int parity_count = get_no_of_parity(data.length());
        System.out.println("No of parity positions "+parity_count);
        int hamming_code_length = data.length()+parity_count;
        System.out.println("Hamming code length "+hamming_code_length);
        int [] hamming_code = new int [hamming_code_length];
        int j = 0;
        int sum;
        int k = 0;

        // filling data bits at their positions :
        for(int i = 0;i<hamming_code.length;i++){
            System.out.println( i+ " " + j + "ij"+(i+1)+" "+Math.pow(2,j));
            if(i+1 != Math.pow(2,j)){
                hamming_code[i] = Character.getNumericValue(data.charAt(k));
                k++;
            }
            else {
                hamming_code[i] = -1;
                j++;
            }
        }
        System.out.println();
        print_array(hamming_code);


        // filling parity bits at 2^n positions :
        int [] parity_position = get_parity_position(hamming_code_length,parity_count);

        System.out.println();
        System.out.println("Parity positions :");
        print_array(parity_position);
        System.out.println();

        for (int item : parity_position){
            System.out.println("Value of item is "+item);
            sum = 0;
            System.out.println("I ma scanning");
            k = item;
            if(item == 0){
                System.out.println("item is 0");
                while (k < hamming_code_length){
                    if(!contains(parity_position,item)){
                        System.out.println(k+" "+hamming_code[k]);
                        sum = sum + hamming_code[k];
                        k = k+2;
                    }
                    else k++;
                }
            }
            else if(item ==1 ){
                System.out.println("item is 1");
                while (k < hamming_code_length){
                    if(!contains(parity_position,item)){
                        System.out.println(k+" "+hamming_code[k]);
                        sum = sum + hamming_code[k];
                        k++;
                        System.out.println(k+" "+hamming_code[k]);
                        sum = sum + hamming_code[k];
                        k = k + 3;
                    }
                    else k++;
                }
            }

            else {
                System.out.println("item is different" + item);
                while(k < hamming_code_length){
                    System.out.println(k+" " + hamming_code[k]);
                    sum = sum  + hamming_code[k];
                    if (!contains(parity_position,item)){
                        k = k + item + 1;
                    }
                    else {
                        k = k + 1;
                    }
                }
            }
            print_array(hamming_code);

            System.out.println("Sum this time is : "+sum);
            if(sum%2 == 0){
                hamming_code[item] = 0;
            }
            else {
                hamming_code[item] = 1;
            }
        }

        System.out.println("Printing hamming code : ");
        print_array(hamming_code);
        System.out.println("Done");

        String code = "";
        for(int i = 0;i<hamming_code_length;i++){
            code = code + hamming_code[i];
        }
        return code;
    }

    private boolean contains(int [] array,int key){
        return Arrays.asList(array).contains(key);
    }


    public void print_array(int [] array){
        for(int i= 0;i<array.length;i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public int [] get_parity_position(int code_length, int no_of_parity){
        int j = 0,i = 0;
        int [] parity_positions = new int [no_of_parity];
        while (j < code_length){
            if(j+1 == (int)Math.pow(2,i)){
                parity_positions[i] = j;
                i++;
            }
            j++;
        }
        return parity_positions;
    }

    private int get_no_of_parity(int data_length){
        int no_of_parity = 0;
        while(Math.pow(2,no_of_parity) <= no_of_parity + data_length + 1){
            no_of_parity++;
        }
        return no_of_parity;
    }
}
