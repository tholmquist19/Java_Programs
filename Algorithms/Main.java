public class Main {


    private static int findPeak(final int f, final int l, final int[] A){
        if(f>=l)
            return A[f];
        int mid = ((f+l)/2);
        if(A[mid]>A[mid+1] && A[mid]>A[mid-1])
            return A[mid];
        else if(A[mid]>A[mid-1] && A[mid]<A[mid+1])
            return findPeak(mid+1,l,A);
        return findPeak(f,mid-1,A);
    }
    public static void main(final String[] args){
        int arr[] = new int[10];
        arr[0]= 1;arr[1]=4; arr[2]=8; arr[3]=11; arr[4]=13; arr[5]=24; arr[6]=18; arr[7]=12; arr[8]=9; arr[9]=1;
        System.out.println(findPeak(0,9,arr));
    }
}
