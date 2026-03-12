class Solution {
    class DSU {
        int parent[];

        DSU(int n){
            parent = new int[n];
            for(int i=0;i<n;i++) parent[i]=i;
        }

        int find(int x){
            if(parent[x]==x) return x;
            return parent[x]=find(parent[x]);
        }

        boolean union(int a,int b){
            int pa=find(a);
            int pb=find(b);
            if(pa==pb) return false;
            parent[pa]=pb;
            return true;
        }
    }
    public int maxStability(int n, int[][] edges, int k) {
        int left=0, right=0;
        for(int[] e:edges) right=Math.max(right,e[2]*2);

        int ans=-1;

        while(left<=right){
            int mid=(left+right)/2;

            if(can(n,edges,k,mid)){
                ans=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }

        return ans;
    }
    boolean can(int n,int[][] edges,int k,int target){

        DSU dsu=new DSU(n);
        int upgrades=0;
        int used=0;

        List<int[]> normal=new ArrayList<>();
        List<int[]> upgrade=new ArrayList<>();

        for(int[] e:edges){

            int u=e[0],v=e[1],s=e[2],must=e[3];

            if(must==1){

                if(s<target) return false;

                if(!dsu.union(u,v)) 
                    return false;

                used++;

            }else{

                if(s>=target) normal.add(e);
                else if(s*2>=target) upgrade.add(e);

            }
        }

        for(int[] e:normal){
            if(dsu.union(e[0],e[1])){
                used++;
            }
        }

        for(int[] e:upgrade){
            if(dsu.union(e[0],e[1])){
                upgrades++;
                used++;
                if(upgrades>k) return false;
            }
        }

        return used==n-1;
    }
}