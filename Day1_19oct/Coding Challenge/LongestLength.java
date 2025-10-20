public class LongestLength{
    public static void main(String[] args) {
        String arr[] ={"Hello", "Hi", "Welcome", "Programming"};
        String max= "";
        for(int i=0; i<arr.length; i++){
            if(arr[i].length()>max.length()){
                   max = arr[i];
            }
            
        }
        System.out.println("length of longest string in an array is:"+ max + "and its length is :"+max.length());
    }
}