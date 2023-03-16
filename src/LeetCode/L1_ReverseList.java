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

    //����
    public static ListNode iterate(ListNode head){
        // prev����ǰ�棬curr���м䣬next�ں���
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;
        while (curr != null){
            next = curr.next;  //�ȱ�����һ���ڵ�
            curr.next = prev;  //curr��ָ����ǰָ��ͬʱ�Ͽ�ԭ��������,ת��
            prev = curr;  //prevָ�����һ��
            curr = next;  //currָ�����һ��
        }
        return prev;  //����ͷ�ڵ�
    }


    //�ݹ�
    public static ListNode recursion(ListNode head){
        if (head == null || head.next == null){
            // ���ڵ�Ϊ�գ���ô���� null�����ڵ������һ���ڵ㣬��ô�������һ���ڵ㣨ת�ú��ͷ�ڵ㣩
            return head;
        }
        // �Լ����Լ����ҵ����һ���ڵ�,�������һ���ڵ㣬��ת�ú��ͷ�ڵ�
        ListNode new_head = recursion(head.next);
        head.next.next = head;
        head.next = null;
        return new_head;  //����ͷ�ڵ�

    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);  //1��2��3��4��5
        //1.������ת��
        //ListNode node = iterate(node1);
        //2.�ݹ���ת��
        ListNode node = iterate(node1);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
