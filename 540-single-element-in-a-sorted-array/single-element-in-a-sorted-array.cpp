class Solution {
public:
    int singleNonDuplicate(vector<int>& A) {
        int n = A.size();

        // Edge case
        if (n == 1)
            return A[0];

        int st = 0, end = n - 1;

        while (st <= end) {
            int mid = st + (end - st) / 2;

            //first element
            if (mid == 0 && A[0] != A[1])
                return A[mid];

            //last element
            if (mid == n - 1 && A[n - 1] != A[n - 2])
                return A[mid];

            // if current element is unique
            if (A[mid - 1] != A[mid] && A[mid] != A[mid + 1])
                return A[mid];

            
            if (mid % 2 == 0) {

                if (A[mid - 1] == A[mid]) { 
                    end = mid - 1;
                } else { 
                    st = mid + 1;
                }

            } 
            // Odd index
            else {

                if (A[mid - 1] == A[mid]) { 
                    st = mid + 1;
                } else { 
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
};