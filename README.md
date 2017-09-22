# ModifiedMSP

Create a stable matching where every buyers has been matchead with
their desired number of sellers and every seller is match with exactly
one buyer.

##  Compile
**Java version : 1.8.0_60**

```javac ModifiedMSP/src/ModifiedMSP.java```

## Execution
```java ModifiedMSP/src/ModifiedMSP```

## Sample
```
$ javac ModifiedMSP/src/ModifiedMSP.java
$ java ModifiedMSP/src/ModifiedMSP
Start to do matching.
nBuyerWants [3, 2, 1, 2]
buyers [[0, 1, 2, 3, 4, 5, 6, 7], [0, 1, 2, 3, 4, 5, 6, 7], [0, 1, 2, 3, 4, 5, 6, 7], [0, 1, 2, 3, 4, 5, 6, 7]]
sellers [[0, 1, 2, 3], [0, 1, 2, 3], [0, 1, 2, 3], [0, 1, 2, 3], [0, 1, 2, 3], [0, 1, 2, 3], [0, 1, 2, 3], [0, 1, 2, 3]]
Results {0=[0, 1, 2], 1=[3, 4], 2=[5], 3=[6, 7]}
```
