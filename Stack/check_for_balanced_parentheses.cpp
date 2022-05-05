#include<iostream>
#include<stack>
using namespace std;

bool checkPair(char a, char b){
    if ((a == '[' && b == ']') || (a == '(' && b == ')')
     || (a == '{' && b == '}') || (a == '<' && b == '>'))
     return true;
}

bool isOpen(char x){
    if(x== '[' || x== '{' || x== '(' || x== '<')
    return true;
    else    
        return false;
}

bool checkBalancedParenthensis(char exp[], int n){
    bool flag = true;
    stack<char> S;
    for(int i=0; i<n; i++){
        if(exp[i] == '[' || exp[i] == '{' || exp[i] == '(' || exp[i] == '<'){
            S.push(exp[i]);
        }
        else{
            if(exp[i] == ']' || exp[i] == '}' || exp[i] == ')' || exp[i] == '>'){
                if(S.empty() || !checkPair(exp[i-1], exp[i])){
                    flag = false;
                }
                else{
                    S.pop();
                }
            }
            flag = S.empty()? true:false;
        }
    }
    return flag;
}

int main(){
    char exp[20];
    printf("Input s string of parentheses:  ");
    gets(exp);
    bool check = checkBalancedParenthensis(exp, strlen(exp));
    // if (check == 1){
    //     printf("This string is balanced parenthesis ");
    // }
    // else {
    //     if (check ==0)
    //     printf("This string is not balanced parenthesis ");
    // }
    printf("%d", check);
}
