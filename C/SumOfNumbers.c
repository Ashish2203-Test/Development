#include<stdio.h>

int main(){

  int sum=0;
  int *ip=0;
  *ip=sum;
  
  
  for(int i=1; i<=10; i++){
  
     sum+=i;

  }

  printf("The result is: %d\n",sum);
  printf("the address is: %d\n ", *ip);

}
