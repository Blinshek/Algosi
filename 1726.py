import math

n = int(input())
sumX, sumY, sumLen = 0,0,0
arrX = [0 for i in range(1000001)]
arrY = list(arrX)
paths = n * (n-1)

for i in range(n):
    x, y = map(int, input().split())
    sumX += x
    sumY += y
    arrX[x] += 1
    arrY[y] += 1


nX, nY = n, n

for i in range(1000001):
    if arrX[i] > 0:
        sumX -= arrX[i] * i
        nX -= arrX[i]
        sumLen += (sumX - (i * nX)) * arrX[i]
    if arrY[i] > 0:
        sumY -= arrY[i] * i
        nY -= arrY[i]
        sumLen += (sumY - (i * nY)) * arrY[i]

print(math.floor(2 * sumLen / paths))