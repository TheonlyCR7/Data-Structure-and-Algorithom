package Blinary572;


class BST {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null || t == null)
            return true;

        if( s.val == t.val){
            return isSubtree(s.left, t.left) && isSubtree(s.right, t.right);
        }
        else{
            isSubtree(s.left, t.left);
            isSubtree(s.right, t.right);
        }
        return false;
    }
}
