public class driver {
    public static void main(String [] args){
        CRC crc = new CRC("1101");
        String pr = crc.getCRC("1011011");
        System.out.println(pr);
        /*for(int i = 0;i<array.length;i++){
            System.out.println(array[i]);
        }*/
    }
}
