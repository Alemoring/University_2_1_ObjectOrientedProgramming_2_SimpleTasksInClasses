/*
 *  19 вариант
 *  a) Подсчитайте относительную частоту встречаемости числа в данном двумерном массиве
 *  b) Переставьте слова в предложении в обратном порядке, соблюдая правила написания предложения
 *  с) Заменить все согласные буквы предложения на знак "-"
 *  d) Подсчитайте количество слов заданной длинны в предложении
 */

public class App {
    public static class Matrix {
        private int[][] matrix;
        private int len;

        public Matrix() {
            matrix = new int[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    matrix[i][j] = (int) (Math.random() * 100);
                }
            }
        }

        public Matrix(int rows, int columns) {
            matrix = new int[rows][columns];
            len = rows * columns;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = (int) (Math.random() * 100);
                }
            }
        }

        public float findfrequency() {
            int kol = 0; // Количество заданного числа в массиве
            int x = 50;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == x)
                        kol += 1;
                }
            }
            return ((float) kol / len) * 100;
        }

        public float findfrequency(int x) {
            int kol = 0; // Количество заданного числа в массиве
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == x)
                        kol += 1;
                }
            }
            return ((float) kol / len) * 100;
        }

        public void print() {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static class Word {
        String word;
        int len;

        public Word() {
            word = "";
            len = 0;
        }

        public String buildword(char c) {
            word += c;
            return word;
        }

        @Override
        public String toString() {
            return word;
        }
    }

    public static class Sentence {
        private String str;
        private int len;

        public Sentence() {
            str = new String("May the force be with you.");
            len = str.length() - 1;
        }

        public Sentence(String s) {
            str = s;
            len = str.length() - 1;
        }

        public String reverse_sentence() {
            String reverse = "";
            char c = Character.toLowerCase(str.charAt(0));
            int i = 0;
            while (i < len) {
                Word word = new Word();
                while (c != ' ' && c != '.') {
                    word.buildword(c);
                    i++;
                    c = str.charAt(i);
                }
                if (c != '.') {
                    i++;
                    c = str.charAt(i);
                }
                reverse = word + " " + reverse;
            }

            String firstch = reverse.substring(0, 1);
            String restofs = reverse.substring(1);
            firstch = firstch.toUpperCase();
            reverse = firstch + restofs;
            reverse = reverse.trim();
            reverse += ".";
            
            return reverse;
        }

        @Override
        public String toString() {
            return "Sentence: " + str + ", length: " + len;
        }
    }

    public static String exercise_b(String s) {
        char c = s.charAt(0);
        int i = 0;
        String result = "";
        while (i < s.length() - 1) {
            String dops = "";
            while (c != ' ' && c != '.') {
                dops += c;
                i++;
                c = s.charAt(i);
            }
            if (c != '.') {
                i++;
                c = s.charAt(i);
            }
            result = dops + " " + result;
        }
        String firstch = result.substring(0, 1);
        String restofs = result.substring(1);
        firstch = firstch.toUpperCase();
        result = firstch + restofs;
        result = result.trim();
        result += ".";
        return result;
    }

    public static String exercise_c(String s) {
        int i = 0;
        char c = s.charAt(i);
        String result = "";
        while (i < s.length() - 1) {
            if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' && c != 'y' && c != 'A' && c != 'E' && c != 'I'
                    && c != 'O' && c != 'U' && c != 'Y' && c != ' ' && c != '.') {
                c = '-';
            }
            result += c;
            i++;
            c = s.charAt(i);
        }
        result += '.';
        return result;
    }

    public static int exercise_d(String line, int len) {

        int i = 0;
        char c = line.charAt(i);
        int k = 0;
        while (i < line.length() - 1) {
            String dops = "";
            while (c != ' ' && c != '.') {
                dops += c;
                i++;
                c = line.charAt(i);
            }
            if (dops.length() == len) {
                k++;
                if (c != '.') {
                    i++;
                    c = line.charAt(i);
                }
            } else if (c != '.') {
                i++;
                c = line.charAt(i);
            }
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        // A
        System.out.println("Задание a");
        Matrix m1 = new Matrix(10, 10);
        m1.print();
        System.out.println("Относительная частота встречаемости = " + m1.findfrequency() + "%");
        System.out.println();

        // B
        /*
         * String s = "Да пребудет с тобой сила."; // Исходное предложение
         */
        System.out.println("Задание b");
        Sentence str = new Sentence();
        System.out.println("Исходное предложение: '" + str + "'");
        System.out.println("Перевёрнутое предложение: '" + str.reverse_sentence() + "'");
        System.out.println();

        // C
        /*
         * System.out.println("Задание c");
         * String str = "Hello I am Alex goodnight."; // Исходное предложение
         * System.out.println("Исходное предложение: '" + str + "'");
         * System.out.println("Предложение с символом '-' вместо согласных: " +
         * exercise_c(str));
         * System.out.println();
         */

        // D
        /*
         * System.out.println("Задание d");
         * String line = "Hello I am Alex goodnight cat dog and mouse."; // Исходное
         * предложение
         * int len = 5; // длинна искомых слов
         * System.out.println("Исходное предложение: '" + line + "'");
         * System.out.println("Количество слов длинной " + len + " = " +
         * exercise_d(line, len));
         */

    }
}