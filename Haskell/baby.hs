doubleMe x = x + x
doubleUs x y =x*2 + y*2
doubleUs2 x y = doubleMe x + doubleMe y
doubleSmallNumber x = if x > 100 then x else x*2
doubleSmallNumber' x= (if x > 100 then x else x*3)+1
conanO'Brien = "It's a-me, Conan O'Brien!"

factorial :: Integer  -> Integer
factorial n = product [1..n]


factor :: (Integral a) => a -> a
factor 0 = 1
factor n = n * factor (n-1)

bmiTell :: (RealFloat a) => a -> a -> String
bmiTell weight height
 |bmi <= 18.5 = "You are underweight"
  |bmi <= 25 = "You are supposedly normal"
   |bmi <= 30 = "You are fat lose some weight"
    |otherwise = "You are a whale"
     where bmi = weight / height ^ 2 

applyTwice :: (a -> a) -> a -> a
applyTwice f a = f (f a)