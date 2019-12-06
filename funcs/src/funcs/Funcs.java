package funcs;

import java.util.ArrayList;
import java.util.Iterator;

public class Funcs {

	/**
	 * ��һ�� 
	 * @param a
	 * @param b
	 * @return
	 */
	public ArrayList<Integer> func1(int a[],int b[]) {
		ArrayList<Integer> c = new ArrayList<Integer>();
		int i=0;int j=0;
		while(i<a.length&&j<b.length) {
			if(a[i]==b[j]) {
				c.add(a[i]);
			}else if(a[i]>a[j]) {
				j++;
			}else if(a[i]<a[j]) {
				i++;
			}
		}
		Iterator<Integer> it = c.iterator();
		while(it.hasNext())
			System.out.println(it.next()+" ");
		return c;
	}
	
	/**
	 * �ڶ��� 
	 * @param a
	 * @param n
	 * @param m
	 * @return
	 */
	public int func2(int a[][],int n,int m) {//ÿ������ɨ��������������С�ģ��������TOTAL��
		int total = 0;
		int temp=0;
		int temp2=0;
		int i=0;
		while(i<n) {                         //temp2��ǵ�ǰ������ɨ�赽����С������temp����ɨ�裬ÿ�α��������С��ֵ
			temp2=total+a[i][0];
			for(int j=0;j<m;j++) {
				temp=total+a[i][j];
				if(temp2>temp) {
					temp2=temp;
				}
			}
			if(i<n-1) {
				i++;
				temp2=total+a[i][0];
				for(int j=0;j<m;j++) {
					temp=total+a[i][j];
					if(temp2>temp) {
						temp2=temp;
					}
				}
			}
			i++;
			total+=temp2;
		}
		return total;
	}
	
	/**
	 * ������ ����λ��� p1 p2
	 */
	/*
	 * �˺������ڽ�����ת��Ϊ��Ӧ�����֣�������һ��������
	 */
	public int[] getNumbsForFunc3(String str) {
		int res[] = new int[5];
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='A') {
				res[i]=1;
			}else if(Character.isDigit(str.charAt(i))) {
				res[i]=Character.digit(str.charAt(i),10);
			}else {
				res[i]=10;
			}
		}
		return res;
	}
	
	/*
	 * �˺����ж������Ƿ���ţ����û��ţ ����null ����ţ �򷵻�ʣ��������Ƶ�����ֵ
	 */
	public int[] niuOrNot(int p[]) {
		int res[] = new int[2];
		int sum = 0;
		for(int i=0;i<5;i++) {
			sum = sum +p[i];
		}
		for(int i=0;i<5;i++) {
			for(int j=i+1;j<5;j++) {
				if((sum-p[i]-p[j])%10==0){
					res[0]=p[i];res[1]=p[j];
					return res;
				}
			}
		}
		return null;
	}
	
	/*
	 * �˺�������һ��������������ĺ�
	 */
	public int sumUp(int p[]) {
		int sum=0;
		for(int i=0;i<p.length;i++)
			sum+=p[i];
		return sum;
	}
	
	public int func3(String sp1,String sp2) {
		int res=0;
		int p1[]=getNumbsForFunc3(sp1);
		int p2[]=getNumbsForFunc3(sp2);
		int sump1=sumUp(p1);
		int sump2=sumUp(p2);
		
		/*
		 * ����λ��Ҷ�û��ţʱ�����ΰ���С�Ƚ������ƣ�ֱ���ֳ�ʤ��
		 */
		if(niuOrNot(p1)==null&&niuOrNot(p2)==null) {
			for(int i=4;i>=0;i++) {
				if(p1[i]==p2[i])
					i--;
				else 
					return (p1[i]>p2[i])?1:-1;
			}
			return 0;
		}
		
		/**
		 * ������λ����Ƿ���ţ���ж�ʤ��
		 */
		if(niuOrNot(p1)!=null) {
			if(niuOrNot(p2)==null) {
				return 1;
			}
		}
		
		if(niuOrNot(p2)!=null) {
			if(niuOrNot(p1)==null) {
				return -1;
			}
		}
		
		/**
		 * ����λ��Ҷ���ţʱ���������������ж�ʤ��
		 */
		
		if(niuOrNot(p1)!=null&&niuOrNot(p2)!=null) {
			if(sump1%10==0&&sump2%10==0) return 0;
			if(sump1%10==0&&sump2%10!=0) return 1;
			if(sump1%10!=0&&sump2%10==0) return -1;
			int[] P1Cards = niuOrNot(p1);
			int[] P2Cards = niuOrNot(p2);
			if(sumUp(P1Cards)%10==sumUp(P2Cards)%10) {
				return 0;
			}else {
				return (sumUp(P1Cards)%10>sumUp(P2Cards)%10)?1:-1;
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println();
	}

}
