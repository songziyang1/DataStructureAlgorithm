package LeetCode;

public class L1_ReverseList {
    static class ListNode {
        int val;
        ListNode next;


        //adsadasdads
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //迭代
    public static ListNode iterate(ListNode head){
        // prev在最前面，curr在中间，next在后面
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;
        while (curr != null){
            next = curr.next;  //先保存下一个节点
            curr.next = prev;  //curr的指针往前指，同时断开原来的连接,转置
            prev = curr;  //prev指针后移一个
            curr = next;  //curr指针后移一个
        }
        return prev;  //返回头节点
    }


    //递归
    public static ListNode recursion(ListNode head){
        if (head == null || head.next == null){
            // 若节点为空，那么返回 null；若节点是最后一个节点，那么返回最后一个节点（转置后的头节点）
            return head;
        }
        // 自己调自己，找到最后一个节点,返回最后一个节点，即转置后的头节点
        ListNode new_head = recursion(head.next);
        head.next.next = head;
        head.next = null;
        return new_head;  //返回头节点

    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);  //1，2，3，4，5
        //1.迭代求转置
        //ListNode node = iterate(node1);
        //2.递归求转置
        ListNode node = iterate(node1);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
