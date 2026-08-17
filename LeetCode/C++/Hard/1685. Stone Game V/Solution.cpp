class Solution {
public:
    int dp[501][501];
    int help(int s,int e,vector<int>& v)
    {
        if(s>e)return 0;
        if(dp[s][e]!=-1)return dp[s][e];
        int r=0;
        for(int i=s;i<=e;i++)
        {
            r+=v[i];
        }
        int l=0;
        int ans=0;
        for(int i=s;i<=e;i++)
        {
            l+=v[i];
            r-=v[i];
            if(l<r)ans=max(ans,l+help(s,i,v));
            if(l==r)ans=max(ans,l+max(help(s,i,v),help(i+1,e,v)));
            if(r<l)ans=max(ans,r+help(i+1,e,v));
        }
        return dp[s][e]=ans;
    }
    
    int stoneGameV(vector<int>& stoneValue)
    {
        memset(dp,-1,sizeof dp);
        return help(0,stoneValue.size()-1,stoneValue);
    }
};