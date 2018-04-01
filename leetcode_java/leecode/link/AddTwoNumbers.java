package leecode.link;

import leecode.tree.ListNode;

/**
 * @author <a href="mailto:jian.wu@happyelements.com">jian.wu</a>
 * @version 1.0
 * @since 1.0
 */
public class AddTwoNumbers {

    public ListNode<Integer> addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> c1 = l1;
        ListNode<Integer> c2 = l2;
        ListNode<Integer> head = new ListNode<Integer>();
        head.setValue(0);
        ListNode<Integer> tmp = head;

        int sum = 0;
        while (c1 != null || c2 != null) {
            sum = sum / 10;
            if (c1 != null) {
                sum += c1.getValue();
                c1 = c1.getNext();
            }

            if (c2 != null) {
                sum += c2.getValue();
                c2 = c2.getNext();
            }

            ListNode<Integer> tt = new ListNode<Integer>();
            tt.setValue(sum % 10);
            tmp.setNext(tt);
            tmp = tt.getNext();

        }

        if (sum / 10 == 1) {
            ListNode<Integer> tt = new ListNode<Integer>();
            tt.setValue(1);
            tmp.setNext(tt);
        }

        return head.getNext();

    }
}
