public class infix2postfix {
    public static String infix2postfix(String infix){
        String postfix = "";
        StackChar stack = new StackChar(infix.length()/2+1);

        for(int i = 0; i < infix.length(); i++){
            char c = infix.charAt(i);

            if((c=='*')||(c=='/')||(c=='+')||(c=='-')){
                if((c=='+')||(c=='-')){
                    if(precedenceOf(stack.top()) > precedenceOf(c)){
                        char top = stack.top(); stack.pop();
                        stack.push(c);
                        postfix += top;
                    }
                    else {
                        stack.push(c);
                    }
                }

            }
            else {
                postfix += c;
            }
        }
        return postfix;
    }

    public static int precedenceOf(char c){
        int prec = -1;
        if((c=='+')||(c=='-')){
            prec = 0;
        }
        else if((c=='*')||(c=='/')){
            prec = 1;
        }
        return prec;
    }
}