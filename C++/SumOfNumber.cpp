#include<iostream>
using namespace std;

int main(){

 unsigned long int sum;

  for(int i=1; i<=10000000; i++){
     sum=sum+i;

  }

  cout << "The sum of number from 1 to 100 is: " << sum << endl;

  return 0;

}
