import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
class Main{
	public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n==1){
        	System.out.println(1);
        }
        int[][] arr = new int[n][2]; //time_table[���� �ð�][������ �ð�]
        for(int i = 0; i < n; i++){
        	arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();            
        }
        
		Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
            	if(o1[0] == o2[0]) {
            		return (o1[1] - o2[1]);
            	}else {
            		return (o1[0] - o2[0]);
            	}
            }
        });
		int start = -1;
		int cnt = 0;
		for(int i = 0; i < arr.length; i++) {

			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println("");
		}
		boolean isContinue = false;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i][0] < start) continue;
			for(int j = i; j < arr.length; j++) {
				if(arr[j][0] > arr[i][1]) {
					//Ž���Ϸ��� ��ġ�� x���� ������ y���� �ʰ���
					//���Ĵ� �˻� �� �ʿ䰡 ����
					break;
				}
				if(arr[j][1] > arr[i][1]) {
					//Ž���Ϸ��� ��ġ�� y���� ������ y���� �ʰ���
					//���ķ� �Ѿ����
					continue;
				}
				if(arr[j][0] > arr[i][0] && arr[j][1] < arr[i][1]) {
					//���ۻ��� ���ɷȴ� �̻����� ������
					isContinue = true;
					break;
				}
			}
			if(isContinue) {
				isContinue = false;
				continue;
			}
			cnt++;
			start = arr[i][1];
			System.out.println(arr[i][0] + "|" + arr[i][1]);
		}
		System.out.println(cnt);
		sc.close();
    }
    public static int get_in_count(int[][] arr, int x, int y){
        int cnt = 0;
    	for(int i = 0; i < arr.length; i++){
        	if((arr[i][0] > x && arr[i][1] < y) || (arr[i][0] >x && arr[i][1] < y)) cnt++;
        }
        return cnt;
    }
}