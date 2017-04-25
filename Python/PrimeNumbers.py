def isPrime(number):
   for i in range(2,number):
      if number%i==0:
         return False      
   return True
      
print("begin")


print(isPrime(11))
print(isPrime(12))   
   
for i in range(2, 100):
   if isPrime(i):
      print (i)
        
print ("end")       
   
     