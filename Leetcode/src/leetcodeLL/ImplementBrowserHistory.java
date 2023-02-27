package leetcodeLL;

//You have a browser of one tab where you start on the homepage and you can visit another url, get back in the history number of steps or move forward in the history number of steps.
//
//Implement the BrowserHistory class:
//
//BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
//void visit(string url) Visits url from the current page. It clears up all the forward history.
//string back(int steps) Move steps back in history. If you can only return x steps in the history and steps > x, you will return only x steps. Return the current url after moving back in history at most steps.
//string forward(int steps) Move steps forward in history. If you can only forward x steps in the history and steps > x, you will forward only x steps. Return the current url after forwarding in history at most steps.

public class ImplementBrowserHistory {

	//doubly linked list
	class Node{
	    String url;
	    Node next;
	    Node prev;
	    public Node(String s){
	        this.url=s;
	    }
	}

	class BrowserHistory {

	    Node head;
	    public BrowserHistory(String homepage) {
	        head=new Node(homepage);
	    }
	    
	    //visited URL
	    public void visit(String url) {
	        Node temp= new Node(url);
	        head.next=temp;
	        temp.prev=head;
	        temp.next=null;
	        head=temp;
	    }
	    
	    public String back(int steps) {
	    	//go steps behind or till we reach beginning if steps> num of elements
	        for(int i=0;i<steps && head.prev!=null;i++)
	            head=head.prev;
	        return head.url;
	        
	    }
	    
	    //gp steps forward or till we reach the end of DLL
	    public String forward(int steps) {
	        for(int i=0;i<steps && head.next!=null;i++,head=head.next);
	        return head.url;
	    }
	}

	/**
	 * Your BrowserHistory object will be instantiated and called as such:
	 * BrowserHistory obj = new BrowserHistory(homepage);
	 * obj.visit(url);
	 * String param_2 = obj.back(steps);
	 * String param_3 = obj.forward(steps);
	 */
}
