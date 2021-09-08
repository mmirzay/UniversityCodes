class Sort{
    private boolean swapped;
    private int compCount=0;
    private int swapCount=0;
    void sortArr1(int[] arr){
        compCount=0; swapCount=0;
        System.out.println("Array befor Sorting1: ");
        for(int i=0;i<arr.length;i++)
            System.out.print(" "+arr[i]);
        do{
            swapped=false;
            for(int i=1;i<arr.length;i++){
                compCount++;
                if(arr[i-1]>arr[i]){
                    int temp=arr[i];
                    arr[i]=arr[i-1];
                    arr[i-1]=temp;
                    swapCount++;
                    swapped=true;
                }
            }
        }while(swapped);
        System.out.println("");
        System.out.println("Array after Sorting1: ");
        for(int i=0;i<arr.length;i++)
            System.out.print(" "+arr[i]);
        System.out.println("");
        System.out.println("the Computing of Composition counter in Swap1= "+compCount);
        System.out.println("the Computing of Swapping counter in Swap1= "+swapCount);
    }
    void sortArr2(int[] arr){
        compCount=0; swapCount=0;
        System.out.println("Array befor Sorting2: ");
        for(int i=0;i<arr.length;i++)
            System.out.print(" "+arr[i]);
        int n=arr.length;
        do{
            swapped=false;
            for(int i=1;i<n;i++){
                compCount++;
                if(arr[i-1]>arr[i]){
                    int temp=arr[i];
                    arr[i]=arr[i-1];
                    arr[i-1]=temp;
                    swapCount++;
                    swapped=true;
                }
            }
            n--;
        }while(swapped);
        System.out.println("");
        System.out.println("Array after Sorting2: ");
        for(int i=0;i<arr.length;i++)
            System.out.print(" "+arr[i]);
        System.out.println("");
        System.out.println("the Computing of Composition counter in Swap2= "+compCount);
        System.out.println("the Computing of Swapping counter in Swap2= "+swapCount);
    }
    void sortArr3(int[] arr){
        compCount=0; swapCount=0;
        System.out.println("Array befor Sorting3: ");
        for(int i=0;i<arr.length;i++)
            System.out.print(" "+arr[i]);
        int n=arr.length;
        do{
            swapped=false;
            int newn=0;
            for(int i=1;i<n;i++){
                compCount++;
                if(arr[i-1]>arr[i]){
                    int temp=arr[i];
                    arr[i]=arr[i-1];
                    arr[i-1]=temp;
                    swapCount++;
                    swapped=true;
                    newn=i;
                }
            }
            n=newn;
        }while(swapped);
        System.out.println("");
        System.out.println("Array after Sorting3: ");
        for(int i=0;i<arr.length;i++)
            System.out.print(" "+arr[i]);
        System.out.println("");
        System.out.println("the Computing of Composition counter in Swap3= "+compCount);
        System.out.println("the Computing of Swapping counter in Swap3= "+swapCount);
    }
    void insertionSort(int arr[]){
        compCount=0; swapCount=0;
        System.out.println("befor Sorting: ");
        for(int i=0;i<arr.length;i++)
            System.out.print(" "+arr[i]);
        for(int i=1;i<arr.length;i++){
            int x=arr[i];
            int k=i-1;
            compCount++;
            while(x<arr[k]){
                swapCount++;
                arr[k+1]=arr[k];
                k--;
                if(k<0)
                    break;
                else
                    compCount++;
            }            
            arr[k+1]=x;
        }
        System.out.println("");
        System.out.println("after Sorting");
        for(int i=0;i<arr.length;i++)
            System.out.print(" "+arr[i]);
        System.out.println("");
        System.out.println("the Computing of Composition counter in Insertion= "+compCount);
        System.out.println("the Computing of Swapping counter in Insertion= "+swapCount);
    }
    void combSort(int arr[]){
        swapCount=0; compCount=0;
        int stepCompCount=0;
        boolean swap=false;
        System.out.println("befor sort: ");
        for(int i=0;i<arr.length;i++)
            System.out.print(" "+arr[i]);
        System.out.println("");
        int gap=arr.length/2;        
        if(gap<1) gap=1;
        while(true){
            int k=0;
            stepCompCount=0;
            swap=false;
            while(k+gap<arr.length){                                
                stepCompCount++;
                if(arr[k]>arr[k+gap]){
                    swapCount++;
                    int temp=arr[k+gap];
                    arr[k+gap]=arr[k];
                    arr[k]=temp;
                    swap=true;
                }
                k++;
            }
            compCount+=stepCompCount;
            if(stepCompCount==arr.length-1 && !swap) break;
            gap=gap/2;
            if(gap<1) gap=1;            
        }
        System.out.println("after sort: ");
        for(int i=0;i<arr.length;i++)
            System.out.print(" "+arr[i]);
        System.out.println("");
        System.out.println("the Computing of Composition counter in combSort= "+compCount);
        System.out.println("the Computing of Swapping counter in combSort= "+swapCount);
    }
}
public class SortTest {
    static int[] a1= new int[]{5,1,4,2,8};
    static int[] a2= new int[]{5,1,4,2,8};
    static int[] a3= new int[]{5,1,4,2,8};
    static int[] a4= new int[]{5,1,4,2,8};
    static int[] a5= new int[]{12,15,9,1,8,3,7,4};
    static Sort mySort1=new Sort();
    public static void main(String[] args) {
        mySort1.sortArr1(a1);
        System.out.println("==================");
        mySort1.sortArr2(a2);
        System.out.println("==================");
        mySort1.sortArr3(a3);
        System.out.println("==================");
        mySort1.insertionSort(a4);
        System.out.println("==================");
        mySort1.combSort(a5);
    }

}
