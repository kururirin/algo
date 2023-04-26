class RemoveElement {
    public static int[] removeElement(int[] nums, int val) {
        int expectedLength = 0;
        int[] filteredNums = new int[nums.length];
        for (int i=0; i<nums.length; i++){
            if (nums[i] != val){
                filteredNums[expectedLength] = nums[i];
                expectedLength ++;
            }
        }
        int[] expectedNums = new int[expectedLength];
        for (int i=0; i<expectedLength; i++){
            expectedNums[i] = filteredNums[i];
        }
//        return expectedLength;
        return expectedNums;
    }

    public static void main(String[] args) {
        int [] newNums = removeElement( new int[] {0,1,2,2,3,0,4,2} , 2);
        for (int i = 0; i < newNums.length; i++) {
            System.out.print(newNums[i] + " ");
        }

    }
}
