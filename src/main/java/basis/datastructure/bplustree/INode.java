package basis.datastructure.bplustree;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/3/15.
 * 节点父类
 */
public class INode {
    public boolean isLeaf = false;
    public INode parent = null;
    public ArrayList<Float> keys = new ArrayList();
    public ArrayList<INode> childNodes = new ArrayList();
}
