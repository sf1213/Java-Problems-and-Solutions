package String;

public class String_Replace_841 {

public String stringReplace(String[] a, String[] b, String s) {
       StringBuilder builder = new StringBuilder(s);
       int seed = 33;
       int mod = 1000000007;
       int ans, mxLen = -1;
       Vector<Integer> aHash = new Vector<Integer>();
       Vector<Integer> sHash = new Vector<Integer>();
       Vector<Integer> base = new Vector<Integer>();
       
       for(int i = 0; i < a.length; i++) {
           ans = 0;
           mxLen = Math.max(mxLen, a[i].length());
           for(int j = 0; j < a[i].length(); j++) {
                ans = (int) (((long)ans * (long)seed + (long)a[i].charAt(j) - (long)'a') % (long)mod);
           }
           aHash.add(ans);
       }
       ans = 0;
       sHash.add(ans);
       mxLen = Math.max(mxLen, s.length());
       for(int i = 0; i < s.length(); i++) {
           ans = (int) (((long)ans * (long)seed + (long)s.charAt(i) - (long)'a') % (long)mod);
           sHash.add(ans);
       }
       ans = 1;
       base.add(ans);
       for(int i = 0; i < mxLen; i++) {
           ans = (int) ((long)ans * (long)seed  % (long)mod);
           base.add(ans);
       }
       for(int i = 0; i < s.length(); i++) {
           int maxLen = -1;
           int index = -1;
           for(int j = 0; j < a.length; j++) {
               int len = a[j].length();
               int l = i;
               int r = i + len;
               if(r > s.length()  ) {
                   continue;
               }
               int sHashValue = (int)(((long)sHash.get(r) - (long)(base.get(len)) * (long)sHash.get(l) % (long)mod + (long)mod) % (long)mod);
               int aHashValue = aHash.get(j);
               if(sHashValue == aHashValue && len > maxLen && s.substring(i, i + len).equals(a[j])) {
                   maxLen = len;
                   index = j;
               }
           }
           if(maxLen != -1) {
               builder.replace(i, i + maxLen, b[index]);
               i += maxLen - 1;
           }
       }
       return builder.toString();
    }
}
