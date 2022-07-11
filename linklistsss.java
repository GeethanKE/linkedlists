public class linklistsss {
  Node head;
  Object newNode;
  Object tail;

  class Node {
      int data;
      Node prev;
      Node next;

      Node(int d) { data = d; }
  }

  public void push(int new_data)
  {
      Node new_Node = new Node(new_data);

      new_Node.next = head;
      new_Node.prev = null;
      if (head != null)
          head.prev = new_Node;

      head = new_Node;
  }
  

  public void InsertBefore(Node next_node, int new_data)
  {

      if(next_node == null)
      {
          System.out.println("Node can not be NULL");
          return;
      }
        
      Node new_node = new Node(new_data);
        
      new_node.prev = next_node.prev;
      next_node.prev = new_node;
      new_node.next = next_node;

      if(new_node.prev != null)
          new_node.prev.next = new_node;
      else
          head = new_node;
  }
  public void InsertAfter(Node prev_Node, int new_data)
  {

      if (prev_Node == null) {
          System.out.println("Previous node cannot be NULL ");
          return;
      }

      Node new_node = new Node(new_data);

      new_node.next = prev_Node.next;
      prev_Node.next = new_node;
      new_node.prev = prev_Node;

      if (new_node.next != null)
          new_node.next.prev = new_node;
      
      if (newNode==null){
          tail = newNode;
      }
  }

  
  void append(int new_data)
  {
      Node new_node = new Node(new_data);

      Node last = head; 


      new_node.next = null;

      
      if (head == null) {
          new_node.prev = null;
          head = new_node;
          return;
      }

      while (last.next != null)
          last = last.next;

      last.next = new_node;
      new_node.prev = last;
  }

  public void printlist(Node node)
  {
      Node last = null;
      System.out.println("Traversal in forward Direction");
      while (node != null) {
          System.out.print(node.data + " ");
          last = node;
          node = node.next;
      }
      System.out.println();
      System.out.println("Traversal in reverse direction");
      while (last != null) {
          System.out.print(last.data + " ");
          last = last.prev;
      }
  }

  public static void main(String[] args)
  {
      linklistsss test = new linklistsss();

      test.append(6);
      test.push(7);
      test.push(1);
      test.append(4);
      test.InsertAfter(test.head.next, 8);
      test.InsertBefore(test.head.next.next, 5);

      System.out.println("Created DLL is: ");
      test.printlist(test.head);
  }
}
