
values = list(map(int, input().split()))[:8]
letters = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H']

if values[0] + values[2] + values[5] + values[7] != values[1] + values[3] + values[4] + values[6]:
    print('IMPOSSIBLE')
    quit()

for i in [0, 2, 5, 7]:
    while values[i] != 0:
        if values[i + (1 if(i != 7) else -3)] > 0:
            values[i] -= 1
            values[i + (1 if(i != 7) else -3)] -= 1
            print(letters[i], letters[i + (1 if(i != 7) else -3)], '-', sep = '')
        elif values[i + (-1 if (i != 0) else 3)] > 0:
            values[i] -= 1
            values[i + (-1 if (i != 0) else 3)] -= 1
            print(letters[i], letters[i + (-1 if (i != 0) else 3)], '-', sep = '')
        elif values[i + (4 if i < 4 else -4)] > 0:
            values[i] -= 1
            values[i + (4 if i < 4 else -4)] -= 1
            print(letters[i], letters[i + (4 if i < 4 else -4)], '-', sep = '')
        elif values[(i + (6 if i == 0 or i == 5 else 2)) % 8] > 0:
            values[i] -= 1
            values[(i + (6 if i == 0 or i == 5 else 2)) % 8] -= 1
            print(letters[i + (1 if(i != 7) else -3) + (4 if i < 4 else -4)], letters[i + (1 if(i != 7) else -3)], '+', sep = '')
            print(letters[i], letters[i + (1 if(i != 7) else -3)], '-', sep = '')
            print(letters[i + (1 if(i != 7) else -3) + (4 if i < 4 else -4)], letters[(i + (6 if i == 0 or i == 5 else 2)) % 8], '-', sep = '')