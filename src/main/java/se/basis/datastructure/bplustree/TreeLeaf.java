package se.basis.datastructure.bplustree;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/3/15.
 * 叶子节点类
 */
public class TreeLeaf extends INode {
    public TreeLeaf() {
        this.isLeaf = true;
    }

    public ArrayList<Object> values = new ArrayList();
    public TreeLeaf rightBrother = null;
}
