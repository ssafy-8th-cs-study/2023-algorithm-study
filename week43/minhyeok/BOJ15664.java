package week43.minhyeok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ15664 {
    static int N;
    static int M;
    static int[] arr;
    static HashSet<String> set;
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        set = new HashSet<>();
        dfs(0,0, new int[M]);
        System.out.println(ans);
    }

    private static void dfs(int idx, int cnt, int[] selected) {
        if (cnt == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(selected[i]).append(" ");
            }
            String str = sb.toString();
            if (!set.contains(str)) {
                set.add(str);
                ans.append(str+"\n");
            }
            return;
        }

        for (int i = idx; i < N; i++) {
            selected[cnt] = arr[i];
            dfs(i+1,cnt+1,selected);
        }
    }
}
