// aviary - вольер

import java.util.Arrays;

public class Zoo {
    // имена String[Порядковый_номер_животного] = "Название_животного" [N]
    private String[] names;
    // Матрица животных [N] [N]
    private boolean[][] mat;
    // матрица вольеров [N + 1] [N]
    private int[][] avi;
    // курсор, всегда должен быть на свободном месте в NAMES
    private int cursor;
    // для запоминания индекса(во время поиска)
    private int remIndex = -2;
    // для запоминания вольера(во время поиска)
    private int remAvi = -2;

    //+++При создании зоопарка
    public Zoo() {
        // по стандарту делаем следующее
        this.mat = new boolean[10][10];
        this.names = new String[10];
        this.avi = new int[10][10];
        this.cursor = 0;
    }
    //+++расширение имен[], животных[][], вольеров[][]
    private void expand() {
        System.out.println("Zoo.expand();");
        // переменная для расширения
        int n = 0;

        // если == 5000
        if(this.cursor == 5_000)
            n = 10_000;
            // если == 1000
        else if(this.cursor == 1_000)
            n = 5_000;
            // если == 100
        else if(this.cursor == 100)
            n = 1000;
            // если == 10
        else if(this. cursor == 10)
            n = 100;
        else {
            System.out.println("--- Такого быть не может(Zoo.expand)");
            return;
        }

        // расширяем массив имен
        String[] anoNames = new String[n];
        for (int i = 0; i < this.names.length; i++)
            anoNames[i] = this.names[i];
        this.names = anoNames;
        // расширяем матрицу животных
        boolean[][] anoMat = new boolean[n][n];
        for (int i = 0; i < this.mat.length; i++)
            for (int j = 0; j < this.mat.length; j++)
                anoMat[i][j] = this.mat[i][j];
        this.mat = anoMat;
        // расширяем матрицу вольеров
        this.avi = new int[n][n];

        System.out.println("Расширили вольеры до " + n);
    }
    //+++взять животное по индексу
    private String getNameAnim(int index) {
        if(index == -1)
            return this.names[0];
        return this.names[index];
    }
    //+++вручную добавить в вольер
    public void addInAvi(int av, int index) {
        System.out.println("Zoo.addInAvi(" + av + ", " + index + ");");
        // ищем первую свободную ячейку в вольере
        for (int i = 0; i < this.avi[av].length; i++)
            // если нашли, то
            if(this.avi[av][i] == 0) {
                // записываем 'index' животного в свободную ячейку
                this.avi[av][i] = (index == 0) ? -1 : index;
                // завершаем метод
                System.out.println("+++ Добавили в вольер №_" + av + "-" + i + " животное №_" + index);
                return;
            }
        // иначе, если нет свободной ячейки, то пишем об ошибке
        System.out.println("--- В вольере №_" + av + " нет места.");
    }

    //+++поиск, только в names(можно поставить сохраненный remNames)
    private int searchIndex(String name, String[] arrayNames) {
        System.out.println("Zoo.searchIndex(" + name + ");");

        for (int i = 0; i < arrayNames.length; i++) {
            // если дошли до конца, то стоп
            if(arrayNames[i] == null)
                break;

            if(arrayNames[i].equals(name)) {
                System.out.println("\t" + name + " успешно найден.");
                return i;
            }
        }

        // не найдено.
        System.out.println("\t--- " + name + " не найден.");
        return -2;
    }
    //+++удаление только из names, обнуление матрицы this.mat
    private void delNameMat(int index) {
        if(index < -1) {
            System.out.println("\t--- Животного нет в зоопарке");
            return;
        }
        System.out.println("Zoo.delNameMat([" + index + "] " + this.getNameAnim(index) + ");");
        // удаляем из names
        this.names[index] = this.names[this.cursor-1];
        this.names[this.cursor-1] = null;
        // удаляем из матрицы
        for (int i = 0; i < this.cursor; i++)
            if(this.mat[i][index]) {
                this.mat[i][index] = false;
                this.mat[index][i] = false;
            }
        for (int i = 0; i < this.cursor; i++)
            if(this.mat[i][this.cursor-1]) {
                this.mat[i][index] = true;
                this.mat[index][i] = true;
                this.mat[i][this.cursor-1] = false;
                this.mat[this.cursor-1][i] = false;
            }

        --this.cursor;
    }
    //+++удаление животного из вольера
    public void delAvi(String name) {
        System.out.println("Zoo.delAvi(" + name + ");");
        this.searchAvi(name);
        // если не найдено
        if(remAvi == -2) {
            System.out.println("\t--- " + name + " не удален, так как не найден.");
            return;
        }
        // запоминаем последний занятый индекс в вольере
        int lastInd = this.getFreeIndexAvi(remAvi)-1;
        // заменяем значения в индексах
        this.avi[remAvi][remIndex] = this.avi[remAvi][lastInd];
        this.avi[remAvi][lastInd] = 0;

        //на всякий
        remAvi = -2;
        remIndex = -2;
    }
    //+++взять первый свободный индекс в вольере N
    public int getFreeIndexAvi(int av) {
        for (int i = 0; i < this.avi[av].length; i++)
            if(this.avi[av][i] == 0)
                return i;

        System.out.println("\t--- В вольере №_" + av + " нет свободных индексов.");
        return -2;
    }
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////
    //+++добавление животного в NAMES
    public void add(String name) {
        System.out.println("Zoo.add(" + name + ");");
        if(name.equals("")) {
            System.out.println("\t--- Нельзя добавить без имени");
            return;
        }
        if(name.length() > 50) {
            System.out.println("--- Слишком длинное имя животного.");
            return;
        }
        // если переполнение, то
        if(this.cursor >= 10_000) {
            System.out.println("\t--- " + name + " не добавлен из-за переполнения.");
            // Завершение метода
            return;
        }
        // иначе, если НЕТ переполнения.
        // Поиск, есть ли уже такое животное в массиве names
        for(String s : this.names) {
            //если дошли до конца имен, то выходим из цикла
            if(s == null)
                break;
            // если есть, то
            if (s.equals(name)) {
                System.out.println("\t--- " + name + " уже есть.");
                // Завершение метода
                return;
            }
        }
        //иначе, если животного еще нет в массиве name.
        // Если, курсор выходит за пределы массива, то
        if(this.cursor == this.names.length)
            // расширяем таблицы
            this.expand();

        //Добавляем в массив имен
        this.names[this.cursor] = name;

        //Двигаем курсор дальше
        ++this.cursor;
        System.out.println("\tУспешно добавлен " + name);
    }
    //+++Создание и удаление связи
    public void edge(String one, String two, boolean adOrDel) {
        System.out.println("Zoo.edge(\"" + one + "\", \"" + two + "\", " + adOrDel + ");");
        int iOne = this.searchIndex(one, this.names);
        int iTwo = this.searchIndex(two, this.names);

        // если не существует "one"
        if(iOne == -2) {
            System.out.println("\t--- " + one + " не существует.");
            return;
        }
        // если не существует "two"
        if(iTwo == -2) {
            System.out.println("\t--- " + two + " не существует.");
            return;
        }
        // если добавляют связь между однин и тем же животным
        if(iOne == iTwo) {
            System.out.println("\t--- Нельзя добавить связь между один и тем же животным.");
            return;
        }

        // если надо добавить связь И уже есть связь между ними
        if(adOrDel && this.mat[iOne][iTwo]) {
            System.out.println("\t--- Связь между \"" + one + "\" и \"" + two + "\" уже существует.");
            return;
        }
        if(!adOrDel && !this.mat[iOne][iTwo]) {
            System.out.println("\t--- Связи между \"" + one + "\" и \"" + two + "\" не было.");
            return;
        }

        //иначе, ставим "true" в матрице животных
        if(adOrDel) {
            this.mat[iOne][iTwo] = true;
            this.mat[iTwo][iOne] = true;
            System.out.println("\tСвязь между \"" + one + "\" и \"" + two + "\" успешно добавлена.");
        }
        else {
            this.mat[iOne][iTwo] = false;
            this.mat[iTwo][iOne] = false;
            System.out.println("\tСвязь между \"" + one + "\" и \"" + two + "\" успешно удалена.");
        }
    }
    //+++Удаление животного из зоопарка
    public void delAll(String name) {
        this.delAvi(name);
        this.delNameMat(this.searchIndex(name, this.names));
    }
    //+++поиск по вольерам, записывает значения в remIndex, remAvi
    public void searchAvi(String name) {
        System.out.println("Zoo.searchAvi(" + name + ");");
        int ind = this.searchIndex(name, this.names);
        if(ind == 0)
            ind = -1;

        // пробегаем по всем вольерам
        for (int i = 0; i < this.avi.length; i++) {
            // если пустой вольер
            if(this.avi[i][0] == 0)
                // выходим из цикла
                break;

            // если вольер 'i' содержит животных
            for (int j = 0; j < this.avi[i].length; j++) {
                // если дошли до null, то выход из вольера
                if(this.avi[i][j] == 0)
                    break;
                if(this.avi[i][j] == ind) {
                    remAvi = i;
                    remIndex = j;
                    // завершаем поиск
                    System.out.println("\t" + name + " находится в вольере " + (remAvi+1) + "-" + (remIndex+1));
                    return;
                }
            }
        }

        // если не нашли, то
        remIndex = -2;
        remAvi = -2;
        System.out.println("\t--- " + name + " не нашелся в ВОЛЬЕРАХ.");
    }
    //+++Распределение по вольерам
    public void distribution() {
        System.out.println("Zoo.distribution();");
        // если животных нет
        if(this.cursor == 0) {
            System.out.println("\t--- Животных нет.");
            return;
        }
        // если одно животное
        if(this.cursor == 1) {
            this.avi[0][0] = -1;
            return;
        }

        // запоминаем матрицу
        boolean[][] remMat = new boolean[this.cursor][this.cursor];
        // заполняем ее элементами из матрицы животных
        // до cursor, это точно конец матрицы
        for (int i = 0; i < this.cursor; i++)
            for (int j = 0; j < this.cursor; j++)
                if(this.mat[i][j])
                    remMat[i][j] = this.mat[i][j];

        // очищаем вольеры
        this.avi = new int[this.cursor][this.cursor];

        //кусок матрицы

        // красим
        Graph g = new Graph(remMat);
        g.paint();
        // распределяем по вольерам
        int[] aviaries = g.getRemColors();

        for (int i = 0; i < aviaries.length; i++)
            this.addInAvi(aviaries[i]-1, i);

//////////////////////////////////////////////////
        System.out.println("Распределение завершено");
        return;
    }

    public static void main(String[] args) {
        Zoo z = new Zoo();
        // *ограничение 10000 животных
        //============================================
        // Добавить животное в зоопарк:
        //      z.add("Имя");
        // Удалить животное из зоопарка:
        //      z.delAll("Имя");
        // Добавить связь, что "Имя1" и "Имя2" не могут находится в одном вольере:
        //      z.edge("Имя1", "Имя2", true);
        // Удалить связь, что "Имя1" и "Имя2" не могут находится в одном вольере:
        //      z.edge("Имя1", "Имя2", false);
        // Распределить животных по вольерам
        //      z.distribution();
        // Вывести список животных
        //      z.soutNames();
        // Вывести матрицу связей
        //      z.soutMat();
        // Вывести информацию о вольерах
        //      z.soutAvi();
        // Найти в каком вольере "Имя"
        //      z.searchAvi("Имя");
        //============================================
        z.add("Тигр");
        z.add("Тигр1");
        z.add("Тигр2");
        z.add("Тигр3");
        z.add("Тигр4");
        z.add("Тигр5");
        z.add("Тигр6");
        z.add("Тигр7");
        z.add("Тигр8");
        z.add("Тигр9");
        z.add("Тигр10");
        z.edge("Тигр", "Тигр2", true);
        z.edge("Тигр", "Тигр3", true);
        z.edge("Тигр", "Тигр4", true);
        z.edge("Тигр1", "Тигр2", true);
        z.edge("Тигр1", "Тигр3", true);
        z.edge("Тигр1", "Тигр5", true);
        z.edge("Тигр1", "Тигр6", true);
        z.edge("Тигр1", "Тигр9", true);
        z.edge("Тигр1", "Тигр10", true);
        z.edge("Тигр2", "Тигр4", true);
        z.edge("Тигр2", "Тигр5", true);
        z.edge("Тигр3", "Тигр4", true);
        z.edge("Тигр4", "Тигр5", true);
        z.edge("Тигр6", "Тигр7", true);
        z.edge("Тигр6", "Тигр8", true);
        z.edge("Тигр7", "Тигр8", true);
        z.edge("Тигр7", "Тигр9", true);
        z.edge("Тигр8", "Тигр10", true);
        z.edge("Тигр9", "Тигр10", true);

        z.add("Воробей11");

        z.add("Гепард12");
        z.add("Гепард13");
        z.add("Гепард14");
        z.add("Гепард15");
        z.add("Гепард16");
        z.add("Гепард17");
        z.edge("Гепард12", "Гепард15", true);
        z.edge("Гепард12", "Гепард14", true);
        z.edge("Гепард13", "Гепард16", true);
        z.edge("Гепард13", "Гепард17", true);
        z.edge("Гепард14", "Гепард17", true);
        z.edge("Гепард15", "Гепард16", true);

        z.add("18");

        z.add("19");
        z.add("20");
        z.edge("19", "20", true);

        z.add("21");


        z.add("22");
        z.add("23");
        z.add("24");
        z.add("25");
        z.add("26");
        z.add("27");
        z.add("28");
        z.add("29");
        z.edge("22", "23", true);
        z.edge("22", "25", true);
        z.edge("22", "26", true);
        z.edge("22", "29", true);
        z.edge("23", "24", true);
        z.edge("23", "26", true);
        z.edge("23", "27", true);
        z.edge("24", "25", true);
        z.edge("24", "27", true);
        z.edge("24", "28", true);
        z.edge("25", "28", true);
        z.edge("25", "29", true);
        z.edge("26", "27", true);
        z.edge("26", "28", true);
        z.edge("26", "29", true);
        z.edge("27", "28", true);
        z.edge("27", "29", true);
        z.edge("28", "29", true);

// пример удаления, с кодом выше
        
        z.distribution();
        z.soutMat();
        z.soutAvi();
        z.soutNames();
    }



    //+++методы вывода
    public void soutNames() {
        System.out.println("Животные: ");
        if(this.cursor == 0)
            return;
        System.out.print("[0] " + this.names[0] + ". ");
        for (int i = 1; i < this.cursor; i++)
            System.out.print("[" + i + "] " + this.names[i] + ((i%10 == 0) ? ".\n" : ". "));
        System.out.println();
        System.out.println("////////////////////////////////////////////////////////////////////////////////");
    }
    public void soutMat() {
        System.out.println("Матрица связей:");
        if(this.cursor == 0)
            return;
        System.out.print("\t |");
        for (int i = 0; i < this.cursor; i++)
            if(i < 10)
                System.out.print("  " + i + " |");
            else if(i < 100)
                System.out.print("  " + i + "|");
            else if(i < 1000)
                System.out.print(" " + i + "|");
            else
                System.out.println(i + "|");

        System.out.println();

        for (int i = 0; i < this.cursor; i++) {
            if(i < 1000)
                System.out.print(i + "\t |");
            else
                System.out.print(i + " |");

            for (int j = 0; j < this.cursor; j++)
                if(this.mat[i][j])
                    System.out.print("XXXX|");
                else
                    System.out.print("____|");
            System.out.println();
        }
        System.out.println("////////////////////////////////////////////////////////////////////////////////");
    }
    public void soutAvi() {
        System.out.println("Вольеры:");
        for (int i = 0; i < this.avi.length; i++)
            // Если дошли до первого пустого вольера, то
            if(this.avi[i][0] == 0)
                break;
            // иначе, если вольер не пустой
            else {
                int ln = 1;
                System.out.println("_____________________[" + (i+1) + "]___________________________________________________________");
                // выводим всех животных
                for (int j : this.avi[i]) {
                    if(j < 1 && j != -1)
                        break;
                    System.out.print(this.getNameAnim(j) + ((ln%10 == 0) ? ".\n" : ". "));
                    ++ln;
                }
                System.out.println();
            }
        System.out.println("////////////////////////////////////////////////////////////////////////////////");
    }
}
