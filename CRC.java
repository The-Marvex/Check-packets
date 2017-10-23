public class CRC {

    int [] kernel;
    public CRC(String kernel){
        this.kernel = new int[kernel.length()];
        for(int k=0;k<kernel.length();k++){
            this.kernel[k] = Character.getNumericValue(kernel.charAt(k));
        }
    }

    public String getCRC(String packet){
        int [] dividend = get_dividend(packet);
        int append_flag = 1;
        int pointer;
        int kernel_index;
        int pivot = 0;
        int count_val = 0;
        int first_flag = 0;
        while(append_flag == 1){
            pointer = pivot;
            kernel_index = 0;
            first_flag = 0;
            while (kernel_index < kernel.length){
                System.out.println("pointer" + pointer);
                dividend[pointer] =  get_modulo(dividend[pointer],kernel[kernel_index]);
                if (1 == dividend[pointer] && first_flag == 0){
                    pivot = pointer;
                    first_flag = 1;
                }
                pointer++;
                kernel_index++;
                System.out.print("p");
            }
            //System.out.println("pivot" + pivot);
            if(pointer >= dividend.length){
                append_flag = 0;
            }
            print_array(dividend);
            System.out.println();
        }
        int index = dividend.length-kernel.length+1;
        String CRC = "";
        while (index < dividend.length){
            CRC = CRC + dividend[index];
            index++;
        }
        return CRC;
    }

    public int get_modulo(int a, int b){
        return (a+b)%2;
    }

    public int [] get_dividend(String packet){
        System.out.println(packet);
        System.out.println(kernel);
        int []  dividend = new int [packet.length() + kernel.length-1];
        int i,j;
        for(i = 0;i<packet.length();i++){
            dividend[i] = Character.getNumericValue(packet.charAt(i));
        }
        for(j = i;j<dividend.length;j++){
            dividend[j] = 0;
        }
        return dividend;
    }

    public void print_array(int [] array){
        for(int i= 0;i<array.length;i++){
            System.out.print(array[i] + " ");
        }
    }


}
