package basis.datastructure.bplustree;

/**
 * Created by Administrator on 2018/3/15.
 */
public class MyTreeGen {
    private int _m = 4;//--最大子树数目
    private int _min = 2;//--最小关键字
    private INode _research_result = null;
    private INode _rootNode = null;

    public MyTreeGen() {

    }

    public MyTreeGen(int m) {
        _m = m;
        _min = m / 2;
    }

    public boolean delete(float indexNo) {
        INode currentNode = search(indexNo);
        if (currentNode == null) {
            return false;
        }
        //todo
        return false;
    }

    public boolean insert(float indexNo, String value) {
        //如果根节点没有子树
        if (_rootNode.childNodes.size() <= 0) {
            //表明root还未初始化
            if (_rootNode.isLeaf == false) {
                TreeLeaf treeLeaf = new TreeLeaf();
                treeLeaf.isLeaf = true;
                treeLeaf.keys.add(indexNo);
                treeLeaf.values.add(value);
                _rootNode = treeLeaf;
                return true;
            }
            int indexL = -1;
            int cindex = 0;
            //找到具体应该插入的位置
            for (float keyNo : _rootNode.keys) {
                if (indexNo == keyNo) {
                    return false;
                } else if (indexNo < keyNo) {
                    break;
                } else {
                    indexL = cindex;
                }
                cindex++;
            }
            _rootNode.keys.add(indexL + 1, indexNo);
            ((TreeLeaf)_rootNode).values.add(indexL + 1, value);
            recurse_division_after_insert(_rootNode);
            return true;
        } else {
            TreeLeaf theLeaf = recurse_search_suitable_leaf(_rootNode, indexNo);
            if (theLeaf == null) {
                return false;
            }
            int cindex = 0;
            int indexL = -1;
            for (float key : theLeaf.keys) {
                if (key == indexNo) {
                    return false;
                }
                if (indexNo > key) {
                    indexL = cindex;
                }
                if (indexNo < key) {
                    break;
                }
            }
            theLeaf.keys.add(indexL + 1, indexNo);
            theLeaf.values.add(indexL + 1, value);
            if (indexL == -1) {
                recurse_changeMinimum(theLeaf, indexNo);
            }
            recurse_division_after_insert(theLeaf);
        }
        return true;
    }

    private void recurse_changeMinimum(INode node, float indexNo) {
        if (node == null) {
            return;
        }
        if (node.keys.get(0) != indexNo) {
            node.keys.set(0, indexNo);
        }
        recurse_changeMinimum(node.parent, indexNo);
    }

    //递归分裂
    private void recurse_division_after_insert(INode node) {
        //不超过key的最大数量
        if (node.keys.size() <= _m) {
            return;
        }
        //是叶子节点，则直接分裂出一个rightBrother，把min到最后的给它
        if (node.isLeaf == true) {
            TreeLeaf currentLeaf = (TreeLeaf) node;
            TreeLeaf rightBrother = new TreeLeaf();
            //链表插入
            rightBrother.rightBrother = currentLeaf.rightBrother;
            rightBrother.parent = currentLeaf.parent;
            currentLeaf.rightBrother = rightBrother;
            //由于是涉及到remove操作，不能边加边删
            int cindex = 0;
            for (float key : currentLeaf.keys) {
                if (cindex >= _min) {
                    rightBrother.keys.add(key);
                    rightBrother.values.add(currentLeaf.values.get(cindex));
                }
            }
            int size = currentLeaf.keys.size();
            for (int i = size - 1; i >= _min; i--) {
                currentLeaf.keys.remove(i);
                currentLeaf.values.remove(i);
            }
            if (currentLeaf.parent == null) {
                TreeNode root = new TreeNode();
                root.childNodes.add(currentLeaf);
                root.childNodes.add(rightBrother);
                root.keys.add(currentLeaf.keys.get(0));
                root.keys.add(rightBrother.keys.get(0));
                currentLeaf.parent = root;
                rightBrother.parent = root;
                _rootNode = root;
                return;
            } else {
                int cLindex = currentLeaf.parent.keys.indexOf(currentLeaf);
                currentLeaf.parent.keys.add(cLindex + 1, rightBrother.keys.get(0));
                currentLeaf.parent.childNodes.add(cLindex + 1, rightBrother);
                recurse_division_after_insert(currentLeaf.parent);
                return;
            }
        } else {
            TreeNode currentNode = (TreeNode) node;
            TreeNode newNode = new TreeNode();
            newNode.parent = currentNode.parent;
            for (int i = _min; i < currentNode.keys.size(); i++) {
                newNode.keys.add(currentNode.keys.get(i));
                newNode.childNodes.add(currentNode.childNodes.get(i));
            }
            for (int i = currentNode.keys.size() - 1; i >= _min; i--) {
                currentNode.keys.remove(i);
                currentNode.childNodes.remove(i);
            }
            if (currentNode.parent == null) {
                TreeNode root = new TreeNode();
                root.childNodes.add(currentNode);
                root.childNodes.add(newNode);
                root.keys.add(currentNode.keys.get(0));
                root.keys.add(newNode.keys.get(0));
                currentNode.parent = root;
                newNode.parent = root;
                _rootNode = root;
                return;
            } else {
                int cLindex = currentNode.parent.childNodes.indexOf(currentNode);
                currentNode.parent.childNodes.add(cLindex + 1, newNode);
                currentNode.parent.keys.add(cLindex + 1, newNode.keys.get(0));
                recurse_division_after_insert(currentNode.parent);
                return;
            }
        }
    }

    private TreeLeaf recurse_getLeftLeaf(INode currentNode) {
        if (currentNode == null) {
            return null;
        }
        if (currentNode.isLeaf == true) {
            return (TreeLeaf) currentNode;
        }
        if (currentNode.childNodes.size() <= 0) {
            return null;
        }
        return recurse_getLeftLeaf(currentNode.childNodes.get(0));
    }

    public TreeLeaf recurse_search_suitable_leaf(INode currentNode, float indexNo) {
        if (currentNode == null) {
            return null;
        } else if (currentNode.isLeaf == true && currentNode.childNodes.size() <= 0) {
            return (TreeLeaf) currentNode;
        }
        if (currentNode.childNodes.size() > 0) {
            int indexL = -1;
            int cindex = 0;
            for (float key : currentNode.keys) {
                if (key == indexNo) {
                    return null;
                } else if (key > indexNo) {
                    break;
                } else {
                    indexL = cindex;
                }
                cindex++;
            }
            if (indexL == -1) {
                return recurse_getLeftLeaf(currentNode);
            } else {
                return recurse_search_suitable_leaf(currentNode.childNodes.get(indexL), indexNo);
            }
        }
        return null;
    }

    private void recursion_to_search(INode currentNode, float indexNo) {
        if (currentNode == null) {
            return;
        }
        if (currentNode.isLeaf == false && currentNode.childNodes.size() > 0) {
            int cindex = 0;
            int indexL = -1;
            for (float key : currentNode.keys) {
                if (indexNo >= key) {
                    indexL = cindex;
                } else {

                }
            }
        }
    }

    private INode search(float indexNo) {
        _research_result = null;
        recursion_to_search(_rootNode, indexNo);
        return _research_result;
    }
}
