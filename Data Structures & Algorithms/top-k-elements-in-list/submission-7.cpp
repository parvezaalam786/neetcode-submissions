class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> frequency;
        int n = nums.size();

        vector<vector<int>> count(n + 1);

        for (int i = 0; i < n; i++) {
            frequency[nums[i]]++;
        }

        for (auto &element: frequency) {
            count[element.second].push_back(element.first);
        }

        vector<int> result;
        int cnt = 0;

        for (int i = count.size() - 1; i >= 0; i--) {
            for (auto x: count[i]) {
                result.push_back(x);
                cnt++;
                if (cnt == k) {
                    return result;
                }
            }
        }
        
        return result;
    }
};
