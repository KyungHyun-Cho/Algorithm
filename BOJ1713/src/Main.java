import java.util.*;
class Pic{
	int s_no, rCnt, rTime;
	Pic(int s_no, int rTime){
		this.s_no = s_no;
		this.rCnt = 0;
		this.rTime = rTime;
	}
	
}
class Pic2 implements Comparable<Pic2>{
	int idx, rCnt, rTime;
	Pic2(int idx, int rCnt, int rTime){
		this.idx = idx;
		this.rCnt = rCnt;
		this.rTime = rTime;
	}
	public int compareTo(Pic2 o) {
		if(rCnt == o.rCnt) return rTime - o.rTime;
		return rCnt - o.rCnt;
	}
	
}
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r_cnt = sc.nextInt();
		ArrayList<Pic> pic = new ArrayList<>();
		
		//�� ��õ Ƚ����ŭ �ݺ�
		for(int i = 0; i < r_cnt; i++) {
			int s_no = sc.nextInt();			
			if(i < n) {
				//�ʱ� nȸ������ ������ �߰�
				pic.add(new Pic(s_no, i));
			}else {
				boolean isContinue = false;
				//���� �л��� ��ǥ�� �� �޾Ҵٸ� ī��Ʈ++
				for(int j = 0; j < pic.size(); j++) {
					if(pic.get(j).s_no == s_no) {
						pic.get(j).rCnt++;
						isContinue = true;
						break;
					}
				}
				if(isContinue)
					continue;
				
				//�ش� ��ȣ�� ���ٸ�
				//1. ��õ Ƚ���� ���� ���� �л��� ����
				//2. ��õ Ƚ���� ���ٸ� ���� ���� ���� �л��� ����
				PriorityQueue<Pic2> q = new PriorityQueue<>();
				for(int j = 0; j < pic.size(); j++) {
					q.add(new Pic2(j, pic.get(j).rCnt, pic.get(j).rTime));
				}
				pic.remove(q.poll().idx);
				pic.add(new Pic(s_no, i));
			}
		}
		
		//����
		ArrayList<Integer> tmp = new ArrayList<>();
		for(int i = 0; i < pic.size(); i++)
			tmp.add(pic.get(i).s_no);
		Collections.sort(tmp);
		
		//���
		for(int i = 0; i < tmp.size(); i++)
			System.out.print(tmp.get(i) + " ");
	}

}
