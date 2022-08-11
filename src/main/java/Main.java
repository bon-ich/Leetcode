public class Main {
    public static void main(String[] args) {
        TreeNode tree = Unilities.formTree(new Integer[]{5,4,6,null,null,3,7});
        System.out.println(Problems.isValidBST(tree));
    }
}