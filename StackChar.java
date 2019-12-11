public class StackChar {
    private char []A;
    private int top = 1;

    public StackChar(int i){
        A = new char[i];
    }
    public void push(char x){
        top++;
        A[top] = x;
    }
    public char top(){
        return A[top];
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public void pop(){
        top--;
    }
    public int evalPostFix(String postFix){
        StackChar stack = new StackChar(postFix.length()/2+1);
        for(int i = 0; i < postFix.length(); i++){
            char c = postFix.charAt(i);
            if((c=='n')||(c=='*')||(c=='/')||(c=='+')||(c=='-')){
                int a = stack.top(); stack.pop();
                int b = stack.top(); stack.pop();
                if(c=='*'){
                    return a * b;
                }
                else if(c=='/'){
                    return a / b;
                }
                else if(c=='+'){
                    return a + b;
                }
                else if(c=='-'){
                    return a - b;
                }
                else if(c=='n'){
                    return a;
                }
            }
            else {
            }
        }
        return 0;
    }
}