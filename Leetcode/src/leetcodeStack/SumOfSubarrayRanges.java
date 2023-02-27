package leetcodeStack;

public class SumOfSubarrayRanges {

	// decreasing stack --> finds previous greater and next greater elements
	// increasing stack --> finds previous lesser and next lesser elements

	// in decreasing stack --> whenever i am popping an element from the stack, the
	// current element is the next greater element of the element being popped
	// ex stack ==5 4 3, curr==9, i am popping 3 4 5 in order. so curr element 9, is
	// the next greater element of all 3

	// in increasing stack --> whenever i am popping an element, the element being
	// popped is the previous greater element of my current element example,
	// stack==1 2 3 7 curr==4, i pop 7. so 7 is the previous greater element than
	// curr 4
}
