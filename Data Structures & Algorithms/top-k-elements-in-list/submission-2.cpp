class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        map<int, int> frequency;

        int n = nums.size();

        for (int i = 0; i < n; i++) {
            frequency[nums[i]]++;
        }

        vector<pair<int, int>> arr;

        for (auto &p: frequency) {
            arr.push_back({p.second, p.first});
        }

        sort(arr.rbegin(), arr.rend());

        vector<int> result;
        for (int i = 0; i < k; i++) {
            result.push_back(arr[i].second);
        }

        return result;
    }
};
