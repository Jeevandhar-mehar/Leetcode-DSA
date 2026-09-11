class Solution {
    public double findMedianSortedArrays(int nums1[], int nums2[]) {
        int m = nums1.length;
        int n = nums2.length;
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i<m && j<n){
            if(nums1[i] <= nums2[j]){
                list.add(nums1[i]);
                i++;
            }
            else{
                list.add(nums2[j]);
                j++;
            }

        }
        while(i<m){
            list.add(nums1[i]);
            i++;
        }
        while(j<n){
            list.add(nums2[j]);
            j++;
        }
        if (list.size()%2 == 0){
            return (list.get(list.size()/2-1)+list.get(list.size()/2))/2.0;

        }
        else{
            return list.get(list.size() /2);
        }

    }
}