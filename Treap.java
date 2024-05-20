package org.example;

import java.util.Random;

public class Treap {
    static private Random rand = new Random();
    public int x;
    public int y;
    public Treap Left;
    public Treap Right;

    public Treap(int x) {
        this(x, rand.nextInt());
    }

    private Treap(int x, int y) {
        this.x = x;
        this.y = y;
        this.Left = null;
        this.Right = null;
    }

    private Treap(int x, int y, Treap left, Treap right) {
        this.x = x;
        this.y = y;
        this.Left = left;
        this.Right = right;
    }

    public static Treap Merge(Treap L, Treap R) {
        if (L == null) return R;
        if (R == null) return L;

        if (L.y > R.y) {
            return new Treap(L.x, L.y, L.Left, Merge(L.Right, R));
        } else {
            return new Treap(R.x, R.y, Merge(L, R.Left), R.Right);
        }
    }

    public Treap[] Split(int x) {
        Treap newTree = null;
        Treap L, R;
        if (this.x < x) {
            if (Right == null)
                R = null;
            else {
                Treap[] gg = Right.Split(x);
                newTree = gg[0];
                R = gg[1];
            }
            L = new Treap(this.x, y, Left, newTree);
        } else {
            if (Left == null)
                L = null;
            else {
                Treap[] gg = Left.Split(x);
                L = gg[0];
                newTree = gg[1];

            }
            R = new Treap(this.x, y, newTree, Right);
        }
        return new Treap[]{L, R};
    }

    public boolean find(int value) {
        if (x == value)
            return true;
        if (x > value)
            if (Left != null)
                return Left.find(value);
        if (x < value)
            if (Right != null)
                return Right.find(value);
        return false;
    }
    
    public Treap Add(int x) {
        Treap[] t = Split(x);
        Treap l = t[0];
        Treap r = t[1];
        Treap m = new Treap(x, rand.nextInt());
        return Merge(Merge(l, m), r);
    }

    public Treap Remove(int x) {
        if (this.x == x)
            return Merge(Left, Right);
        if (this.x > x)
            if (Left != null)
                Left = Left.Remove(x);
        if (this.x < x)
            if (Right != null)
                Right = Right.Remove(x);
        return this;
    }
}
