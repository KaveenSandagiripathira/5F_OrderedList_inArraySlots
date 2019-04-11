/**
  OrderedList_inArraySlots, holding Integers

  A list with the invariant the elements are in order by
  increasing value, implemented using a
  ArrayList<Integer>
 */

public class OrderedList_inArraySlots
    implements OrderedList {

    private java.util.ArrayList<Integer> list_iAS;


    /**
      @return the index of the first occurrence of 
              \findMe in this list, or -1 if
              \findMe is absent from this list.
     */
    public int indexOf( Integer findMe) {
		int high = size() - 1;
        // return binarySearchWhile_Style(0,high,findMe);
		return binarySearchRecursive(0, high, findMe);
    }
    
	private int binarySearchWhile_Style(int low, int high, int findMe){
		int indexToSearch;
		while (low <= high){
			indexToSearch = (low + high)/2;
			if (get(indexToSearch).compareTo(findMe) == 0)
				return indexToSearch;
			else if (get(indexToSearch).compareTo(findMe) < 0)
				low = indexToSearch + 1;
			else
				high = indexToSearch - 1;
		}
		return -1;
		
	}
	private int binarySearchRecursive(int low, int high, int findMe){
		if (low > high)
			return -1;
		else{
			int indexToSearch = (low + high)/2;
			if (get(indexToSearch).compareTo(findMe) == 0)
				return indexToSearch;
			else if (get(indexToSearch).compareTo(findMe) < 0)
				return binarySearchRecursive(indexToSearch + 1, high, findMe);
			else
				return binarySearchRecursive(low, indexToSearch -1, findMe);
		}
		
	}
    // ------ code from previous assignments below here ----

    public OrderedList_inArraySlots() {
        list_iAS = new java.util.ArrayList<Integer>();
    }

    /**
      @return the number of elements in this list
     */
    public int size(){
        return list_iAS.size();
    }

    /**
      @return a string representation of this Orderedlist_iAS
     */
    public String toString() {
        return list_iAS.toString();
    }


    /**
      Put @value where it belongs in the list.
      @pre: the list is in increasing order
     */
     public boolean add( Integer value) {
         int dest = 0;
         for( ; dest < list_iAS.size() && list_iAS.get( dest) < value
              ; dest++) ;
         // System.out.println( "OL adding " + value
         //                   + " at index " + dest);
         list_iAS.add( dest, value);
         return true;
     }


     /**
      @return element @index from this list
      precondition: @index is within the bounds of the array.
          (Having warned the user about this precondition,
           you should NOT complicate your code to check
           whether the condition was violated.)
     */
    public Integer get( int index ) {
        return list_iAS.get( index);
    }


    /**
      Remove the element at position @index in this list.

      Shift any subsequent elements to the left (that is,
      decrease the index associated with each).

      @return the value that was removed from the list
     */
    public Integer remove( int index) {
        return list_iAS.remove( index);
    }
}
