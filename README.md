# zooGraphColoringAlgorithm
**Задача**
> Найти минимальное количество вольеров для животных, учитывая что некоторые животные не могут находится в одном и том же вольере с другими. 

Для решения задачи используется алгоритм прямого неявного перебора для нахождения хроматического числа графа. То есть минимальное количество вольеров для животных соответствует минимальному количеству цветов, которыми можно раскрасить вершины графа так, чтобы любые две соседние вершины имели разный цвет. При том, что животное будет вершиной в графе, а ребра графа - связи между животными, указывающие на то, что они не могут находится в одном вольере.
## Пример
Есть животные:
```
Animal_0, Animal_1, Animal_3, Animal_4, Animal_5
```
Запись "Animal_0 - Animal_1" означает, что Animal_0 не может находится с Animal_1 в одном вольере.
```
Animal_0 - Animal_2
Animal_0 - Animal_3
Animal_2 - Animal_5
Animal_3 - Animal_4
Animal_1 - Animal_4
Animal_1 - Animal_5
```
Тогда граф будет выглядить следующим образом:
<p align="center">
  <img src="https://github.com/DemidovDG/pictures/raw/main/zooGraphColoringAlgorithm/graph_1.png" width="338px" height="347px"/></p>

**Код**
```Java
Zoo z = new Zoo();

//Добавление животных
z.add("Animal_0");
z.add("Animal_1");
z.add("Animal_2");
z.add("Animal_3");
z.add("Animal_4");
z.add("Animal_5");

//Задавание связей о невозможности размещения в одном вольере
z.edge("Animal_0", "Animal_2", true);
z.edge("Animal_0", "Animal_3", true);
z.edge("Animal_2", "Animal_5", true);
z.edge("Animal_3", "Animal_4", true);
z.edge("Animal_1", "Animal_4", true);
z.edge("Animal_1", "Animal_5", true);

//Распределение по вольерам и вывод результатов
z.distribution();
z.soutMat();
z.soutAvi();
z.soutNames();
```
**Животные**
```
[0] Animal_0. [1] Animal_1. [2] Animal_2. [3] Animal_3. [4] Animal_4. [5] Animal_5.
```
**Матрица связей**
```
	 |  0 |  1 |  2 |  3 |  4 |  5 |
0	 |____|____|XXXX|XXXX|____|____|
1	 |____|____|____|____|XXXX|XXXX|
2	 |XXXX|____|____|____|____|XXXX|
3	 |XXXX|____|____|____|XXXX|____|
4	 |____|XXXX|____|XXXX|____|____|
5	 |____|XXXX|XXXX|____|____|____|
```
**Вольеры**
```
_____________________[1]___________________________________________________________
Animal_0. Animal_4. Animal_5. 
_____________________[2]___________________________________________________________
Animal_1. Animal_2. Animal_3. 
```
В виде графа выглядит следующим образом:
<p align="center">
  <img src="https://github.com/DemidovDG/pictures/raw/main/zooGraphColoringAlgorithm/graph_2.png" width="338px" height="347px"/></p>

## Более сложный пример
*Код данного примера есть в программе.*

**Животные**
```
[0] Тигр. [1] Тигр1. [2] Тигр2. [3] Тигр3. [4] Тигр4. [5] Тигр5. [6] Тигр6. [7] Тигр7. [8] Тигр8. [9] Тигр9. [10] Тигр10.
[11] Воробей11. [12] Гепард12. [13] Гепард13. [14] Гепард14. [15] Гепард15. [16] Гепард16. [17] Гепард17. [18] 18. [19] 19. [20] 20.
[21] 21. [22] 22. [23] 23. [24] 24. [25] 25. [26] 26. [27] 27. [28] 28. [29] 29.  
```
**Матрица связей**
```
	 |  0 |  1 |  2 |  3 |  4 |  5 |  6 |  7 |  8 |  9 |  10|  11|  12|  13|  14|  15|  16|  17|  18|  19|  20|  21|  22|  23|  24|  25|  26|  27|  28|  29|
0	 |____|____|XXXX|XXXX|XXXX|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|
1	 |____|____|XXXX|XXXX|____|XXXX|XXXX|____|____|XXXX|XXXX|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|
2	 |XXXX|XXXX|____|____|XXXX|XXXX|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|
3	 |XXXX|XXXX|____|____|XXXX|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|
4	 |XXXX|____|XXXX|XXXX|____|XXXX|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|
5	 |____|XXXX|XXXX|____|XXXX|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|
6	 |____|XXXX|____|____|____|____|____|XXXX|XXXX|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|
7	 |____|____|____|____|____|____|XXXX|____|XXXX|XXXX|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|
8	 |____|____|____|____|____|____|XXXX|XXXX|____|____|XXXX|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|
9	 |____|XXXX|____|____|____|____|____|XXXX|____|____|XXXX|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|
10	 |____|XXXX|____|____|____|____|____|____|XXXX|XXXX|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|
11	 |____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|
12	 |____|____|____|____|____|____|____|____|____|____|____|____|____|____|XXXX|XXXX|____|____|____|____|____|____|____|____|____|____|____|____|____|____|
13	 |____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|XXXX|XXXX|____|____|____|____|____|____|____|____|____|____|____|____|
14	 |____|____|____|____|____|____|____|____|____|____|____|____|XXXX|____|____|____|____|XXXX|____|____|____|____|____|____|____|____|____|____|____|____|
15	 |____|____|____|____|____|____|____|____|____|____|____|____|XXXX|____|____|____|XXXX|____|____|____|____|____|____|____|____|____|____|____|____|____|
16	 |____|____|____|____|____|____|____|____|____|____|____|____|____|XXXX|____|XXXX|____|____|____|____|____|____|____|____|____|____|____|____|____|____|
17	 |____|____|____|____|____|____|____|____|____|____|____|____|____|XXXX|XXXX|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|
18	 |____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|
19	 |____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|XXXX|____|____|____|____|____|____|____|____|____|
20	 |____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|XXXX|____|____|____|____|____|____|____|____|____|____|
21	 |____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|
22	 |____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|XXXX|____|XXXX|XXXX|____|____|XXXX|
23	 |____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|XXXX|____|XXXX|____|XXXX|XXXX|____|____|
24	 |____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|XXXX|____|XXXX|____|XXXX|XXXX|____|
25	 |____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|XXXX|____|XXXX|____|____|____|XXXX|XXXX|
26	 |____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|XXXX|XXXX|____|____|____|XXXX|XXXX|XXXX|
27	 |____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|XXXX|XXXX|____|XXXX|____|XXXX|XXXX|
28	 |____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|XXXX|XXXX|XXXX|XXXX|____|XXXX|
29	 |____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|____|XXXX|____|____|XXXX|XXXX|XXXX|XXXX|____|
```
В виде графа выглядит следующим образом:
<p align="center">
  <img src="https://github.com/DemidovDG/pictures/raw/main/zooGraphColoringAlgorithm/true_graph_1.png" width="542px" height="385px"/></p>

**После распределения по вольерам**
```
_____________________[1]___________________________________________________________
Тигр. Тигр1. Тигр7. Воробей11. Гепард12. Гепард13. 18. 19. 21. 24.
26. 
_____________________[2]___________________________________________________________
Тигр2. Тигр3. Тигр6. Тигр9. Гепард14. Гепард15. 20. 22. 28. 
_____________________[3]___________________________________________________________
Тигр4. Тигр8. Гепард16. Гепард17. 25. 27. 
_____________________[4]___________________________________________________________
Тигр5. Тигр10. 23. 29. 
```
<p align="center">
  <img src="https://github.com/DemidovDG/pictures/raw/main/zooGraphColoringAlgorithm/true_graph_2.png" width="542px" height="385px"/></p>

