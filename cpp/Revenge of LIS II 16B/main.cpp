#include <iostream>  
#include <algorithm>  
#include <string>  
#include <math.h>  
#include <vector>  
#include <cstring>  
#include <cstdio>  

using namespace std;
const long long N = 1100;
const long long Mod = 1000000007;
typedef long long LL;
int a[N], dp[N], sum[N];

int main() {
    int T;
    scanf("%d", &T);
    while (T--) {
        int n;
        scanf("%d", &n);
        int ma = 0;
        for (int i = 0; i < n; i++) {
            scanf("%d", &a[i]);
            ma = max(a[i], ma);
        }
        a[n++] = ma + 1;
        memset(sum, 0, sizeof(sum));
        dp[0] = 1;
        sum[0] = 1;
        for (int i = 1; i < n; i++) {
            int tmp = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (a[i] > a[j] && dp[j] > tmp)
                    tmp = dp[j];
            }
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] == tmp && a[j] < a[i])
                    sum[i] += sum[j];
            }
            if (sum[i] == 0)
                sum[i] = 1;
            dp[i] = tmp + 1;
        }
        int ans = 0;
        for (int i = 0; i < n; i++)
            ans = max(ans, dp[i]);
        if (sum[n - 1] == 1)
            ans--;
        printf("%d\n", ans - 1);
    }
    return 0;
}  