
public class Ex2 {

    public static int count = 0;
    
    
    public static int countSeq(int v) {
        
        for (int i = 1; i <= v/2; i++) {
            int seq = i;
            for (int j = i + 1; j < v; j++) {
                seq += j;
                if (seq == v) {
                    count++;
                }
                else if (seq > v) {
                    break;
                }
            }
        }
        count += 1;
        return count;
    }


} 
