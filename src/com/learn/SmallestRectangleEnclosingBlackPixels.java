package com.learn;

public class SmallestRectangleEnclosingBlackPixels {
    public static void main(String[] args) {
        SmallestRectangleEnclosingBlackPixels s=new SmallestRectangleEnclosingBlackPixels();
        char mat[][]={{'0','0','1','0'},{'0','1','1','0'},{'0','1','0','0'}};
        int x = 0; int y = 2;
        int r=s.minArea(mat,x,y);
        System.out.println(r);
    }
    private char[][] image;
    public int minArea(char[][] iImage, int x, int y) {
        image = iImage;
        int m = image.length, n = image[0].length;
        int left = searchColumns(0, y, 0, m, true);
        int right = searchColumns(y + 1, n, 0, m, false);
        int top = searchRows(0, x, left, right, true);
        int bottom = searchRows(x + 1, m, left, right, false);
        return (right - left) * (bottom - top);
    }
    private int searchColumns(int i, int j, int top, int bottom, boolean opt) {
        while (i != j) {
            int k = top, mid = (i + j) / 2;
            while (k < bottom && image[k][mid] == '0') ++k;
            if (k < bottom == opt)
                j = mid;
            else
                i = mid + 1;
        }
        return i;
    }
    private int searchRows(int i, int j, int left, int right, boolean opt) {
        while (i != j) {
            int k = left, mid = (i + j) / 2;
            while (k < right && image[mid][k] == '0') ++k;
            if (k < right == opt)
                j = mid;
            else
                i = mid + 1;
        }
        return i;
    }
}
