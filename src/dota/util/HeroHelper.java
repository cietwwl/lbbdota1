package dota.util;

import dota.hero.Combater;
import static java.lang.Math.*;

public class HeroHelper {
	
	// 向上取整
	public static int getDistanceBetweenCombaters(Combater attacker, Combater defenser) {
		int disX = attacker.positionX - defenser.positionX;
		int disY = attacker.positionY - defenser.positionY;
		return (int) ceil(sqrt(disX * disX + disY * disY));
	}
	
	public static float getDistanceBetweenPoints(Point A, Point B) {
		int disX = A.x - B.x;
		int disY = A.y - B.y;
		return (float) sqrt(disX * disX + disY * disY);
	}
	
	// B是否在A的范围之内
	public static boolean isInRange(Combater A, Combater B, float distance) {
		if (isInRange(A.positionX, A.positionY, B, distance)) {
			return true;
		}
		return false;
	}
	
	public static boolean isInRange(int x, int y, Combater B, float distance) {
		int disX = x - B.positionX;
		int disY = y- B.positionY;
		float dis = (int) Math.sqrt(disX * disX + disY * disY);
		if (DotaMath.compareFloats(distance, dis, 0.01f) > 0) {
			return true;
		}
		return false;
	}
	
	// C是否在线段上, 线段以A为起点，AB为方向，长度是distance
	public static boolean isInSegment(Combater A, Combater B, Combater C, float distance) {
		if (isLine(A.positionX, A.positionY, B.positionX, B.positionY, C.positionX, C.positionY)) {
			if (getDistanceBetweenCombaters(A, C) <= distance) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean isLine(int x1, int y1, int x2, int y2, int x3, int y3) {
		return (y2 - y1) * (x3 - x1) == (x2 - x1) * (y3 - y1);
	}
	
	// 沿着A->B方向，找到C点，AC = distance
	public static Point getPointInSegment(Combater A, Combater B, float distance) {
		Point p = new Point(0, 0);
		Point p1 = new Point(A.positionX, A.positionY);
		Point p2 = new Point(B.positionX, B.positionY);
		// 求AB的长度
		float Sab = getDistanceBetweenPoints(p1, p2);
		float sin = (p2.y - p1.y) / Sab; 
		float cos = (p2.x - p1.x) / Sab;
		p.x = (int) (distance * cos + p1.x);
		p.y = (int) (distance * sin + p1.y);
		return p;
	}
}
