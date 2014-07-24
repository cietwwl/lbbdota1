package dota.util;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import dota.hero.Combater;

public class DotaMath {
	public static int RandomInRange(int start, int end) {
		if (start > end) {
			return 0;
		}
		
		if (start == end) {
			return start;
		}
		
		if (end <=0 ) {
			return 0;
		}
		
		return ThreadLocalRandom.current().nextInt(end - start + 1) + start;
	}
	
	public static boolean doesRandomSuccess(float random) {
		float sysRandom = ThreadLocalRandom.current().nextFloat(); // 返回0到1之间的数值
		if (sysRandom < random) {
			return true;
		}
		return false;
	}
	
	public static int compareFloats(float a, float b, float precision) {
		if (a - b > precision) {
			return 1;
		} else if (a - b < -precision) {
			return -1;
		} else {
			return 0;
		}
	}
	
	// 点在多边形内部(凸包)(包括边上)
	// List<Point> polygon, 凸包顶点，顺时针
	// 该点的水平线与凸包边的单方向交点个数，若为基数就是点在凸包内
	public static boolean isPointInPolygon(Point point, List<Point> polygon) {
		
		int size = polygon.size();
		int nCount = 0;
		for (int i = 0; i < size; i++) {
			Point p1 = polygon.get(i);
			Point p2 = polygon.get((i+1)%size);
			// 平行
			if (p1.y == p2.y) {
				if (p1.y == point.y) {
					if (point.y >= Math.min(p1.y, p2.y) || point.y <= Math.max(p1.y, p2.y)) {
						return true;
					} else {
						return false;
					}
				}
				continue;
			}
			
			if (point.y < Math.min(p1.y, p2.y) || point.y >= Math.max(p1.y, p2.y)) {
				continue;
			}
			
			int x = (point.y - p1.y) * (p2.x - p1.x) / (p2.y - p1.y) + p1.x;
			
			if (x == point.x) {
				return true;
			} else {
				nCount ++;
			}
			
		}
		
		return nCount % 2 == 1;
	}
	
	public static int distance(Point p1, Point p2) {
		return (int) Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y -p2.y) * (p1.y-p2.y));
	}
	
	// 沿着A->B方向，找到C点，AC = distance
	public static Point getPointInSegment(Point p1, Point p2, float distance) {
		Point p = new Point(0, 0);
		// 求AB的长度
		float Sab = distance(p1, p2);
		float sin = (p2.y - p1.y) / Sab; 
		float cos = (p2.x - p1.x) / Sab;
		p.x = (int) (distance * cos + p1.x);
		p.y = (int) (distance * sin + p1.y);
		return p;
	}
	
	// 与AT垂直且经过T点， 距T点为DIS的两个点p1, p2
	public static void getPointsOfAT(Point pA, Point pT, Point p1, Point p2, int dis) {
		if (pA.x == pT.x) {
			p1.y = p2.y = pT.y;
			p1.x = pT.x + dis;
			p2.x = pT.x - dis;
			return;
		}
		
		if (pA.y == pT.y) {
			p1.x = p2.x = pT.x;
			p1.y = pT.y + dis;
			p2.y = pT.y - dis;
			return;
		}
		
		double kAT = (pA.y - pT.y) / (pA.x - pT.x);
		double kA1 = -1 / kAT;
		double sinP = Math.sqrt(kA1 * kA1 / (1 + kA1 * kA1));
		double cosP = sinP / kA1;
		
		p1.y = (int) (pT.y + dis * sinP);
		p1.x = (int) (pT.x + dis * cosP);
		
		p2.y = (int) (pT.y - dis * sinP);
		p2.x = (int) (pT.x - dis * sinP);
	}
}
