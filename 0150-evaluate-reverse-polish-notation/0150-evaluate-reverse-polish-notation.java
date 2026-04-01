class Solution {
    public boolean isOperator(String op){
        return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")? true:false;
    }
    public int evalExp(String op, int opd1, int opd2){
        switch(op){
            case "+":
                return opd2+opd1;
            case "-":
                return opd2-opd1;
            case "*":
                return opd2*opd1;
            case "/":
                return opd2/opd1;
            default:
                return 0;
        }
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int opd1, opd2;
        for(String op : tokens){
            if(isOperator(op)){
                opd1 = st.pop();
                opd2 = st.pop();
                st.push(evalExp(op, opd1, opd2));
            }else{
                st.push(Integer.parseInt(op));
            }
        }
        return st.pop();
    }
}