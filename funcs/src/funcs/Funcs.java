package funcs;

import java.util.ArrayList;
import java.util.Iterator;

public class Funcs {

	/**
	 * 第一题 
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
	 * 第二题 
	 * @param a
	 * @param n
	 * @param m
	 * @return
	 */
	public int func2(int a[][],int n,int m) {//每次向下扫描两行中数字最小的，将其加入TOTAL中
		int total = 0;
		int temp=0;
		int temp2=0;
		int i=0;
		while(i<n) {                         //temp2标记当前两行中扫描到的最小的数，temp用于扫描，每次保存二者最小的值
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
	 * 第三题 设两位玩家 p1 p2
	 */
	/*
	 * 此函数用于将牌面转换为对应的数字，保存在一个数组中
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
	 * 此函数判断牌中是否有牛，若没有牛 返回null 若有牛 则返回剩余的两张牌的牌面值
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
	 * 此函数计算一个数组的所有数的和
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
		 * 当两位玩家都没有牛时，依次按大小比较其手牌，直到分出胜负
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
		 * 根据两位玩家是否有牛来判断胜负
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
		 * 当两位玩家都有牛时，根据其余手牌判断胜负
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
