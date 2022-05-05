#include<iostream>
#include<stack>
using namespace std;

int Perform(char a, int x, int y){
    if (a = '+'){
        return x+y;
    }
    if (a = '-'){
        return x-y;
    }
    if (a = '*'){
        return x*y;
    }
    if (a = '/'){
        return x/y;
    }
}

int EvaluatePostfix(char exp[], int n){
    int op1, op2, result;
    stack<char> S;
    for (int i =0; i<n; i++){
        if(exp[i].isnum()){                 // if exp[i] is a operant, put it into stack
            S.push(exp[i]);
        }
        else{                               // if exp[i] is an operator
            op1 = S.pop();           // get operant in which is put in stack
            op2 = S.pop();
            result = Perform(exp[i], op1, op2);
            S.push(result);                 // do the expression and then put into stack
        }
    }
    return S.top();
}

int main(){
    char C[20];
    printf("Enter a expression :  ");
    gets(C);
    EvaluatePostfix(C, strlen(C));
}