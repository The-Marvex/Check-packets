public class driver {
    public static void main(String [] args){

        Hamming hm = new Hamming();
        hm.get_hamming_code("10101");
        /*CRC crc = new CRC("1101");
        String pr = crc.getCRC("1011011");
        System.out.println("CRC is " +pr);*/
        /*for(int i = 0;i<array.length;i++){
            System.out.println(array[i]);
        }*/
    }
}
