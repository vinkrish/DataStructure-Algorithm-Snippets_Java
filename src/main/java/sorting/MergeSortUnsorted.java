package sorting;

/*
 * Merging one sorted array with unsorted array and resulting array should be sorted as well.
 * Since first array is already sorted, following implementation sorts the second array with merge sort implementation.
 * Followed by merging already sorted two arrays
 */
public class MergeSortUnsorted {

	public static void main(String[] args) {
		char[] array1 = {'a', 'c', 'd', 'f', 'g'};
	    char[] array2 = { 'e', 'b', 'h' };
	    mergeSort(array2, array2.length);
	    
	    int m = array1.length;
	    int n = array2.length;
	    char[] mergedArray = new char[m+n]; 

        int i = 0, j = 0, k = 0; 
        while (i < m && j < n) { 
            if (array1[i] <= array2[j]) { 
            	mergedArray[k] = array1[i]; 
                i += 1; 
                k += 1; 
            } else { 
            	mergedArray[k] = array2[j]; 
                j += 1; 
                k += 1; 
            } 
        }     
          
        while (i < m) {
        	mergedArray[k] = array1[i]; 
            i += 1; 
            k += 1; 
        }     
        while (j < n) {
        	mergedArray[k] = array2[j]; 
            j += 1; 
            k += 1; 
        }
        System.out.print( "Resulted sorted array :"); 
        for (int x = 0; x < n + m; x++) 
            System.out.print(" " + mergedArray[x]);   
	}
	
	public static void mergeSort(char[] a, int n) {
	    if (n < 2) {
	        return;
	    }
	    int mid = n / 2;
	    char[] l = new char[mid];
	    char[] r = new char[n - mid];
	 
	    for (int i = 0; i < mid; i++) {
	        l[i] = a[i];
	    }
	    for (int i = mid; i < n; i++) {
	        r[i - mid] = a[i];
	    }
	    mergeSort(l, mid);
	    mergeSort(r, n - mid);
	 
	    merge(a, l, r, mid, n - mid);
	}
	
	public static void merge( char[] a, char[] l, char[] r, int left, int right) {
	    int i = 0, j = 0, k = 0;
	    while (i < left && j < right) {
	        if (l[i] <= r[j]) {
	            a[k++] = l[i++];
	        }
	        else {
	            a[k++] = r[j++];
	        }
	    }
	    while (i < left) {
	        a[k++] = l[i++];
	    }
	    while (j < right) {
	        a[k++] = r[j++];
	    }
	}

}
