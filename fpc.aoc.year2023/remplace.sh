#!/bin/sh

for i in {5..25};do
 n1=$(printf "day%d" $i)
 n2=$(printf "day%02d" $i)
 N1=$(printf "Day%d" $i)
 
# rm -r fpc.aoc.$n2/target
# mv fpc.aoc.$n2/src/test/java/fpc/oac fpc.aoc.$n2/src/test/java/fpc/aoc
# mv fpc.aoc.$n2/src/test/java/fpc/aoc/day4 fpc.aoc.$n2/src/test/java/fpc/aoc/$n1
for file in $(find fpc.aoc.$n2 -name module-info.java  -exec echo {} \;); do
  dire=$(dirname $file)
   #sed -i "s/fpc.oac.day4/fpc.aoc.$n1/i"  $file
   sed -i "s/Day4/$N1/i"  $file

#    mv ${dire}/Day4Test.java ${dire}/${N1}Test.java
#  mv ${dire}/Day4Part1Solver.java ${dire}/${N1}Part1Solver.java
#  mv ${dire}/Day4Part2Solver.java ${dire}/${N1}Part2Solver.java

#   sed -i "s/Day4/$N1/i" $file
#  sed -i "s/Day4/$N1/i" ${dire}/${N1}Solver.java
#  sed -i "s/Day4/$N1/i" ${dire}/${N1}Part1Solver.java
#  sed -i "s/Day4/$N1/i" ${dire}/${N1}Part2Solver.java
#  sed -i "s/Day4/$N1/i" ${file}

done


done

