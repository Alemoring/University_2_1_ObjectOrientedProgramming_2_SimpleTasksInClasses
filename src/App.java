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
                    matrix[i][j] = (int) (((Math.random() * 100) % 10) + 1);
                }
            }
        }

        public Matrix(int rows, int columns) {
            matrix = new int[rows][columns];
            len = rows * columns;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = (int) (((Math.random() * 100) % 10) + 1);
                }
            }
        }

        public float findFrequency() {
            int kol = 0; // Количество заданного числа в массиве
            int x = 5;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == x)
                        kol += 1;
                }
            }
            return ((float) kol / len) * 100;
        }

        public float findFrequency(int x) {
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

        public String buildWord(char c) {
            word += c;
            len += 1;
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

        public String reverseSentence() {
            String reverse = "";
            char c = Character.toLowerCase(str.charAt(0));
            int i = 0;
            while (i < len) {
                Word word = new Word();
                while (c != ' ' && c != '.') {
                    word.buildWord(c);
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

        public Word consonantLetterSwapDefis() {
            int i = 0;
            char c = str.charAt(i);
            Word result = new Word();
            String wrong = "a e i o u y A E I O U Y. у е э о а ы я и ю У Е Э О А Ы Я И Ю";
            while (i < len) {
                if (wrong.indexOf(c) < 0) {
                    c = '-';
                }
                result.buildWord(c);
                i++;
                c = str.charAt(i);
            }
            result.buildWord('.');
            return result;
        }

        @Override
        public String toString() {
            return str;
        }

        public int findCountOfSameWord() {
            int length = 5;
            int i = 0;
            char c = str.charAt(i);
            int k = 0;
            while (i < len) {
                Word dops = new Word();
                while (c != ' ' && c != '.') {
                    dops.buildWord(c);
                    i++;
                    c = str.charAt(i);
                }
                if (dops.len == length) {
                    k++;
                    if (c != '.') {
                        i++;
                        c = str.charAt(i);
                    }
                } else if (c != '.') {
                    i++;
                    c = str.charAt(i);
                }
            }
            return k;
        }

        public int findCountOfSameWord(int length) {
            int i = 0;
            char c = str.charAt(i);
            int k = 0;
            while (i < len) {
                Word dops = new Word();
                while (c != ' ' && c != '.') {
                    dops.buildWord(c);
                    i++;
                    c = str.charAt(i);
                }
                if (dops.len == length) {
                    k++;
                    if (c != '.') {
                        i++;
                        c = str.charAt(i);
                    }
                } else if (c != '.') {
                    i++;
                    c = str.charAt(i);
                }
            }
            return k;
        }
    }

    public static void main(String[] args) throws Exception {
        // A
        System.out.println("Задание a");
        Matrix m1 = new Matrix(5, 5);
        m1.print();
        System.out.println("Относительная частота встречаемости = " + m1.findFrequency(5) + "%");
        System.out.println();

        // B
        System.out.println("Задание b");
        Sentence str = new Sentence();
        System.out.println("Исходное предложение: '" + str + "'");
        System.out.println("Перевёрнутое предложение: '" + str.reverseSentence() + "'");
        System.out.println();

        // C
        System.out.println("Задание c");
        Sentence line = new Sentence();
        System.out.println("Исходное предложение: '" + line + "'");
        System.out.println("Предложение с символом '-' вместо согласных: " + line.consonantLetterSwapDefis());
        System.out.println();

        // D
        System.out.println("Задание d");
        Sentence s = new Sentence("Hello I am Alex goodnight cat dog and mouse.");
        System.out.println("Исходное предложение: '" + s + "'");
        System.out.println("Количество слов длинной " + 5 + " = " + s.findCountOfSameWord());
    }
}