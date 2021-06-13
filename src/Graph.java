import java.util.Arrays;

public class Graph {
    // максимальный цвет
    private int maxC;
    // для запоминания максимального цвета
    private int remMaxC;
    // массив цветов для вершин
    private int[] colors;
    // для запоминания перед раскраской
    private int[] remColors;
    // матрица смежности графа
    private boolean[][] mat;
    // количество вершин
    private int maxV;
    // переменная в которой хранится путь, пройденный методом shag
    private int[] path;

    public Graph(boolean[][] mat) {
        this.mat = mat;
        this.colors = new int[mat.length];
        this.path = new int[mat.length];
        this.maxV = mat.length;
    }

    // окрасить вершину в минимальный допустимый цвет
    public void paintMinVertex(int vertex, boolean repaint) {
        // цвет для [vertex]
        int color;
        // если перекраска, то начальный минимальный цвет:
        // цвет [vertex] + 1
        if(repaint)
            color = this.colors[vertex] + 1;
        else
            color = 1;

        // запоминаем цвет
        int remC = color;

        // перебор индексов вершин < [vertex]
        for (int j = 0; j < vertex; j++) {
            for (int i = 0; i < vertex; i++)
                // если [i] смежная вершина и цвет вершины [i] = [remC]
                if (this.mat[i][vertex] && color == colors[i])
                    ++color;

            // если цвет не изменился после сравнений, то выйти из цикла
            if(remC == color)
                break;
            remC = color;
        }

        this.colors[vertex] = color;
    }
    // взять максимальный цвет вершин
    public int getMaxC() {
        int maxC = 1;
        for(int color : this.colors)
            if(color > maxC)
                maxC = color;

        return maxC;
    }
    // Вывод матрицы в консоль
    public void soutMat() {
        System.out.print("\t |");
        for (int i = 0; i < this.maxV; i++)
            if(i < 10)
                System.out.print("  " + i + " |");
            else if(i < 100)
                System.out.print("  " + i + "|");
            else if(i < 1000)
                System.out.print(" " + i + "|");
            else
                System.out.println(i + "|");

        System.out.println();

        for (int i = 0; i < this.maxV; i++) {
            if(i < 1000)
                System.out.print(i + "\t |");
            else
                System.out.print(i + " |");

            for (int j = 0; j < this.maxV; j++)
                if(this.mat[i][j])
                    System.out.print("XXXX|");
                else
                    System.out.print("____|");
            System.out.println();
        }
    }
    // Шаг вверх по графу
    // Шаг вверх по графу
    private int shag(int cursor) {
        // если делаем шаг из нулевой вершины
        if(this.path[cursor] == -1) {
            // если находимся на 0 или 1
            if(cursor < 2)
                // конец перекраски
                return -1;
            else {
                // шаг из CURSOR - 2
                for (int i = cursor; i < this.maxV; i++)
                    this.path[i] = 0;
                return (cursor - 2);
            }
        }
        // иначе, если делаем шаг НЕ из нулевой вершины
        // переменная(MAX_NEIGH) для запоминания максимального соседа
        int remMaxNeigh = 0;
        // Уже делали шаг из этой вершины?
        if(this.path[cursor+1] != 0)
            // максимальным соседом становится вершина, в которую уже делали шаг
            remMaxNeigh = this.path[cursor+1];
        else
            // иначе, максимальным соседом будет сама вершина, на которой курсор
            remMaxNeigh = this.path[cursor];

        // переменная ИСКОМОГО для максимального соседа
        int maxNeigh = -1;
        // перебираем все вершины меньше ЗАПОМНЕНОГО максимального соседа
        for (int i = remMaxNeigh-1; i >= 0 ; i--)
            // если вершина [i] соседняя с path[cursor]
            if(this.mat[i][this.path[cursor]]) {
                // присваиваем ее maxNeigh
                maxNeigh = i;
                // останавливаем поиск
                break;
            }

        // Есть сосед меньше MAX_NEIGH?
        if(maxNeigh != -1) {
            //Сосед НЕ нулевая вершина?
            if(maxNeigh != 0) {
                // Цвет соседа равен MAX_COLOR - 1 ?
                if(this.colors[maxNeigh] == this.maxC - 1) {
                    // записываем соседа дальше в путь
                    this.path[cursor+1] = maxNeigh;
                    // и делаем шаг из cursor + 1
                    return (cursor+1);
                }
                // иначе, если цвет соседа НЕ равен MAX_COLOR - 1
                else {
                    // цвет соседа можно поднять, чтобы он был меньше MAX_COLOR?
                    // пробуем поднять цвет
                    // запоминаем старый цвет соседа
                    int remColNeigh = this.colors[maxNeigh];

                    // поднимаем цвет соседа
                    this.paintMinVertex(maxNeigh, true);

                    // если цвет соседа меньше MAX_COLOR
                    if(this.colors[maxNeigh] < this.maxC) {
                        // перекрашиваем все последующие вершины
                        for (int i = maxNeigh+1; i < this.maxV; i++)
                            this.paintMinVertex(i, false);
                        // находим и записываем новый MAX_COLOR
                        this.maxC = this.getMaxC();

                        // если новый MAX_COLOR < remMaxColor
                        if(this.maxC < this.remMaxC) {
                            // запоминаем новый минимальный MAX_COLOR
                            this.remMaxC = this.maxC;
                            // запоминаем старую раскраску НА_ВСЯКИЙ
                            this.remColors = new int[maxV];
                            for (int i = 0; i < maxV; i++)
                                this.remColors[i] = this.colors[i];
                        }

                        // находим первую вершину с MAX_COLOR
                        for (int i = 0; i < this.maxV; i++) {
                            if(this.colors[i] == maxC) {
                                // обнуляем путь
                                this.path = new int[this.maxV];
                                // записываем ее в начало пути
                                this.path[0] = i;
                                // делаем шаг из начала пути
                                return 0;
                            }
                        }
                    }
                    // иначе, если цвет равен MAX_COLOR
                    else {
                        // возвращаем ему старый цвет
                        this.colors[maxNeigh] = remColNeigh;
                        // записываем его в путь дальше
                        this.path[cursor+1] = maxNeigh;
                        // делаем шаг из cursor + 1
                        return (cursor+1);
                    }
                }
            }
            // иначе, если сосед нулевая вершина
            else {
                // записываем -1 в путь дальше
                this.path[cursor+1] = -1;
                // и делаем шаг из cursor+1
                return (cursor+1);
            }
        }
        // иначе, если нет соседа меньше MAX_NEIGH
        else {
            // Цвет path[cursor] больше или равен MAX_COLOR - 1 ?
            if(this.colors[this.path[cursor]] >= this.maxC - 1) {
                // находимся в начале пути ?
                if(cursor == 0)
                    // Завершаем перекраску
                    return -1;
                    // иначе, когда НЕ находимся в начале пути
                else {
                    // делаем шаг из cursor - 1
                    for (int i = cursor+1; i < this.maxV; i++)
                        this.path[i] = 0;
                    return (cursor - 1);
                }
            }
            // иначе
            else {

                // поднимаем цвет вершины на 1
                this.colors[this.path[cursor]] = this.colors[this.path[cursor]] + 1;
                // перекрашиваем все последующие вершины
                for (int i = this.path[cursor]+1; i < this.maxV; i++)
                    this.paintMinVertex(i, false);
                // находим и устанавливаем новый MAX_COLOR
                this.maxC = this.getMaxC();

                // если новый MAX_COLOR < remMaxColor
                if(this.maxC < this.remMaxC) {
                    // запоминаем новый минимальный MAX_COLOR
                    this.remMaxC = this.maxC;
                    // запоминаем старую раскраску НА_ВСЯКИЙ
                    this.remColors = new int[maxV];
                    for (int i = 0; i < maxV; i++)
                        this.remColors[i] = this.colors[i];
                }

                // находим первую вершину с MAX_COLOR
                for (int i = 0; i < this.maxV; i++)
                    if(this.colors[i] == this.maxC) {
                        // Обнуляем путь
                        this.path = new int[this.maxV];
                        // записываем первую вершину с MAX_COLOR в начало пути
                        this.path[0] = i;
                        // делаем шаг из 0
                        return 0;
                    }
            }
        }

        // Быть не может
        System.out.println("Эта надпись никогда не должна выводится.");
        return -1;
    }

    public void paint() {

        // первоначальная раскраска
        for (int i = 0; i < this.maxV; i++)
            this.paintMinVertex(i, false);
        // Устанавливаем максимальный цвет после покраски
        this.maxC = this.getMaxC();

        // Запоминаем этот максимальный цвет
        this.remMaxC = this.maxC;
        // запоминаем старую раскраску НА_ВСЯКИЙ
        this.remColors = new int[maxV];
        for (int i = 0; i < maxV; i++)
            this.remColors[i] = this.colors[i];

        // Находим первую вершину с MAX_COLOR
        for (int i = 0; i < this.maxV; i++)
            // когда нашли вершину
            if(this.colors[i] == maxC) {
                // записываем ее в начало пути
                this.path[0] = i;

                int x = 0;

                while(x != -1)
                // делаем шаг из начала пути
                    x = this.shag(x);
                // заканчиваем цикл
                break;
            }

        System.out.println("Перекраска завершена.");
    }

    public static void main(String[] args) {
        Graph g = new Graph(Tests.SIX);
        System.out.println("maxV = " + g.getMaxV());
        System.out.println("maxC = " + g.getMaxC());
        System.out.println("remMaxC = " + g.getRemMaxCol());
        System.out.println("colors[]    = " + Arrays.toString(g.getColors()));
        System.out.println("remColors[] = " + Arrays.toString(g.getRemColors()));
        g.paint();
        System.out.println("SIX=============");
        System.out.println("maxV = " + g.getMaxV());
        System.out.println("maxC = " + g.getMaxC());
        System.out.println("remMaxC = " + g.getRemMaxCol());
        System.out.println("colors[]    = " + Arrays.toString(g.getColors()));
        System.out.println("remColors[] = " + Arrays.toString(g.getRemColors()));

    }



    //DEFAULT GETTERS
    public int[] getColors() {return this.colors;}
    public int getMaxV() {return this.maxV;}
    public int[] getPath() {return this.path;}
    public int[] getRemColors() {return this.remColors;}
    public int getRemMaxCol() {return this.remMaxC;}
    //DEFAULT SETTERS
    public void setMatrix(boolean[][] mat) {
        this.mat = mat;
        this.colors = new int[mat.length];
        this.path = new int[mat.length];
        this.maxV = mat.length;
    }
}
