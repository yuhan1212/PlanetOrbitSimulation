public class BuildXmasTree {

    int topHeight;
    int floor;

	public static BuildXmasTree(int t, int f) {
        t = topHeight;
        f = floor;
            
        for (int i = 0; i < f; i+=2) {
            int x = 1 + 2*f;
            while (n > 0) {
                int y = x;
                while (y > 1){
                    System.out.print('*');
                    y = y - 1;
                }
                System.out.println('*');
                n = n - 1;
                x = x + 1;
            }
        }
    }        
	public static void main (String[] args) {
		BuildXmasTree(3, 3);
	}
	
} 
