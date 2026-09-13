class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        map<int, int> frequency;
        int n = nums.size();
        
        for (int i = 0; i < n; i++) {
            frequency[nums[i]]++;
        }

        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> minHeap;

        for (auto &element: frequency) {
            minHeap.push({element.second, element.first});
            if (minHeap.size() > k) {
                minHeap.pop();
            }
        }

        vector<int> result;

        for (int i = 0; i < k; i++) {
            result.push_back(minHeap.top().second);
            minHeap.pop();
        }

        return result;
    }
};
